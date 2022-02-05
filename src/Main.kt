val parking = Parking(mutableSetOf())
fun main() {
    val car = Vehicle("AA111AA", VehicleType.CAR, discountCard = "DISCOUNT_CARD_001")
    val moto = Vehicle("B222BBB", VehicleType.MOTORCYCLE)
    val minibus = Vehicle("CC333CC", VehicleType.MINIBUS)
    val bus = Vehicle("DD444DD", VehicleType.BUS)
    val car1 = Vehicle("AA222AA", VehicleType.CAR, discountCard = "DISCOUNT_CARD_002")
    val moto1 = Vehicle("B333BBB", VehicleType.MOTORCYCLE)
    val minibus1 = Vehicle("CC444CC", VehicleType.MINIBUS)
    val bus1 = Vehicle("DD555DD", VehicleType.BUS)
    val car2 = Vehicle("AA333AA", VehicleType.CAR, discountCard = "DISCOUNT_CARD_003")
    val moto2 = Vehicle("B444BBB", VehicleType.MOTORCYCLE)
    val minibus2 = Vehicle("CC555CC", VehicleType.MINIBUS)
    val bus2 = Vehicle("DD666DD", VehicleType.BUS)
    val car3 = Vehicle("AA444AA", VehicleType.CAR, discountCard = "DISCOUNT_CARD_004")
    val moto3 = Vehicle("BB555BB", VehicleType.MOTORCYCLE)
    val minibus3 = Vehicle("CC666CC", VehicleType.MINIBUS)
    val bus3 = Vehicle("DD777DD", VehicleType.BUS)
    val car4 = Vehicle("AA555AA", VehicleType.CAR, discountCard = "DISCOUNT_CARD_005")
    val moto4 = Vehicle("B666BBB", VehicleType.MOTORCYCLE)
    val minibus4 = Vehicle("CC777CC", VehicleType.MINIBUS)
    val bus4 = Vehicle("DD888DD", VehicleType.BUS)
    val car5 = Vehicle("AA888AA", VehicleType.CAR, discountCard = "DISCOUNT_CARD_006")

    val vehiclesSet = mutableSetOf(
        car, moto, minibus, bus,
        car1, moto1, minibus1, bus1,
        car2, moto2, minibus2, bus2,
        car3, moto3, minibus3, bus3,
        car4, moto4, minibus4, bus4,
        car5)

    //imprime en pantalla el ingreso de vehiculos con un mensaje ademas de dar un mensaje cuando no se puede
    vehiclesSet.forEach() {
        parking.addVehicle(it).also(::println)
    }

    val parkable = Parkable(vehiclesSet)

    //prueba de salidas de vehiculos
    parkable.checkOutVehicle("B222BBB", {it}, {})  //ok
    parkable.checkOutVehicle("DD999DD", {it}, {}) //error porque no existe

    //ganancias por vehiculos salidos
    parkable.getEarnings()

    //lista con las patentes ingresadas
    println(parkable.listVehicle())

}