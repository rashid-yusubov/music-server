package com.rashidyusubov.musicserver

import com.rashidyusubov.musicserver.data.database.DatabaseFactory
import com.rashidyusubov.musicserver.data.database.DatabaseSeeder
import com.rashidyusubov.musicserver.plugins.configureMonitoring
import com.rashidyusubov.musicserver.plugins.configureRouting
import com.rashidyusubov.musicserver.plugins.configureSerialization
import com.rashidyusubov.musicserver.utils.FirebaseFactory
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    DatabaseFactory.init()
    DatabaseSeeder.seed()
    FirebaseFactory.init()
    configureMonitoring()
    configureSerialization()
    configureRouting()
}