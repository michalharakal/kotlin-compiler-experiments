package org.kartbahn.api.model

import org.kartbahn.api.Builder

data class RoadWork(val name: String)

@Builder
data class Warning(
    val warningId: String,
    val title: String,
    val subtitle: String,
)

data class ElectricChargingStation(val name: String)

@Builder
data class Road(
    val name: String,
    val roadWork: List<RoadWork>,
    val warnings: List<Warning>,
    val electricChargingStations: List<ElectricChargingStation>
)
