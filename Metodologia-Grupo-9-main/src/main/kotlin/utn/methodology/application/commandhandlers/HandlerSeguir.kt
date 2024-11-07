package utn.methodology.application.commandhandlers

import utn.methodology.domain.entities.Follower
import utn.methodology.infrastructure.persistence.RepoSeguidor

class HandlerSeguir(private val repoSeguidor: RepoSeguidor) {

    fun seguir(idSeguidor: String, idSeguido: String) {
        if (idSeguidor == idSeguido) {
            throw excepcionSeguidor("No podes seguirte a vos mismo.")
        }
        val seguidor = Seguidor(idSeguidor, idSeguido)
        RepoSeguidor.seguir(seguidor)
    }

    fun dejarSeguir(idSeguidor: String, idSeguido: String) {
        RepoSeguidor.dejarSeguir(idSeguidor, idSeguido)
    }
}

class excepcionSeguidor(message: String) : Exception(message)