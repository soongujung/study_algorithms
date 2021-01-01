package programmers.stringcompression.iterationBased;

public class IterStringCompression {

	public static int answer(String question){
		int result = 0;

		for (int step = 1; step<question.length(); step++){
			String outer_current = question.substring(0, step);
			int subLimit = (int) Math.floor(question.length() / step);

			System.out.println("outer_current :: " + outer_current);

			for (int i = 1; i<=subLimit; i++){
				// beginIndex) substring 의 beginIndex
				// substring 을 하는 단위는 step 의 배수로 늘려나간다.
				int beginIndex = (i-1)*step;

				// endIndex) substring 의 endIndex
				// i*step 이 지정된 배열의 단위를 넘어서는 경우가 있기에 이에 대한 처리구문 추가
				int endIndex = (i*step) > question.length() ? question.length() : i*step;

				// 내부 for 루프 안에서 돌아가는 current
				String inner_current = "";

				// endIndex가 문자열의 범위를 넘어서게 되는 경우
				if (endIndex >= question.length()){
					inner_current = question.substring(beginIndex);
				}
				// endIndex가 문자열의 범위를 넘어서지 않는 경우
				else {
					inner_current = question.substring(beginIndex, endIndex);
				}
				System.out.println("inner_current ("+ i +") :: " + inner_current);
			}
		}

		return result;
	}


	public static void main (String [] args){
		String question1 = "aabbaccc";
		String question2 = "ababcdcdababcdcd";
		String question3 = "abcabcdede";
		String question4 = "abcabcabcabcdededededede";
		String question5 = "xababcdcdababcdcd";

		System.out.println("============== question1");
		System.out.println(answer(question1));
	}

}
