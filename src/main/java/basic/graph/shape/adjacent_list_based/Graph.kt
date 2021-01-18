package basic.graph.shape.adjacent_list_based

class Graph {

    private val vertexSet : MutableSet<Vertex> = mutableSetOf<Vertex>()

    fun createVertex(label: Int, isVisited: Boolean = false) : Vertex {
        return Vertex(label = label, isVisited = isVisited, adjacentList = ArrayList<Vertex>())
    }

    fun addVertex(vertex: Vertex): Graph {
        vertexSet.add(vertex)
        return this
    }

    fun addEdge(from: Vertex, to: Vertex) : Graph{
        from.adjacentList.add(to)
        return this
    }

    fun displayVertexes(): Unit {
        for(v in vertexSet){
            print("${v.label} ")
            print("-> ")
        }
        println("||")
    }
}