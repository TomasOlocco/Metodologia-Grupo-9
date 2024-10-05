// application/UserService.kt
package application

import domain.Usuario
import domain.RepoUsuario

class `ManejoUsuarios.kt`(private val repoUsuario: RepoUsuario) {

    fun registroUsuario(usuario: Usuario): Usuario {
        if (repoUsuario.buscarXnombreEmail(user.username, user.email)) {
            throw IllegalArgumentException("El nombre o el usuario ya existen.")
        }
        return repoUsuario.save(usuario)
    }

    fun buscarPorId(id: String): Usuario? {
        return repoUsuario.buscarPorId(id)
    }

    fun nuevoUsuario(usuario: Usuario): Usuario {
        return repoUsuario.update(usuario)
    }
}
