package programmers.stringcompression.iterationBased;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IterStringCompression {

	public static int answer(String question) throws Exception {
		if (question.length() == 0) return 0;

		int result = 0;
		Map<String, Integer> countMap = new HashMap<String, Integer>();
		Set<String> compressedSet = new HashSet<String>();

		for (int step = 1; step<question.length(); step++){
			int count = 0;
			int beginIndex = 0;
			int endIndex = 0;
			int subLimit = (int) Math.floor(question.length() / step);

			String prev = question.substring(0, step);
			String append_str = "";

			for (int i = 1; i<subLimit+1 && subLimit!=1; i++){
				// beginIndex) substring 의 beginIndex. substring 을 하는 단위는 step 의 배수로 늘려나간다.
				beginIndex = (i-1)*step;

				// endIndex) substring 의 endIndex. i*step 이 지정된 배열의 단위를 넘어서는 경우가 있기에 이에 대한 처리구문 추가
				endIndex = (i*step) > question.length() ? question.length() : i*step;

				// 내부 for 루프 안에서 돌아가는 current
				String inner_current = question.substring(beginIndex, endIndex);

				// 찾으려는 단위문자열인 prev 가 step(i) 에 대한 단위문자열인 inner_current와 같은 경우 갯수 카운팅 +1
				if(prev.equals(inner_current)){
					count++;
					countMap.put(inner_current, count);
				}
				/**
				 * 비교할 단위 문자열 변경 && count 값 초기화
				 *  : 나머지 문자열에 대해서도 동일하게 찾기 위한 블록
				 *  : 문자열의 길이가 i 일 때 (step = i), 길이가 i인 문자열 prev 로 계속해서 다음 문자열이 같은지 찾다가, 다음 문자열이 다른 경우 비교할 대상인 prev 의 값을 바꾸는 것으로 비교대상을 바꾼다.
				 *  : 비교할 단위문자열 변경 && count 값 초기화 (그 다음 문자열도 길이의 단위인 step(i) 인 문자열이 반복되는지 여부를 찾아야 하기 때문)
				 *  : 즉, 단위문자열의 연속출현이 끝난 경우에 대한 조건이다. 이 경우 그 다음 검색대상 문자열을 세팅한다. (이렇게 설명하는게 조금 더 깔끔하군)
				 *
				 * ex) "abcabcdede
				 * 	: step = 2 이고, bc 까지 검사를 완료했는데(prev == "bc") 그 다음 문자열(inner_current)이 "de" 이다.
				 * 	: 이 경우 문자열 길이가 2 인 검사를 할 대상을 바꿔서 한번 더 검사를 한다. 그리고 count 역시 초기화 해준다. (비교대상 문자열을 변경("bc" -> "de")했기 때문.
				 */
				else {
					append_str = append_str + (count == 1 ? prev : count + prev);
					prev = inner_current;
					countMap.put(inner_current, count);
					count = 1;
				}
				if (i == subLimit){
					append_str = append_str + (count == 1 ? inner_current : count + inner_current);
				}
			}

			if(!"".equals(append_str)){
				String test = question.substring(endIndex);
				append_str = append_str + test;
				compressedSet.add(append_str);
			}
		}

		System.out.println("compressedSet :: " + compressedSet);

		result = question.length();
		for (String s : compressedSet){
			if(result > s.length()){
				result = s.length();
			}
		}

		System.out.println("min compressed :: " + result);

		return result;
	}


	public static void main (String [] args) throws Exception {
		String question1 = "aabbaccc";
		String question2 = "ababcdcdababcdcd";
		String question3 = "abcabcdede";
		String question4 = "abcabcabcabcdededededede";
		String question5 = "xababcdcdababcdcd";

		System.out.println("============== question1 :: " + question1);
		System.out.println(answer(question1));

		System.out.println("============== question2 :: " + question2);
		System.out.println(answer(question2));

		System.out.println("============== question3 :: " + question3);
		System.out.println(answer(question3));
	}

}
