package basic.graph.dfs.traverse_ice_tray.fixed_size


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
    graph.addEdge(from = v11, to = v12).addEdge(from = v12, to = v11)
    graph.addEdge(from = v12, to = v22)
}
