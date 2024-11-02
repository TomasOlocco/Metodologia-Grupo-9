package utn.methodology.application.commands

//ELIMINAR USUARIOS
class borrarUsuario(
    val id: string,
){
    fun validaciones():borrarUsuario{
        checkNotNull(id) {throw IllegalArgumentException("El ID debe ser definido")}
        return this
    }
}