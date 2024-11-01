package utn.methodology.domainentities

import java.util.UUID

//REPO USUARIO
interface RepoUsuario {
    fun save(usuario: Usuario)
    fun excepcionExistencia(nombreUsuario: String): Boolean
    fun excepcionExistenciaEmail(email: String): Boolean
}
data class Usuario(
    @BsonId val id: UUID? = null,  // El campo 'id' es un UUID
    val nombre: String,
    val email: String,
    val contrasena: String
)

// domain/UserRepository.kt
package domain

interface repoUsuario {
    fun guardar(usuario: Usuario): Usuario
    fun buscarPorId(id: String): Usuario?
    fun nuevoUsuario(usuario: Usuario): Usuario
    fun buscarXnombreEmail(nombre: String, email: String): Boolean
}