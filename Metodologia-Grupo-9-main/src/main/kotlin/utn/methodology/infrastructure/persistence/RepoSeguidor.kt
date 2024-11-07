package utn.methodology.infrastructure.persistence

import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.Filters
import org.bson.Document
import utn.methodology.domain.entities.Seguidor


class RepoSeguidor(private val database: MongoDatabase) {

    private val collection: MongoCollection<Document> = database.getCollection("Seguidores")

    fun seguir(seguidor: Seguidor) {
        val document = Document("idSeguidor", follower.followerId)
            .append("idSeguido", seguidor.idSeguido)

        // insertar la relación
        collection.insertOne(document)
    }


    fun dejarDeguir(idSeguidor: String, idSeguido: String) {
        val filter = Filters.and(Filters.eq("idSeguidor", idSeguidor), Filters.eq("idSeguido", idSeguido))
        collection.deleteOne(filter)
    }
}