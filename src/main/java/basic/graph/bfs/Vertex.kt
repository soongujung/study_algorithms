package basic.graph.bfs

data class Vertex (
        val label: String,
        var isVisited: Boolean,
        val adjacentList: ArrayList<Vertex>
){
    fun visit():Unit{
        this.isVisited = true
    }
}