// infrastructure/MongoDatabaseFactory.kt
package infrastructure

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoDatabase

object MongoDatabaseFactory {

    private const val CONNECTION_STRING = "mongodb://localhost:27017" // cambiar según  entorno
    private const val DATABASE_NAME = "nombreBD"

    private val client: MongoClient = MongoClients.create(CONNECTION_STRING)

    fun getDatabase(): MongoDatabase {
        return client.getDatabase(DATABASE_NAME)
    }
}
