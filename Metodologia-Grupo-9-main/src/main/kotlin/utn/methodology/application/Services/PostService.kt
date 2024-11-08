class PostService(private val postRepository: PostRepository) {
    fun createPost(contenido: String, autor: String): Post {
        // Validaciones
        if (contenido.length > 255) {
            throw IllegalArgumentException("El contenido del post es demasiado largo")
        }

        val post = Post(
            // Genera un ID único
            id = generateId(),
            contenido = contenido,
            fechaCreacion = LocalDateTime.now(),
            autor = autor
        )

        return postRepository.save(post)
    }
    fun searchPostsByUser(
        userId: String,
        order: String = "ASC",
        limit: Int = 10,
        offset: Int = 0
    ): List<Post> {
        require(userId.length <= 36) { "User ID too long" }
        require(limit in 1..100) { "Limit must be between 1 and 100" }

        val isAscending = when(order.uppercase()) {
            "ASC" -> true
            "DESC" -> false
            else -> throw IllegalArgumentException("Order must be ASC or DESC")
        }

        return postRepository.findPostsByUser(userId, isAscending, limit, offset)
    }
}