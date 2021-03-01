package basic.binary_search.iteration;

public class BinarySerach_Iteration {

	public static void main(String [] args){
		int [] arr = {1,2,3,4,5};

		int left = 0;
		int right = arr.length;
		int mid = 0;
		int target = 3;
		int result = 0;

		while (left < right){
			mid = (left + right)/2;
			if(arr[mid] < target){
				right = mid;
			}
			else if(arr[mid] > target){
				left = mid;
			}
			else{
				result = mid;
				break;
			}
		}

		System.out.println("mid = " + mid);

	}

}
