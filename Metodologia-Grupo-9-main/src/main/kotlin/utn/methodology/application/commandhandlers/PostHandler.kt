package utn.methodology.application.commandhandlers

import utn.methodology.domainentities.Post
import utn.methodology.infrastructure.persistence.Repositories.PostMongoRepository

class PostHandler(
    private val postRepository: PostMongoRepository
) {

    fun createPost(userId: String, message: String): Post {
        if (message.length > 100) {
            throw PostValidationException("El mensaje no puede exceder los 100 caracteres")
        }

        // Crea un mapa con los parámetros a buscar
        val primitives = mapOf(
            "userId" to userId,
            "message" to message
        )

        val post = Post.fromPrimitives(primitives)
        postRepository.save(post)

        if (userId == null) {
            throw NotFoundException("Usuario no encontrado")
        }

        return post
    }

    fun deletePost(postId: String) {
        postRepository.deleteById(postId)
    }

}

class PostValidationException(message: String) : Exception(message)