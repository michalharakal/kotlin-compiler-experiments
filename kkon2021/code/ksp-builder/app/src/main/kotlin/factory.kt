import org.kartbahn.api.model.RoadBuilder
import org.kartbahn.api.model.WarningBuilder

fun main() {
    val road = RoadBuilder()
        .withName("A3")
        .withRoadWork(emptyList())
        .withWarnings(
            listOf(
                WarningBuilder()
                    .withWarningId("A3-1")
                    .withTitle("Bauarbeiten")
                    .withSubtitle("Viel zu tun")
                    .build()
            )
        )
        .withElectricChargingStations(emptyList())
        .build()
    println(road)
}