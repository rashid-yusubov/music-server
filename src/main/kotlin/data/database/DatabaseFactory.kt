package com.rashidyusubov.musicserver.data.database

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.github.cdimascio.dotenv.dotenv
import org.jetbrains.exposed.sql.Database

object DatabaseFactory {

    private val dotenv = dotenv()

    fun init() {

        val config = HikariConfig().apply {

            jdbcUrl = dotenv["DATABASE_URL"]

            driverClassName = "org.postgresql.Driver"

            maximumPoolSize = 10

            isAutoCommit = false

            transactionIsolation = "TRANSACTION_REPEATABLE_READ"

            validate()
        }

        val dataSource = HikariDataSource(config)

        Database.connect(dataSource)
    }
}