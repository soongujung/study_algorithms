package programmers.stringcompression.mapBased;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringCompression {

	/**
	 * String 문자열의 특정인덱스에 있는 문자 하나를 반환하는 유틸성격의 함수
	 * @param s
	 * @param idx
	 * @return
	 */
	public static String strAt(String s, int idx){
		return (s.charAt(idx)) + "";
	}

	/**
	 * 1단계)
	 * 	각 step을 for 문으로 동적으로 돌리지 않고 아래 함수 하나가 단위 연산을 수행하도록 1차원적인 기능 구현
	 * ex)
	 * 	input : aabbaccc
	 * 	중간답 : 2a2ba3c
	 * 	를 만드는 과정
	 * @param question
	 */
	public static void answerLevel1 (String question){
		Map<String, Integer> indexMap = new HashMap<String, Integer>();
		Map<String, Integer> wordMap = new HashMap<String, Integer>();
		List<String> appearance = new ArrayList<String>();	// 각 wordKey 의 출현 위치를 기억하려는 목표 ( ex. [0 -> 2 -> 4 -> 5]

		String prev = strAt(question, 0);
		String wordKey = 0 + prev;
		wordMap.put(wordKey, 1); // K,V : < any occured idx, count >
		appearance.add(wordKey);
		indexMap.put(prev, 0);

		for (int i=1; i<question.length(); i++){
			String s = strAt(question, i);

			// 문자 {a|b|c|d|...|z} 에 대해서 배열내에서의 인덱스 위치를 임시기억하도록 map.put(k,v)
			if(!indexMap.containsKey(strAt(question, i))){
//			if(!containsKey(indexMap, s)){
				indexMap.put(s, i);
			}

			// 인덱스a = a의 갯수, 인덱스b = b의 연속갯수, 인덱스c = c의 연속갯수, 두번째 a의 인덱스 = 두번째 a의 연속갯수
			// {2b=2, 0a=2, 4a=1, 5c=3}
			wordKey = indexMap.get(s) + s;

			// 이전 문자와 현재 문자가 같을 경우
			if (prev.equals(s)) {
				Integer count = wordMap.get(wordKey);
				wordMap.put(wordKey, count + 1);
			}

			// 이전 문자와 현재 문자가 다를 경우
			else{
				indexMap.remove(prev);	// 이전 문자의 인덱스 값 기억을 지운다.

				// 1a 2b 3c 등의 wordkey 가 Map에 존재하지 않을 경우
				if(!wordMap.containsKey(wordKey)){
					wordMap.put(wordKey, 1);
					appearance.add(wordKey);
				}
			}
			prev = s;
		}

		System.out.println("wordMap = " + wordMap.toString());
		System.out.println("appearance = " + appearance.toString());

		String result = "";
		for (String key : appearance){
			Integer i = wordMap.get(key);
			String alphbet = key.substring(key.length()-1);
			if(i > 1)
				result = result.concat(i + alphbet);
			if(i == 1){
				result = result.concat(alphbet);
			}
		}
		System.out.println(result);

	}

	/**
	 * 2단계)
	 * 	1단계에서 작성한 1차원적인 기억법을 for문에 적용시켜보기
	 * 	ex)
	 * 		input 				: aabbacc
	 * 		step (인덱스 변화) 	: 1,2,3,4,5,6
	 * 		step 으로 비교할 문자열 : "aa", "aab", "aabb", "aabba", "aabbac", "aabbacc"
	 * @param question
	 * @return
	 */
	public static int answerLevel2 (String question){
		int result = 0;
		Map<String, Integer> indexMap = new HashMap<String, Integer>();
		Map<String, Integer> wordMap = new HashMap<String, Integer>();
		List<String> appearance = new ArrayList<String>();	// 각 wordKey 의 출현 위치를 기억하려는 목표 ( ex. [0 -> 2 -> 4 -> 5]
		String wordKey = "";

		// 	substring(int beginIndex)
		for (int step = 1; step < question.length(); step++){
			String current = question.substring(0,step);
			String next = question.substring(step, step + step);
			System.out.println("(step, current) :: " + current + ", " + next);
			wordKey = step + wordKey;

			if(!indexMap.containsKey(current)){
				indexMap.put(current, step);
			}


		}
		System.out.println();
		return result;
	}


	public static void main(String [] args){
		String question1 = "aabbaccc";
		String question2 = "ababcdcdababcdcd";
		String question3 = "abcabcdede";
		String question4 = "abcabcabcabcdededededede";
		String question5 = "xababcdcdababcdcd";

		System.out.println("**************");
		System.out.println("============== question1");
		answerLevel1(question1);
		System.out.println("============== question2");
		answerLevel1(question2);
		System.out.println("============== question3");
		answerLevel1(question3);
		System.out.println("============== question4");
		answerLevel1(question4);
		System.out.println("============== question5");
		answerLevel1(question5);
		System.out.println("\n");

		System.out.println("**************");
		System.out.println("question1 :: " + question1);
		answerLevel2(question1);
		System.out.println("question2 :: " + question2);
		answerLevel2(question2);
	}
}
