package programmers.stringcompression.iterationBased;

public class IterStringCompression {

	public static int answer(String question){
		int result = 0;

		for (int step = 1; step<question.length(); step++){
			String first = question.substring(0, step);
			int subLimit = (int) Math.floor(question.length() / step);
			System.out.println("first :: " + first);

			for (int i = 1; i<=subLimit; i++){
				int beginIndex = (i-1)*step;
				int endIndex = (i*step) > question.length() ? question.length() : i*step;

				String next = "";

				if (endIndex == question.length()){
					next = question.substring(beginIndex);
				}
				else if (endIndex > question.length()){
					next = question.substring(beginIndex);
				}
				else {
					next = question.substring(beginIndex, endIndex);
				}

				System.out.println("next ("+ i +") :: " + next);
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
