package com.kgurgul.cpuinfo.data.provider

import org.koin.core.component.KoinComponent

actual class PackageNameProvider actual constructor() : KoinComponent {

    actual suspend fun getPackageName(): String {
        return "com.kgurgul.cpuinfo"
    }
}
