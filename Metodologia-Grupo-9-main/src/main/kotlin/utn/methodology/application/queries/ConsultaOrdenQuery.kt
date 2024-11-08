import utn.methodology.domain.entities.Seguidor

class PostQuery(private val postRepository: PostRepository) {

    // Consulta que obtiene los posts filtrados y ordenados por fecha
    fun getPostsByFollowedUsers(idSeguido: List<Int>): List<Post> {
        val posts = postRepository.getPostsByUserIds(idSeguido)
        return posts.sortedByDescending { it.createdAt } // Ordenar por fecha (más recientes primero)
    }
}
