package utn.methodology.domain.entities

<<<<<<< HEAD
import kotlinx.serialization.Serializable
import java.util.*
@Serializable
data class Post(
    val id: String,
    val userId: String,
    val message: String,
    val createdAt: String

) {

    companion object {
        fun fromPrimitives(primitives: Map<String, String>): Post {
            return Post(
                primitives["_id"] ?: "",
                primitives["userId"] ?: "",
                primitives["message"] ?: "",
                primitives["createdAt"] ?: ""
            )
        }
    }

    fun toPrimitives(): Map<String, Any> {
        return mapOf(
            "id" to this.id,
            "userId" to this.userId,
            "message" to this.message,
            "createdAt" to this.createdAt

        )
    }
}
=======
import java.time.LocalDateTime
import java.util.UUID

data class Post(
    val id: UUID? = null, // ID del post, puede ser generado automáticamente
    val contenido: String,
    val fechaCreacion: LocalDateTime,
    val autor: String // Puedes usar el ID del usuario si prefieres
)
>>>>>>> 67a5c903ea79288e8a0a5620008a40c348dddfcd
