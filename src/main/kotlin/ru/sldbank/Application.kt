package ru.sldbank

import io.ktor.server.application.*
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo
import ru.sldbank.plugins.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    val mongoPassword = System.getenv("MONGO_PASSWORD")
    val dbName = "sldbank"
    val db = KMongo.createClient(
        connectionString = "mongodb+srv://abonglz073:$mongoPassword@cluster0.fnyy1du.mongodb.net/$dbName?retryWrites=true&w=majority"
    ).coroutine.getDatabase(dbName)

    configureSecurity()
    configureSerialization()
    configureMonitoring()
    configureRouting()
}
