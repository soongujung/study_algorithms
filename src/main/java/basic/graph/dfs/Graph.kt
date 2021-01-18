package basic.graph.dfs

import java.util.*
import kotlin.collections.ArrayList

class Graph {
    val vertexSet : MutableSet<Vertex>  = mutableSetOf<Vertex>()
    val visitedSet : MutableSet<Vertex> = mutableSetOf<Vertex>()
    val stack: Stack<Vertex> = Stack<Vertex>()
    lateinit var startVertex: Vertex

    fun createVertex(label: String, isVisited: Boolean = false) : Vertex {
        val v: Vertex = Vertex(label = label, isVisited = isVisited, adjacentList = ArrayList<Vertex>())
        vertexSet.add(v)
        return v
    }

    fun addEdge(from: Vertex, to: Vertex): Graph {
        from.adjacentList.add(to)
        return this
    }

    fun pushToStack(v: Vertex): Unit{
        stack.push(v)
    }

    fun pop(): Vertex{
        val v: Vertex = stack.pop()
        v.isVisited = true
        visitedSet.add(v)
        return v
    }

    fun printStack(): Unit{
        for(v in stack){
            print("v :: ${v.label}, ")
        }
        println()
    }
}