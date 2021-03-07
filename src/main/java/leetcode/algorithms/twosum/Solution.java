package leetcode.algorithms.twosum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> numberMap = new HashMap<>();
		Map<Integer, List<Integer>> indexMap = new HashMap<>();

		for(int index=0; index<nums.length; index++){
			numberMap.put(nums[index], index);
			if(!indexMap.containsKey(nums[index])){
				indexMap.put(nums[index], new ArrayList<Integer>());
				indexMap.get(nums[index]).add(index);
			}
			else{
				indexMap.get(nums[index]).add(index);
			}
		}

		boolean [] visitedFlag = new boolean[nums.length];
		Set<Integer> resultSet = new HashSet<>();
		List<Integer> numbers = new ArrayList<>();

		for(int index=0; index<nums.length; index++){
			int number = nums[index];
			int diff = target - number;

//			if(numberMap.get(diff) != null && visitedFlag[index] == false){
			if(indexMap.get(diff) != null && visitedFlag[index] == false){
				if(number != diff){
					numbers.add(index);
					numbers.add(indexMap.get(diff).get(0));
					visitedFlag[numberMap.get(diff)] = true;
				}
				else {
					if(indexMap.get(diff).size() > 1){
						numbers.add(index);
						numbers.add(indexMap.get(diff).get(1));
						visitedFlag[numberMap.get(diff)] = true;
					}
				}
			}

			visitedFlag[index] = true;
		}

		int i = 0;
		int [] resultArr = new int [numbers.size()];

		for(Integer number: numbers){
			resultArr[i] = number;
			i++;
		}

		return resultArr;
	}

	public static void printArray(int [] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]);
			if(i < arr.length-1){
				System.out.print(",");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Solution s = new Solution();
//		int[] indices = s.twoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);
//		int[] indices = s.twoSum(new int[] { 2,7,11,15}, 9);
//		int[] indices = s.twoSum(new int[] { 3,2,4}, 6);
		int[] indices = s.twoSum(new int[] { 3,3}, 6);
		if(indices != null) {
			System.out.println(indices[0] + " " + indices[1]);
		}
		printArray(indices);
	}

}
