    // infrastructure/DatabaseUserRepository.kt
package infrastructure

import com.mongodb.client.MongoCollection
import domain.Usuario
import domain.RepoUsuario
import org.litote.kmongo.eq
import org.litote.kmongo.getCollection

class `repoUsuarioBD.kt` : RepoUsuario {

    private val database = MongoDatabaseFactory.getDatabase()
    private val collection: MongoCollection<User> = database.getCollection()

    override fun buscarPorId(id: UUID): Usuario? {
        return collection.find(Usuario:id eq id).firstOrNull()
    }

    override fun findById(id: String): Usuario? {
        return usuarios.find { it.id == id }
    }

    override fun update(usuario: Usuario): Usuario {
        val index = usuarios.indicePrimero { it.id == user.id }
        if (index != -1) {
            usuarios[index] = usuario
        }
        return usuario
    }

    override fun buscarXnombreEmail(nombre: String, email: String): Boolean {
        return usuarios.any { it.nombre == nombre || it.email == email }
    }
}
