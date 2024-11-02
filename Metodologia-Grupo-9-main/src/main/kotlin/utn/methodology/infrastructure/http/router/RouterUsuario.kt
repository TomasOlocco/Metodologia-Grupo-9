import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

package utn.methodology.infrastructure.http.router

fun Application.userRouter() {
    val mongoDatabase = connectToMongoDB()

    val usuarioMongoUserRepository = MongoUsuarioRepository(mongoDatabase)

    routing {
        get("/usuario") {
            val usuario = usuarioMongoUserRepository.findAll();

            call.respond(HttpStatusCode.OK, users.map { it.toPrimitives() })
        }
    }
}