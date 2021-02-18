package temp;

public class MakingNumberOne {
	public static void main(String [] args){
		int question = 7;
		int result = question;

		int [] arr = new int [1024];

//		for (int i=0; i<arr.length; i++){
//			System.out.println(arr[i]);
//		}

		while (true){
			if(result == 1) break;

			if(result%5 == 0 && result>=5) {
				arr[result/5] = arr[result] + 1; // 연산횟수 카운트 :: 이전 연산횟수(arr[result]) + 1 을 현재 연산횟수(arr[result/5])에 저장
				result = result / 5;
			}
			if(result%3 == 0 && result >=3) {
				arr[result/3] = arr[result] + 1; // 연산횟수 카운트 :: 이전 연산횟수(arr[result]) + 1 을 현재 연산횟수(arr[result/5])에 저장
				result = result / 3;
			}
			if(result%2 == 0 && result >=2) {
				arr[result/2] = arr[result] + 1; // 연산횟수 카운트 :: 이전 연산횟수(arr[result]) + 1 을 현재 연산횟수(arr[result/5])에 저장
				result = result / 2;
			}

			if(result > 1){
				arr[result-1] = arr[result] +1;
				result = result-1;
			}

		}

		System.out.println("question [="+ question +"] 에 대한 반복 연산을 한 횟수는 " + arr[1] + "회 입니다.");
	}
}
