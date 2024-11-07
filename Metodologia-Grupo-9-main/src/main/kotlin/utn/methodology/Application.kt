package utn.methodology

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.http.*
import io.ktor.serialization.jackson.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.request.*
import io.ktor.server.response.*
import org.slf4j.LoggerFactory
import utn.methodology.infrastructure.persistence.configureDatabases
import com.mongodb.ConnectionString
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import io.ktor.application.*
import io.ktor.config.*
import org.litote.kmongo.KMongo

fun Application.module() {
    val config = environment.config
    val mongoUri = config.property("db.mongo.uri").getString()

    // Crea el cliente de MongoDB
    val mongoClient: MongoClient = KMongo.createClient(ConnectionString(mongoUri))
    val database = mongoClient.getDatabase("<NOMBRE_DE_TU_BASE_DE_DATOS>")

    // Log para confirmar la conexión
    environment.log.info("Intentando conectar a MongoDB...")

    // Usa `database` para interactuar con MongoDB en las rutas o servicios de tu aplicación
    environment.log.info("Conexión a MongoDB exitosa: ${database.name}")
}



fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.errorHandler() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            utn.methodology.logError(call, cause)

            if (cause is NotFoundException) {
                call.respond(HttpStatusCode.NotFound, mapOf("error" to cause.message))
            } else {
                call.respond(HttpStatusCode.InternalServerError, mapOf("error" to "Internal server error"))
            }

        }
    }
}

fun Application.module() {
    install(ContentNegotiation) {
        json()
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }

    configureDatabases()
    userRouter()
    errorHandler()
    postRouter()

}



fun logError(call: ApplicationCall, cause: Throwable) {
    val log = LoggerFactory.getLogger("ErrorLogger")
    val requestUri = call.request.uri
    log.error("Error at $requestUri: ${cause.localizedMessage}", cause)
}