package basic.graph.dfs

import java.util.*

/** DFS 예제로 사용할 예제
 ********************
 *        E         *
 *       / \        *
 *      D   A       *
 *     /   / \      *
 *    F   C   B     *
 ********************
 */

fun main (args: Array<String>) : Unit {
    val graph: Graph = createGraphExample1()
//    val start = graph.getStartVertex()
    val start = graph.startVertex

    graph.pushToStack(start)
    graph.printStack()

    val queue: Queue<Vertex> = LinkedList<Vertex>()

    var cnt: Int = 0

    while(true){
        val pop: Vertex = graph.pop()
        queue.offer(pop)
        graph.printStack()

        val neighbors = pop.adjacentList

        if (neighbors.size > 0){
            for(v in neighbors){
                if(v.isVisited == false) graph.pushToStack(v)
            }
        }

        graph.printStack()

        val isAllVisited = (graph.vertexSet.size == graph.visitedSet.size)
        println("isVisited :: ${isAllVisited}")

        if(isAllVisited) break
    }

    for(v in queue){
        print("${v.label} -> ")
    }

    println("||")
}

fun createGraphExample1() : Graph{
    val graph: Graph = Graph()
    val e = graph.createVertex(label = "E", isVisited = false)
    val d = graph.createVertex(label = "D", isVisited = false)
    val a = graph.createVertex(label = "A", isVisited = false)
    val f = graph.createVertex(label = "F", isVisited = false)
    val c = graph.createVertex(label = "C", isVisited = false)
    val b = graph.createVertex(label = "B", isVisited = false)

//    graph.setStartVertex(e)
    graph.startVertex = e

//    graph.addEdge(from = e, to = d).addEdge(from = e, to = a)
    graph.addEdge(from = e, to = a).addEdge(from = e, to = d)
    graph.addEdge(from = d, to = f)
    graph.addEdge(from = a, to = c).addEdge(from = a, to = b)
    return graph
}