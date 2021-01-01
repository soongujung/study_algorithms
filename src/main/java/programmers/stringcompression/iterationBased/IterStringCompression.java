package programmers.stringcompression.iterationBased;

import java.util.HashMap;
import java.util.Map;

public class IterStringCompression {

	public static int answer(String question){
		int result = 0;
		Map<String, Integer> countMap = new HashMap<String, Integer>();

		for (int step = 1; step<question.length(); step++){
			int count = 0;
			String prev = question.substring(0, step);
			int subLimit = (int) Math.floor(question.length() / step);
			System.out.println("outer :: " + prev);

			for (int i = 1; i<=subLimit && subLimit!=1; i++){
				// beginIndex) substring 의 beginIndex
				// substring 을 하는 단위는 step 의 배수로 늘려나간다.
				int beginIndex = (i-1)*step;

				// endIndex) substring 의 endIndex
				// i*step 이 지정된 배열의 단위를 넘어서는 경우가 있기에 이에 대한 처리구문 추가
				int endIndex = (i*step) > question.length() ? question.length() : i*step;

				// 내부 for 루프 안에서 돌아가는 current
				String inner_current = "";

				// endIndex가 문자열의 범위를 넘어서게 되는 경우
//				if (endIndex >= question.length()){
//					inner_current = question.substring(beginIndex);
//				}
				// endIndex가 문자열의 범위를 넘어서지 않는 경우
//				else {
					inner_current = question.substring(beginIndex, endIndex);
					if(prev.equals(inner_current)){
//						if("de".equals(prev)){
//							System.out.println(">>> prev :: " + prev + ", inner_current :: " + inner_current);
//						}
						count++;
						countMap.put(prev, count);
					}
					else {
						// 나머지 문자열에 대해서도 동일하게 찾는다. (step = i 단위로 해서 찾는다.)
						prev = inner_current;
					}
//				}
				System.out.println("inner :: " + prev);

			}
		}
		System.out.println("answer :: " + countMap.toString());

		return result;
	}


	public static void main (String [] args){
		String question1 = "aabbaccc";
		String question2 = "ababcdcdababcdcd";
		String question3 = "abcabcdede";
		String question4 = "abcabcabcabcdededededede";
		String question5 = "xababcdcdababcdcd";

//		System.out.println("============== question1");
//		System.out.println(answer(question1));

//		System.out.println("============== question2");
//		System.out.println(answer(question2));

//		String test = "abcde";
//		System.out.println(test.substring(2,test.length()));

		System.out.println("============== question3 :: " + question3);
		System.out.println(answer(question3));
	}

}
