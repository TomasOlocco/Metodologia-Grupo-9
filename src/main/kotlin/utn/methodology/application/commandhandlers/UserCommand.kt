package utn.methodology.application.handlers

import utn.methodology.application.commands.CreateUserCommand
import utn.methodology.domain.exceptions.UserAlreadyExistsException
import utn.methodology.domain.repository.UserRepository

class CreateUserHandler(private val repoUsuario: RepoUsuario) {
    fun handle(command: CreateUserCommand) {
        //valida si el usuario ya existe
        if (userRepository.existsByUsername(command.username)) {
            throw excepcionExistencia("El usuario ya existe")
        }

        if (userRepository.existsByEmail(command.email)) {
            throw excepcionExistenciaEmail("El email ya existe")
        }

        // Si pasa las validaciones, guardar el usuario
        userRepository.save(command.toUser())
    }

    private fun CreateUserCommand.toUser() = Usuario(
        nombreUsuario = this.nombreUsuario,
        email = this.email,
        contrasena = this.contrasena
    )
}
