open class Parking(
    open val vehicles: MutableSet<Vehicle>,
    open val maxSpot: Int = 20,
) {
    //esta funcion permite limitar el ingreso de mas de 20 vehiculos, ademas de colocar un mensaje cuando esta lo supera
    fun addVehicle(vehicle: Vehicle): String {
        return when (maxSpot - vehicles.size) {
            in 1..maxSpot -> {
                vehicles.add(vehicle)
                "Welcome to AlkeParking!"
            }
            else -> "Sorry, the check-in failed"
        }
    }
}