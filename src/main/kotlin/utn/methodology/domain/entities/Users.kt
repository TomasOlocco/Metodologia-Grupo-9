import com.mongodb.client.MongoCollection

    class UserRepository(private val DataBase:MongoDataBase){
        fun findByUsernameContainingIgnoreCase(query: String): Any {

            return TODO("Provide the return value")
        }

