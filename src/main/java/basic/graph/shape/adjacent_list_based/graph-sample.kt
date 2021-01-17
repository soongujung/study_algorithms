package basic.graph.shape.adjacent_list_based


fun main(args: Array<String>) : Unit {
    val graph : Graph = Graph()

    val v1 : Vertex = graph.createVertex(label = 1, isVisited = false)

    val v2 : Vertex = graph.createVertex(label = 2, isVisited = false)
    val v3 : Vertex = graph.createVertex(label = 3, isVisited = false)
    val v4 : Vertex = graph.createVertex(label = 4, isVisited = false)

    val v5 : Vertex = graph.createVertex(label = 5, isVisited = false)
    val v6 : Vertex = graph.createVertex(label = 6, isVisited = false)
    val v7 : Vertex = graph.createVertex(label = 7, isVisited = false)

    val v8 : Vertex = graph.createVertex(label = 8, isVisited = false)
    val v9 : Vertex = graph.createVertex(label = 9, isVisited = false)

    graph.addVertex(v1).addVertex(v2).addVertex(v3)
            .addVertex(v4).addVertex(v5).addVertex(v6)
            .addVertex(v7).addVertex(v8).addVertex(v9)

    graph.displayVertexes()

    graph.addEdge(v1, v2)
            .addEdge(v1, v3)
            .addEdge(v1, v4)

    graph.addEdge(v2, v5)

    graph.addEdge(v3, v6)
            .addEdge(v3, v7)

    graph.addEdge(v4, v8)
            .addEdge(v4, v9)
}