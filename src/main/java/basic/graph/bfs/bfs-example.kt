package basic.graph.bfs

import java.util.*

/** BFS 예제로 사용할 예제
 ********************
 *        E         *
 *       / \        *
 *      D   A       *
 *     /   / \      *
 *    F   C   B     *
 ********************
 */

fun main(args: Array<String>) : Unit {
    val graph = createExampleCase1()
    val startVetex: Vertex = graph.startVertex
    val visitedVertexes: Queue<Vertex> = LinkedList<Vertex>()

    graph.enqueue(startVetex)
    while(true){
        val vertex = graph.dequeue()
        graph.visitVertex(vertex)

        val adjacentList = vertex.adjacentList
        if (adjacentList.size > 0){
            for (v in adjacentList){
                graph.enqueue(v)
            }
        }
        visitedVertexes.add(vertex)

        if(graph.didItBeAllVisited()) break
    }

    for(v in visitedVertexes){
        print("${v.label} -> ")
    }
    println("||")

}

fun createExampleCase1() : Graph {
    val graph: Graph = Graph()
    val e = graph.createVertex(label = "E", isVisited = false)
    val d = graph.createVertex(label = "D", isVisited = false)
    val a = graph.createVertex(label = "A", isVisited = false)
    val f = graph.createVertex(label = "F", isVisited = false)
    val c = graph.createVertex(label = "C", isVisited = false)
    val b = graph.createVertex(label = "B", isVisited = false)

//    graph.setStartVertex(e)
    graph.startVertex = e

    graph.addEdge(from = e, to = d).addEdge(from = e, to = a)
//    graph.addEdge(from = e, to = a).addEdge(from = e, to = d)
    graph.addEdge(from = d, to = f)
    graph.addEdge(from = a, to = c).addEdge(from = a, to = b)
    return graph
}