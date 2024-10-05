package example.com.domain.entities

class Usuario(
    private val id: String,
    private var nombre: String,
    private var apellido: String,
    private val email: String,
)
{

    companion object {
        fun fromPrimitives(primitives: Map<String, String>): User {

            val user = User(
                primitives["id"] as String,
                primitives["nombre"] as String,
                primitives["apellido"] as String,
                primitives["email"] as String
            );

            return user;
        }
    }


    fun getId(): String {
        return this.id;
    }

    fun update(nombre: String, apellido: String) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    fun toPrimitives(): Map<String, String> {
        return mapOf(
            "id" to this.id,
            "nombre" to this.nombre,
            "apellido" to this.apellido,
            "email" to this.email
        )
    }
}