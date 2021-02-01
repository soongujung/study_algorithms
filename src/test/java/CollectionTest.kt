import basic.graph.dfs.traverse_ice_tray.fixed_size.Vertex
import org.junit.jupiter.api.Test

class CollectionTest {

    @Test
    fun testArrayOf(): Unit{
        val v1 : Vertex = Vertex(label = 1, isVisited = false, adjacentVertexes = HashSet<Vertex>())
        val v2 : Vertex = Vertex(label = 2, isVisited = false, adjacentVertexes = HashSet<Vertex>())
        val arr = arrayOf(v1, v2)
        for(v in arr){
            println(v)
        }
    }
}