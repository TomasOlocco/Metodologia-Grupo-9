package utn.methodology.domain.entities

import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class `Seguidor.kt`(
    val idSeguidor: String,
    val idSeguido: String
)