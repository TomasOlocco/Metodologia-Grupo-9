package example.com.infrastructure.http.router

import example.com.application.commands.DeletePostCommand
import example.com.application.commandhandlers.DeletePostHandler
import example.com.application.PostService
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
    val postService = PostService(postRepository)  // Instancia el servicio de posts

    routing {
        delete("/posts/{id}") {
            val postId = call.parameters["id"] ?: throw IllegalArgumentException("No ID provided")
            val command = DeletePostCommand(postId)
            deletePostAction.execute(command)
            call.respond(HttpStatusCode.NoContent)
        }

        // Nueva ruta para buscar posts por usuario
        get("/posts") {
            val userId = call.parameters["userId"] ?: return@get call.respondText(
                "User ID is required", status = HttpStatusCode.BadRequest
            )
            val order = call.request.queryParameters["order"] ?: "ASC"
            val limit = call.request.queryParameters["limit"]?.toIntOrNull() ?: 10
            val offset = call.request.queryParameters["offset"]?.toIntOrNull() ?: 0

            // Llamar al servicio para buscar los posts
            val posts = postService.searchPostsByUser(userId, order, limit, offset)
            call.respond(posts)
        }
    }
}
