package geeksforgeeks.findlessthan;

public class FindLessThanWhich {

	public static int countLessThan(int [] arr, int lessThan){
		int left = 0;
		int right = arr.length;
		int mid = 0;

		while (left < right){	// left, right 를 검사하면서...
			mid = (right + left) >> 1;

			if(arr[mid] == lessThan){
				return mid;
			}
			else if (arr[mid] > lessThan)
				right = mid;
			else
				left = mid + 1;
		}

		return mid+1;
	}

	public static void main(String [] args){
		System.out.println(FindLessThanWhich.countLessThan(new int[]{1,3,5,7}, 4));
	}
}
