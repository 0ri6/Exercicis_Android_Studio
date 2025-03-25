package cat.itb.m78.exercices.database

class MessagesViewModel {
    fun xxx(){
        database.myTableQueries.insert("hola")

        val list = database.myTableQueries.selectAll().executeAsList()
    }
}