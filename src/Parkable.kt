import kotlin.math.ceil
import kotlin.math.roundToInt

open class Parkable(
    override val vehicles: MutableSet<Vehicle>,
    var totalCar: Int = 0,
    var totalFee: Int = 0
) : Parking(vehicles) {

    //funcion sacar vehiculo
    fun checkOutVehicle(plate: String, onSuccess: (Int) -> Int, onError: () -> Unit) {
        val findVehicle = vehicles.filter { it.plate == plate }
        if (findVehicle.isNotEmpty()) {
            val feeTotal = calculateFee(
                findVehicle[0].vehicleType,
                findVehicle[0].parkedTime.toInt(),
                findVehicle[0].discountCard?.isNotEmpty() ?: false)
            totalCar++
            totalFee += feeTotal
            onSuccess(feeTotal)
            vehicles.remove(findVehicle[0])
            println("Your fee $$feeTotal. Come back soon.")

        } else {
            onError()
            println("Sorry, the check-out failed")
        }
    }

    //funcion para calcular la tarifa
    fun calculateFee(type: VehicleType, parkedTime: Int, hasDiscountCard: Boolean): Int {
        if (parkedTime > 120) {
            val blocks = (parkedTime.toFloat() - 120) / 15
            val round = (ceil(blocks)).toInt()
            val totalPrice = when (type) {
                VehicleType.CAR -> (round * 5) + VehicleType.CAR.fee
                VehicleType.MOTORCYCLE -> (round * 5) + VehicleType.MOTORCYCLE.fee
                VehicleType.BUS -> (round * 5) + VehicleType.BUS.fee
                VehicleType.MINIBUS -> (round * 5) + VehicleType.MINIBUS.fee
            }
            return if (hasDiscountCard) {
                (totalPrice * 0.85).roundToInt()
            } else {
                return totalPrice
            }
        } else {val totalPrice = when (type) {
            VehicleType.CAR -> VehicleType.CAR.fee
            VehicleType.MOTORCYCLE -> VehicleType.MOTORCYCLE.fee
            VehicleType.BUS -> VehicleType.BUS.fee
            VehicleType.MINIBUS -> VehicleType.MINIBUS.fee
        }
            return if (hasDiscountCard) {
                (totalPrice * 0.85).roundToInt()
            } else {
                return totalPrice
            }
        }
    }

    //funcion calculo de la ganancia
    fun getEarnings() {
        var finalCheckout: Pair<Int, Int> = Pair(totalCar, totalFee)
        println("${finalCheckout.first} vehicles have checked out and have earning 0f $${finalCheckout.second}")
    }

    //funcion para mostrar el listado de patentes
    fun listVehicle(): List<String> =  vehicles.map { it.plate }
}
