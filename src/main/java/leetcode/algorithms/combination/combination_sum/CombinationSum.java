package leetcode.algorithms.combination.combination_sum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

	public static int [] list = null;

	public static void backtracking(
		int diff, int start,
		List<List<Integer>> results,
		LinkedList<Integer> combination){

		if(diff == 0){
			results.add(new LinkedList<>(combination));
			return;
		}

		if(diff <0) return;

		for(int i=start; i<list.length; i++){
			combination.add(list[i]);
			backtracking(diff - list[i], i, results, combination);
			combination.removeLast();
		}
	}

	public static List<List<Integer>> combinationSum(int target){
		List<List<Integer>> results = new ArrayList<>();
		LinkedList<Integer> combination = new LinkedList<>();
		backtracking(target, 0, results, combination);
		return results;
	}

	public static void main(String [] args){
//		int [] arr = {2,3,6,7};
//		int target = 7;

//		int [] arr = {2,3,5};
//		int target = 8;

//		int [] arr = {2};
//		int target = 1;

//		int [] arr = {1};
//		int target = 1;

//		int [] arr = {1};
//		int target = 2;

//		int [] arr = {2,3};
//		int target = 5;

//		int [] arr = {3,4,5};
//		int target = 8;

		int [] arr = {2,3,4};
		list = arr;
		int target = 5;

		List<List<Integer>> lists = combinationSum(target);
		System.out.println(lists);
	}

}
