package basic.graph.bfs

import java.util.*
import kotlin.collections.ArrayList

class Graph {

    lateinit var startVertex: Vertex

    val queue: Queue<Vertex> = LinkedList<Vertex>()
    val visitedSet: MutableSet<Vertex> = mutableSetOf()
    val vertexSet: MutableSet<Vertex> = mutableSetOf()

    fun createVertex(label: String, isVisited: Boolean = false) : Vertex {
        val vertex : Vertex = Vertex(label = label, isVisited = isVisited, adjacentList = ArrayList<Vertex>())
        vertexSet.add(vertex)
        return vertex
    }

    fun addEdge(from: Vertex, to: Vertex) : Graph{
        from.adjacentList.add(to)
        return this
    }

    fun enqueue(vertex: Vertex): Unit {
        this.queue.offer(vertex)
    }

    fun dequeue(): Vertex {
        val poll: Vertex = this.queue.poll()
        return poll
    }

    fun visitVertex(vertex: Vertex) : Unit{
        vertex.visit()
        visitedSet.add(vertex)
    }

    fun didItBeAllVisited(): Boolean {
        val visitAllYn : Boolean = visitedSet.size == vertexSet.size
        return visitAllYn
    }

}