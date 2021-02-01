package basic.graph.dfs.traverse_ice_tray.fixed_size

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class Graph {
    val vertexSet: Set<Vertex> = HashSet<Vertex>()
    var stack: Stack<Vertex> = Stack<Vertex>()
    val visitedSet: MutableSet<Vertex> = mutableSetOf<Vertex>()

    fun createVertex(label: Int, isVisited: Boolean = false): Vertex {
        val vertex = Vertex(label = label, isVisited = isVisited, adjacentVertexes = HashSet<Vertex>())
        return vertex
    }

    fun addEdge(from : Vertex, to : Vertex): Graph{
        if(!from.adjacentVertexes.contains(to)){
            from.adjacentVertexes.add(to)
        }
        return this
    }

    fun pop(): Vertex{
        val pop = stack.pop()
        pop.isVisited = true
        visitedSet.add(pop)
        return pop
    }

    fun pushToStack(vertex: Vertex): Unit{
        stack.push(vertex)
    }

    fun printStack(): Unit{
        for(v in stack){
            print("v :: ${v.label}, ")
        }
        println()
    }
}