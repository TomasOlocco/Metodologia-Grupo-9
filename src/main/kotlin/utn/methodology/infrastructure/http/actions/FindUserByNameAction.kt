package utn.methodology.infrastructure.http.actions;

import example.com.application.queries./*Insertar query*/
import example.com.application.queryhandlers./*Insertar handler*/

class FindUserByNameAction (
    private val handler: /*Insertar handler*/
){
    fun execute(query: /*Insertar query*/): Map <String, String> {
        query
            .validate()
            .let {
                return handler.handle(it)
            }
    }
}
