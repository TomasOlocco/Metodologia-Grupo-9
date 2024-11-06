package utn.methodology.domain.entities

import java.time.LocalDateTime
import java.util.UUID

data class Post(
    val id: UUID? = null, // ID del post, puede ser generado automáticamente
    val contenido: String,
    val fechaCreacion: LocalDateTime,
    val autor: String // Puedes usar el ID del usuario si prefieres
)
