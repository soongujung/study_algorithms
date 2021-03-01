package basic.binary_search.recursive;

public class BinarySearch_Recursive {

	public static void main(String [] args){
		int [] arr = {1,2,3,4,5,6,7,8,9,10,11,12};
		int data1 = recursiveBinarySearch(arr, 3, 0, arr.length);
		System.out.println("Query = "+ 3 +"Data = " + data1);

		int data2 = recursiveBinarySearch(arr, 6, 0, arr.length);
		System.out.println("Query = "+ 6 +"Data = " + data2);

		int data3 = recursiveBinarySearch(arr, 8, 0, arr.length);
		System.out.println("Query = "+ 8 +"Data = " + data3);
	}

	public static int recursiveBinarySearch(int [] arr, int target, int left, int right){
		int mid = (left + right)/2;
		if (target < arr[mid]) { // move left
			return recursiveBinarySearch(arr, target, left, mid);
		}
		else if (target > arr[mid]){
			return recursiveBinarySearch(arr, target, mid, right);
		}
		else{
			return mid;
		}
	}
}
