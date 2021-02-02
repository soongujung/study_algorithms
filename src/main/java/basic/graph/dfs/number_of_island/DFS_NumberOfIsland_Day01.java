package basic.graph.dfs.number_of_island;

public class DFS_NumberOfIsland_Day01 {

	public static String [][] grid = {
		{"1","1","1","1","0"},
		{"1","1","0","1","0"},
		{"1","1","0","0","0"},
		{"0","0","0","0","0"}
	};

	public static final String 	VISITED_FLAG 			= "visited";
	public static final String 	WATER 					= "0";
	public static final String 	LAND 					= "1";
	public static final int 	MATRIX_LENGTH_WIDTH 	= 5;
	public static final int 	MATRIX_LENGTH_HEIGHT 	= 4;

	public static final boolean LAND_FLAG			= true;

	/**
	 * 문제풀이 고고싱
	 * @param args
	 */
	public static void main(String [] args){
		int count = 0;
		for (int i=0; i<grid.length; i++){
			for(int j=0; j<grid[i].length; j++){
				if(!VISITED_FLAG.equalsIgnoreCase(grid[i][j])){
					boolean landFlag = dfs(grid, i, j);
					if(landFlag) count++;
				}
			}
		}

		System.out.println("LAND COUNT ::: " + count);

		print(grid);
	}

	/**
	 * DFS 함수
	 */
	public static boolean dfs (String [][] grid, int i, int j){
		if(i<0 || j<0 || i>=MATRIX_LENGTH_HEIGHT || j>=MATRIX_LENGTH_WIDTH) return false;
		System.out.println("grid[i,j] :: " + grid[i][j]);
		if(WATER.equalsIgnoreCase(grid[i][j])) return false;
		if(LAND.equalsIgnoreCase(grid[i][j])){
			grid[i][j] = VISITED_FLAG;

			dfs(grid, i,j-1); 	// 좌
			dfs(grid, i,j+1); 	// 우
			dfs(grid, i-1, j);  // 상
			dfs(grid, i+1, j);  // 하
			return true;
		}
		return false;
	}

	/**
	 * 배열 프린트 함수
	 * @param grid
	 */
	public static void print (String [][] grid){
		for (int i=0; i<grid.length; i++){
			for (int j=0; j<grid[i].length; j++){
				System.out.print("[("+ i + "," + j + ") :: " + grid[i][j] + "] \t");
			}
			System.out.println("");
		}
	}

}
