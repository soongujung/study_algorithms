package basic.graph.shape.adjacent_list_based

data class Vertex (
        val label: Int,
        var isVisited: Boolean,
        val adjacentList: ArrayList<Vertex>,
){


}
