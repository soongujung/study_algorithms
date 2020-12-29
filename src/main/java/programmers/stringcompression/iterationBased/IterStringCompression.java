package programmers.stringcompression.iterationBased;

public class IterStringCompression {

	public static int answer(String question){
		int result = 0;

		for (int step = 0; step < question.length(); step++){
			String compressedStr = "";
			String prev = question.substring(0, step);

			// ...

			int count = 0;
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
//		System.out.println("============== question2");
//		answerLevel1(question2);
	}

}
