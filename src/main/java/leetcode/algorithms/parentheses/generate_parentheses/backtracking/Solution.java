package leetcode.algorithms.parentheses.generate_parentheses.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<String> generateParenthesis(int n){
		List<String> ans = new ArrayList<>();
		backtrack(ans, "",0,0, n);
		return ans;
	}

	public void backtrack(List<String> ans, String cur, int open, int close, int max){
		if(cur.length() == max*2){
			ans.add(cur);
			return;
		}

		// open 괄호의 갯수가 max에 미치지 못하면 open 괄호의 갯수를 늘리기 위해 +1 을 시작한다.
		if(open < max){
			backtrack(ans, cur+"(", open+1, close, max);
		}
		// close 괄호의 갯수가 open 괄호의 갯수보다 작으면 맞추기 위해 +1 을 시작한다.
		if(close < open){
			backtrack(ans, cur+")", open, close+1, max);
		}
	}

	public static void main(String [] args){
		Solution s = new Solution();
		List<String> strings = s.generateParenthesis(2);
		System.out.println(strings);
	}
}
