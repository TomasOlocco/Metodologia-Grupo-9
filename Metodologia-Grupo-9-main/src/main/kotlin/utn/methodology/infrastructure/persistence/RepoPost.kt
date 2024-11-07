package utn.methodology.infrastructure.persistence

import utn.methodology.domainentities.Post

interface `RepoPost.kt` {
    fun save(post: Post): Post
    fun findAll(): List<Post>
    // Otros métodos segun necesidades (buscar por autor, fecha, etc.)
}