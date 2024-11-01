@RestController
@RequestMapping("/posts")
class PostController(private val postService: PostService) {
    @PostMapping
    fun crearPost(@RequestBody post: Post): ResponseEntity<Post> {
        val postCreado = postService.crearPost(post)
        return ResponseEntity.created(URI.create("/posts/${postCreado.id}"))
            .body(postCreado)
    }
}