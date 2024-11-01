package example.com.infrastructure.http.router

import example.com.application.commands.DeletePostCommand
import example.com.application.commandhandlers.DeletePostHandler
import example.com.infrastructure.http.actions.DeletePostAction
import example.com.infrastructure.persistence.MongoPostRepository
import example.com.infrastructure.persistence.connectToMongoDB
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.postRouter() {
    val mongoDatabase = connectToMongoDB()

    val postRepository = MongoPostRepository(mongoDatabase)
    val deletePostAction = DeletePostAction(DeletePostHandler(postRepository))

    routing {
        delete("/posts/{id}") {
            val postId = call.parameters["id"] ?: throw IllegalArgumentException("No ID provided")
            val command = DeletePostCommand(postId)
            deletePostAction.execute(command)
            call.respond(HttpStatusCode.NoContent)
            }
        }
}