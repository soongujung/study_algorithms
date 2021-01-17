package basic.graph.shape.adjacent_list_based

fun main(args: Array<String>): Unit{
    val v0_1 = Vertex(label = 1, isVisited = false, adjacentList = ArrayList<Vertex>())
    val v0_2 = Vertex(label = 2, isVisited = false, adjacentList = ArrayList<Vertex>())
    val v0_3 = Vertex(label = 3, isVisited = false, adjacentList = ArrayList<Vertex>())
    val v0_4 = Vertex(label = 4, isVisited = false, adjacentList = ArrayList<Vertex>())

    v0_1.adjacentList.add(v0_2)
    v0_1.adjacentList.add(v0_3)
    v0_1.adjacentList.add(v0_4)

    println("v_01 의 인접 노드들 :: \n${v0_1.adjacentList.toString()}\n")
    println("v_02 의 인접 노드들 :: \n${v0_2.adjacentList.toString()}\n")
    println("v_03 의 인접 노드들 :: \n${v0_3.adjacentList.toString()}\n")
    println("v_04 의 인접 노드들 :: \n${v0_4.adjacentList.toString()}\n")
}