package utn.methodology.application.commands

//creacion del usuario

data class crearUsuario(
    val nombre: String,
    val apellido: String,
    val email: String,
) {
    fun validate():crearUsuario{
        checkNotNull(nombre) { throw IllegalArgumentException("Ingrese un nombre") }
        checkNotNull(apellido) { throw IllegalArgumentException("Ingrese un apellido") }
        checkNotNull(email) { throw IllegalArgumentException("Ingrese su email") }

        return this;
    }
}
