package com.rashidyusubov.musicserver

import com.rashidyusubov.musicserver.plugins.configureMonitoring
import com.rashidyusubov.musicserver.plugins.configureRouting
import com.rashidyusubov.musicserver.plugins.configureSerialization
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureMonitoring()
    configureSerialization()
    configureRouting()
}