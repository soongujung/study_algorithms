package basic.graph.dfs.traverse_ice_tray.fixed_size

data class Vertex (
    val label: Int,
    var isVisited: Boolean,
    val adjacentVertexes: HashSet<Vertex>
){
}