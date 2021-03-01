import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

	public static int binarySearch_iteration(int [] arr, int target){
		int left = 0;
		int right = arr.length-1;
		int mid = left + right;
		int result = 0;
		while(true){
			mid = (left + right) / 2;

			if (arr[mid] < target){ // move right
				left = mid+1;
			}
			else if (arr[mid] > target){
				right = mid-1;
			}
			else{
				result = mid;
				break;
			}
		}
		return result;
	}

	@Test
	@DisplayName("반복문 기반 BinarySearch")
	void testBinarySearch_Iteration(){
		int [] arr1 = {1,3,6,7,9,10,20,23,25};
		int target = 7;

		int i = binarySearch_iteration(arr1, target);
		System.out.println(arr1[i] + ", index is " + i);
	}

	public static int binarySearch_Recursion(int [] arr, int left, int right, int target){
		int result = 0;
		int mid = (left+right)/2;
		if (target > arr[mid]){ // move right
			return binarySearch_Recursion(arr, mid+1, right, target);
		}
		else if (target < arr[mid]){ // move left
			return binarySearch_Recursion(arr, left, mid-1, target);
		}
		else {
			return mid;
		}
	}

	@Test
	@DisplayName("재귀 기반 BinarySearch")
	void testBinarySearch_Recursion(){
		int [] arr1 = {1,3,6,7,9,10,20,23,25};
		int target = 7;

		int i = binarySearch_Recursion(arr1, 0, arr1.length - 1, 7);
		System.out.println(arr1[i] + ", index is " + i);
	}


}
