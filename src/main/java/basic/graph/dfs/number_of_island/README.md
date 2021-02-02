# Number Of Island
실제로 DFS 문제는 굉장히 많이 출제된다고 한다. Leet Code에서 해당 문제를 발췌해왔다. 다른 문제집들에도 굉장히 많고, 이것 저것 찾아보고 들어본 강의에도 많았다.
대표적인 문제는 NumberOfIsland 이지 않을까 싶기는 하다. 문제가 굉장히 많다고 한다. dfs 의 응용역시도 많아서 최소 10가지 이상의 문제를 풀어봐야 한다고 한다.  
  
# 문제
[leet code - number of island](https://leetcode.com/problems/number-of-islands/)
Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
  
영어 문제가 굉장히 거창하기는 한데 요약해보면 이렇다.  
```plain
땅은 1로 표시한다. 저수지(water)는 0으로 표시한다.
인접한 땅을 하나씩 이어붙여서 생길수 있는 육지의 갯수는? 
```

# ex 1)
## Input
```plain
grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
``` 
## Output
땅을 이어붙여서 만들수 있는 육지는 1개이다.
```plain
Output: 1
```

# ex 2)
## Input
```plain
grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
```
## Output
```plain
Output: 3
```

# 문제 풀이
항상 그래왔듯이... 문제를 풀때는 답안이 될 수 있도록 하나 하나 절차를 나열해보는 것이 좋다.
내가 원하는 데로 하나씩 나열해보고 여기서 규칙을 찾으면 된다.  
그래프라고는 하지만, 단순 2차원 배열 풀이 문제이다. DFS가 꼭 그래프를 구현해서 풀라는 법은 없다.  
2차원 배열안에 값을 넣어서도 그래프를 구현할 수 도 있기 때문이다. (배열기반 그래프)
  
노드 하나를 기준으로 좌/우/상/하 로 십자가 형태로 둘러보면서 재귀문을 통해 육지가 나올때까지 끝까지 찾아나가는 것이 문제의 컨셉이다.
이때 문제 풀이시에 핵심이 되는것이 2차원 배열의 순회이다.  
  
## 2차원 배열 좌표 찍어보기
2차원 기반 배열을 기반으로 풀어내는 것이기 때문에 기존 x,y 좌표계를 읽는 것과는 순서가 다르다. 2차원 배열을 찍어본뒤에 풀어보는 것이 필요하다.  
아래와 같이 java 코드로 2차원 배열의 좌표를 찍어봤다.  

```java
public class ASample{
	public static void print (String [][] grid){
		for (int i=0; i<grid.length; i++){
			for (int j=0; j<grid[i].length; j++){
				System.out.print("[("+ i + "," + j + ") :: " + grid[i][j] + "] \t");
			}
			System.out.println("");
		}
	}
}
```

```plain
[(0,0) :: 1] 	[(0,1) :: 1] 	[(0,2) :: 1] 	[(0,3) :: 1] 	[(0,4) :: 0] 	
[(1,0) :: 1] 	[(1,1) :: 1] 	[(1,2) :: 0] 	[(1,3) :: 1] 	[(1,4) :: 0] 	
[(2,0) :: 1] 	[(2,1) :: 1] 	[(2,2) :: 0] 	[(2,3) :: 0] 	[(2,4) :: 0] 	
[(3,0) :: 0] 	[(3,1) :: 0] 	[(3,2) :: 0] 	[(3,3) :: 0] 	[(3,4) :: 0] 	
``` 

## 상하좌우 움직이기
for 문으로 (i,j) 좌표로 이동하면서 해당 좌표인 (i,j) 에 대해서 `상하좌우`를 십자가모양으로 둘러보는데 이때 처음 둘러본 `상`위치의 노드의 상하좌우를 또 다시 살펴본다. 이것을 반복한다. 뭔가 재귀의 냄새가 풀풀 풍겨온다. 