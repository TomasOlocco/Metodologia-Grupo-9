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
}