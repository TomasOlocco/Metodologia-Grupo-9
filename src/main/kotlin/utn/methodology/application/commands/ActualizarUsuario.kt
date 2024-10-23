package utn.methodology.application.commands

//actualizar usuarios

data class actualizarUsuario(
    val nombre: String,
    val apellido: String,
) {
    var id: String = ""

    fun validaciones(): actualizarUsuario {
        checkNotNull(id) { throw IllegalArgumentException("Id debe ser definido") }
        check(id.isNotEmpty()) { throw IllegalArgumentException("Id debe ser definido") }
        checkNotNull(nombre) { throw IllegalArgumentException("El nombre debe ser definido") }
        checkNotNull(apellido) { throw IllegalArgumentException("El apellido debe ser definido") }

        return this;
    }
}
