import java.util.*

data class Vehicle(
    val plate: String,
    val vehicleType: VehicleType,
    val checkInTime: Calendar = Calendar.getInstance(),
    val discountCard: String? = null,
    val parkedTime: Long = (Calendar.getInstance().timeInMillis - checkInTime.timeInMillis) / 60000
) {

    override fun equals(other: Any?): Boolean {
        if (other is Vehicle) {
            return this.plate == other.plate
        }
        return super.equals(other)
    }
    override fun hashCode(): Int {
        return this.plate.hashCode()
    }


}