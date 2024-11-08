package utn.methodology.infrastructure.http.router

import utn.methodology.application.commands*
import utn.methodology.infrastructure.http.actions*
import utn.methodology.infrastructure.persistence*
import utn.methodology.application.commandhandlers.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.userRouter() {
    val mongoDatabase = connectToMongoDB()

    val userMongoUserRepository = MongoUserRepository(mongoDatabase)

    routing {
        get("/users") {
            val users = userMongoUserRepository.findAll();

            call.respond(HttpStatusCode.OK, users.map { it.toPrimitives() })
            }
        }
}