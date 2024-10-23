package utn.methodology.application.commands

//eliminar usuarios

class borrarUsuario(
    val id: String,
){
    fun validaciones():borrarUsuario{
        checkNotNull(id) {throw IllegalArgumentException("El ID debe ser definido")}
        return this
    }
}