class UserSearchHandler {
    private val userRepository: UserRepository

    constructor(userRepository: UserRepository) {
        this.userRepository = userRepository
    }

    suspend fun searchUsers(query: String): Result<List<User>> {
        return try {
            val users = userRepository.findByUsernameContainingIgnoreCase(query)
            Result.success(users)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}