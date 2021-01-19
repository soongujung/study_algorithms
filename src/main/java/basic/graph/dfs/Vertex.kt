package basic.graph.dfs

data class Vertex (
    val label: String,
    var isVisited: Boolean,
    val adjacentList: ArrayList<Vertex>
){
}