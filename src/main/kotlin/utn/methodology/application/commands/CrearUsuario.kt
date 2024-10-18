//creacion del usuario

data class crearUsuario(
    val nombre: string,
    val apellido: string,
    val email: string,
) {
    fun validate:crearUsuario{
        checkNotNull(nombre) { throw IllegalArgumentException("Ingrese un nombre") }
        checkNotNull(apellido) { throw IllegalArgumentException("Ingrese un apellido") }
        checkNotNull(email) { throw IllegalArgumentException("Ingrese su email") }

        return this;
    }
}