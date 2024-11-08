import utn.methodology.domain.entities.Seguidor
import.utn.methodology.application.commandhandlers.PostHandler
class PostRepository {

  /*  private val posts = listOf(
        Post(1, 1, "Este es el primer post", 1634575600000), // Fecha: 18 Oct 2021
        Post(2, 2, "Este es otro post", 1634662000000), // Fecha: 19 Oct 2021
        Post(3, 1, "Otro post del primer usuario", 1634748400000), // Fecha: 20 Oct 2021
        Post(4, 3, "Post del tercer usuario", 1634834800000), // Fecha: 21 Oct 2021
        Post(5, 2, "Nuevo post del segundo usuario", 1634921200000) // Fecha: 22 Oct 2021
    )*/

    // Método para obtener los posts de los usuarios seguidos
    fun getPostsByUserIds(idSeguido: List<Int>): List<Post> {
        return post.filter { it.idSeguido in idSeguido }
    }
}
