import java.time.LocalDateTime

data class Post(
    val id: Int,
    val contenido: String,
    val fechaCreacion: LocalDateTime,
    val Autor: String,
)