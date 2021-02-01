package basic.graph.dfs.traverse_ice_tray.fixed_size

import java.util.*


fun main(args : Array<String>) : Unit {
    val graph: Graph = Graph()
    val v00 = graph.createVertex(label = 0, isVisited = false)
    val v10 = graph.createVertex(label = 0, isVisited = false)
    val v01 = graph.createVertex(label = 0, isVisited = false)
    val v20 = graph.createVertex(label = 1, isVisited = false)
    val v02 = graph.createVertex(label = 1, isVisited = false)
    val v21 = graph.createVertex(label = 0, isVisited = false)
    val v11 = graph.createVertex(label = 1, isVisited = false)
    val v12 = graph.createVertex(label = 0, isVisited = false)
    val v22 = graph.createVertex(label = 1, isVisited = false)

    graph.addEdge(from = v00, to = v10).addEdge(from = v00, to = v01)
    graph.addEdge(from = v10, to = v20).addEdge(from = v10, to = v11)
    graph.addEdge(from = v01, to = v11).addEdge(from = v01, to = v02)
    graph.addEdge(from = v20, to = v21)
    graph.addEdge(from = v21, to = v11).addEdge(from = v11, to = v21)
    graph.addEdge(from = v02, to = v12)
    graph.addEdge(from = v11, to = v12)

    graph.addEdge(from = v12, to = v22).addEdge(from = v12, to = v02)

    val totalMatrix = arrayListOf<Vertex>(v00, v01, v02, v10, v11, v12, v20, v21, v22)
    dfs_totalMatrix(graph = graph, totalMatrix = totalMatrix)
}

fun dfs_totalMatrix (graph: Graph, totalMatrix: ArrayList<Vertex>): Unit {
    println("hello")
    for(v in totalMatrix){
        dfs_recursive(vertex = v)
//        println(v)
    }
//    for(v in totalMatrix){
//        dfs_iterate(graph = graph, visit = v)
//    }
}

/**
 * 재귀문 기반 DFS
 */
fun dfs_recursive (vertex: Vertex): Unit{
    vertex.isVisited = true
    val adjVertexes = vertex.adjacentVertexes

    for(v in adjVertexes){
        if(v.isVisited == false){
            dfs_recursive(v)
        }
    }
}

/**
 * 반복문 기반 DFS
 */
fun dfs_iterate (graph: Graph, visit: Vertex): Unit{
    graph.pushToStack(visit)
    val printQueue: Queue<Vertex> = LinkedList<Vertex>()

    while(true){
        val pop: Vertex = graph.pop()
        printQueue.offer(pop)
        graph.printStack()

        val neighbors = pop.adjacentVertexes

        if(neighbors.size > 0){
            for (neighbor in neighbors){
                if(neighbor.isVisited == false) graph.pushToStack(neighbor)
            }
        }

        val isAllVisited = (graph.vertexSet.size == graph.visitedSet.size)
        println("isVisited :: ${isAllVisited}")

        if(isAllVisited) break
    }
}