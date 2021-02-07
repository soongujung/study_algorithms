package basic.graph.bfs.maze;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_Maze_Day01 {
	public static Queue<Vertex> queue = new LinkedList<Vertex>();
	public static final int GRAPH_WIDTH 	= 3;
	public static final int GRAPH_HEIGHT 	= 3;

	public static int [][] graph = {
		{1,1,0},
		{0,1,0},
		{0,1,1}
	};

	public static boolean [][] visitedMap = {
		{false, false, false},
		{false, false, false},
		{false, false, false}
	};

	public static int [] diffX = {-1, 1, 0, 0};		// 상,하,좌,우
	public static int [] diffY = {0, 0, -1, 1};		// 상,하,좌,우

	public static List<Vertex> getVertexDiffList(){
		List<Vertex> diffList = new ArrayList<>();

		diffList.add(new Vertex(-1, 0));
		diffList.add(new Vertex(1, 0));
		diffList.add(new Vertex(0, -1));
		diffList.add(new Vertex(0, 1));

		return diffList;
	}

	static class Vertex {
		public static int x;
		public static int y;

		Vertex (int x, int y){
			this.x = x;
			this.y = y;
		}

		public static int getX() {
			return x;
		}

		public static void setX(int x) {
			Vertex.x = x;
		}

		public static int getY() {
			return y;
		}

		public static void setY(int y) {
			Vertex.y = y;
		}
	}

	public static void main(String [] args){
//		printGraph(graph);
		int data = bfs(0,0);
		printGraph(graph);
		System.out.println(data);
	}

	public static int bfs(int startX, int startY){
		Vertex v = new Vertex(startX, startY);
		queue.offer(v);

		while (!queue.isEmpty()){
			Vertex temp = queue.poll();
			int x = temp.getX();
			int y = temp.getY();
			visitedMap[x][y] = true;

			for (int i=0; i<4; i++){
				int searchX = x + diffX[i];
				int searchY = y + diffY[i];

				if(searchX <0 || searchY <0 || searchX >=3 || searchY >=3) continue;

				// 벽인 경우 무시
				if(graph[searchX][searchY] == 0) continue;

				// 길이 역시도 업데이트 하도록 수정
				if(graph[searchX][searchY] == 1) {
					if(visitedMap[searchX][searchY] == false){
						graph[searchX][searchY] = graph[searchX][searchY] + graph[x][y];
						queue.offer(new Vertex(searchX, searchY));
					}
				}
			}
		}

		return graph[3-1][3-1];
	}

	public static void printGraph(int [][] graph) {
		for(int i=0; i<graph.length; i++){
			for(int j=0; j<graph[i].length; j++){
				System.out.print("[" + i + "," + j + "]::" + graph[i][j] + " \t");
			}
			System.out.println("");
		}
	}

}
