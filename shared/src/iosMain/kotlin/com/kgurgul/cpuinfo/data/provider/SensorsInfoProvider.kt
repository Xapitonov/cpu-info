package com.kgurgul.cpuinfo.data.provider

import com.kgurgul.cpuinfo.domain.model.SensorData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import org.koin.core.annotation.Factory

@Factory
actual class SensorsInfoProvider actual constructor() {

    actual fun getSensorData(): Flow<List<SensorData>> = emptyFlow()
}