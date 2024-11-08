import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import utn.methodology.domain.entities.Seguidor
import.utn.methodology.application.commandhandlers.PostHandler

class PostHandler(private val postQuery: PostQuery) {

    // Función para manejar la solicitud GET de los posts de los usuarios seguidos
    suspend fun handleGetPosts(call: ApplicationCall) {
        val userId = call.parameters["idSeguido"]?.toIntOrNull()  // Obtener el ID del usuario de la URL

        if (userId == null) {
            call.respond(HttpStatusCode.BadRequest, "User ID no válido.")  // Responder si el ID es inválido
            return
        }
        if (post.isEmpty()) {
            call.respond(HttpStatusCode.NoContent, "No se encontraron posts.")  // Si no hay posts, responder con No Content
        } else {
            call.respond(post)  // Devolver los posts obtenidos
        }
    }
}
