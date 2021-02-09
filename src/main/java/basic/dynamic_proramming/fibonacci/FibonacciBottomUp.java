package basic.dynamic_proramming.fibonacci;

/**
 * 반복문 기반 메모이제이션 (Bottom Up 방식)
 */
public class FibonacciBottomUp {

	/**
	 * 입력 사이즈에 따라서 fibonacci (n) 을 계산
	 * @param n
	 * @return
	 */
	public static int fibonacci(int n){
		int arr [] = new int [n+1];

		for (int i=1; i<arr.length; i++){
			if (i == 1) {
				arr[i] = 1;
				continue;
			}
			if (i == 2) {
				arr[i] = 2;
				continue;
			}
			arr[i] = arr[i-1] + arr[i-2];
		}

		return arr[n];
	}

	public static void main(String [] args){
		int fibonacci = fibonacci(5);
		System.out.println("fibonacci(5) == " + fibonacci);
	}

	// 그냥 size = 5 인 배열을 예로 들어서 예제를 만들어봄
	public static int example(){
		int [] memo = {0, 0, 0, 0, 0, 0};

		for (int i=1; i<memo.length; i++){
			if(i==1) {
				memo[i] = 1;
				continue;
			}
			if(i==2){
				memo[i] = 2;
				continue;
			}

			memo[i] = memo[i-1] + memo[i-2];
		}

		System.out.println(memo[5]);
		return memo[5];
	}
}
