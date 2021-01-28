package basic.graph.dfs.traverse_ice_tray.fixed_size

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class Graph {
    val vertexSet: Set<Vertex> = HashSet<Vertex>()
    val vertexMap: Map<String, Vertex> = HashMap<String, Vertex>()
    var stack: Stack<Vertex> = Stack<Vertex>()

    fun createVertex(label: Int, isVisited: Boolean = false): Vertex {
        val vertex = Vertex(label = label, isVisited = isVisited, adjacentList = ArrayList<Vertex>(), adjacentVertexes = HashSet<Vertex>())
        return vertex
    }

    fun addEdge(from : Vertex, to : Vertex): Graph{
        if(!from.adjacentVertexes.contains(to)){
            from.adjacentList.add(to)
        }
        return this
    }
}