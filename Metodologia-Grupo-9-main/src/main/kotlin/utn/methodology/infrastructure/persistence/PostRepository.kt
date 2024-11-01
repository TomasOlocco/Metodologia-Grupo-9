interface PostRepository {
    fun save(post: Post): Post
    fun findAll(): List<Post>
    // Otros métodos según tus necesidades (buscar por autor, fecha, etc.)
}