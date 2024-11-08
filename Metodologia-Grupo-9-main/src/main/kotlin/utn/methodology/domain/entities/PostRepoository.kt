package utn.methodology.domain.entities

// Define la interfaz para el repositorio de posts
interface PostRepository {
    fun save(post: Post): Post
    fun findByUserId(userId: String, order: String, limit: Int, offset: Int): List<Post>
    fun findById(id: String): Post?
    fun deleteById(id: String): Boolean
}
