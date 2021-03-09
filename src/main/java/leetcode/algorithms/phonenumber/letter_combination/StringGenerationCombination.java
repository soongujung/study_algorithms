package leetcode.algorithms.phonenumber.letter_combination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringGenerationCombination {
	public static Map<String, String> phone = new HashMap<>();
	public static List<String> output = new ArrayList<>();

	public static void backtrack(String combination, String nextNumber){
		if(nextNumber.length() == 0){
			output.add(combination);
		}
		else{
			String number = nextNumber.substring(0, 1);	// "23" -> 2, "3" -> 3
			String letters = phone.get(number);
			for(int i=0; i<letters.length(); i++){
				String subStr = letters.substring(i, i + 1);
				backtrack(combination + subStr, nextNumber.substring(1));
			}
		}
	}

	public static List<String> letterCombinations(String phoneNumbers){
		if(output != null)
			backtrack("", phoneNumbers);
		return output;
	}

	public static void main (String [] args){
		phone.put("2", "abc");
		phone.put("3", "def");
		phone.put("4", "ghi");
		phone.put("5", "jkl");
		phone.put("6", "mno");
		phone.put("7", "pqrs");
		phone.put("8", "tuv");
		phone.put("9", "wxyz");
		List<String> strings = letterCombinations("23");
		System.out.println(strings);
	}
}
