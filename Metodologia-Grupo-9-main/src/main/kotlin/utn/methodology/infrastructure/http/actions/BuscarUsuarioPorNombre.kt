package utn.methodology.infrastructure.http.actions
import utn.methodology.application.commandhandlers.SearchUserHandler
import utn.methodology.domainentities.User
import utn.methodology.infrastructure.persistence.Repositories.UserMongoRepository

class SearchUserAction(private val handler: SearchUserHandler) {

    fun execute(username: String): User? {
        return handler.handler(username)  // Delegar al handler la búsqueda
    }
}