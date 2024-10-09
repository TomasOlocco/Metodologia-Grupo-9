package utn.methodology.infrastructure.http.router

import example.com.application.commands.CreateUserCommand
import example.com.application.commands.UpdateUserCommand
import example.com.application.commandhandlers.CreateUserHandler
import example.com.application.commandhandlers.DeleteUserHandler
import example.com.application.commandhandlers.UpdateUserHandler
import example.com.application.commands.DeleteUserCommand
import example.com.application.queries.FindUserByIdQuery
import example.com.application.queryhandlers.FindUserByIdHandler
import example.com.infrastructure.http.actions.CreateUserAction
import example.com.infrastructure.http.actions.DeleteUserAction
import example.com.infrastructure.http.actions.FindUserByIdAction
import example.com.infrastructure.http.actions.UpdateUserAction
import example.com.infrastructure.persistence.MongoUserRepository
import example.com.infrastructure.persistence.connectToMongoDB
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