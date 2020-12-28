package programmers.stringcompression.mapBased;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringCompression {

	/**
	 * 2 단계)
	 * 	for 문으로 추상화하기
	 * 	모든 패턴에 대한 맵을 만들어본다.
	 * 	ababcdcdababcdcd
	 * @param s
	 * @param idx
	 * @return
	 */
	public static String strAt(String s, int idx){
		return (s.charAt(idx)) + "";
	}

	public static boolean containsKey (Map<String, Integer> map, String key){
		return map.containsKey(key);
	}

	/**
	 * 1단계)
	 * 	for 문으로 동적으로 돌리지 않고 아래 함수 하나가 단위 연산을 수행하도록 1차원적인 기능 구현
	 * ex)
	 * 	input : aabbaccc
	 * 	중간답 : 2a2ba3c
	 * 	를 만드는 과정
	 * @param inputString
	 */
	public static void answerLevel1 (String inputString){
		Map<String, Set<Integer>> indexTableSet = new HashMap<String, Set<Integer>>();
		Map<String, Integer> indexMap = new HashMap<String, Integer>();
		Map<String, Integer> wordMap = new HashMap<String, Integer>();
		int appearCnt = 0;

		String prev = strAt(inputString, 0);
//		String prev = inputString.substring(0, 1);
		String wordKey = 0 + prev;
		wordMap.put(wordKey, 1); // K,V : < any occured idx, count >
		indexMap.put(prev, 0);

		for (int i=1; i<inputString.length(); i++){
			String s = strAt(inputString, i);

			if(!containsKey(indexMap, s)){
//			if(!indexMap.containsKey(s.substring(i, i+1))){
				indexMap.put(s, i);
			}

			// 인덱스a = a의 갯수, 인덱스b = b의 연속갯수, 인덱스c = c의 연속갯수, 두번째 a의 인덱스 = 두번째 a의 연속갯수
			// {2b=2, 0a=2, 4a=1, 5c=3}
			wordKey = indexMap.get(s) + s;
			if (prev.equals(s)) {
				Integer count = wordMap.get(wordKey);
				wordMap.put(wordKey, count + 1);
				indexMap.remove(prev);
			}
			else{
				if(!wordMap.containsKey(wordKey)){
					wordMap.put(wordKey, 1);
				}
			}
//			wordKey = indexMap.get(s) + s;
			prev = s;
//			if(wordMap.containsKey())
		}

		String temp = "";
		for(String key : wordMap.keySet()){
			String prefix = key.substring(0, 1);
			System.out.println(prefix);
		}

		System.out.println(wordMap.toString());

	}

	/**
	 * 2단계) for 문으로 변경
	 * @param args
	 */

	public static void main(String [] args){
		String question1 = "aabbaccc";
		String question2 = "ababcdcdababcdcd";
		String question3 = "abcabcdede";
		String question4 = "abcabcabcabcdededededede";
		String question5 = "xababcdcdababcdcd";

		answerLevel1(question1);
	}
}
