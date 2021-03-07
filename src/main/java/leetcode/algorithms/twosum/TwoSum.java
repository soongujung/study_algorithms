package leetcode.algorithms.twosum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static int[] findTwoSum(int[] list, int sum) {
		Map<Integer, Integer> numberMap = new HashMap<>();
		boolean [] visitedFlag = new boolean[list.length];
		for(int index=0; index<list.length; index++){
			numberMap.put(list[index], index);
		}

		int [] result = new int [list.length];
		int resultIndex = 0;
		for(int index=0; index<list.length; index++){

			int number = list[index];
			int diff = sum - number;

			if(numberMap.containsKey(diff) && visitedFlag[index] == false){
				if(number == diff){
					result[resultIndex] = numberMap.get(number);
				}
				else {
					result[resultIndex] = numberMap.get(number);
					result[++resultIndex] = numberMap.get(diff);
				}
				visitedFlag[numberMap.get(diff)] = true;
				resultIndex++;
			}

			visitedFlag[index] = true;
		}
		return result;
	}

	public static void printArray(int [] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]);
			if(i < arr.length-1)
				System.out.print(",");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] indices = findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);
		if(indices != null) {
			System.out.println(indices[0] + " " + indices[1]);
		}
		printArray(indices);
	}
}
