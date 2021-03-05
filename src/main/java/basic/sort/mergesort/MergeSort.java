package basic.sort.mergesort;

public class MergeSort {

	public static int [] sorted = new int [8];
	public static int [] array 	= {2,5,7,8, 1,3,4,6};

	public static void main(String [] args){
//		merge(array, 0, array.length/2-1, array.length-1);
//		printArray(sorted);

		mergeSort(array, 0, array.length-1);
		printArray(sorted);
	}

	public static void mergeSort(int [] arr, int from, int to){
		int mid = 0;
		if(from < to){
			mid = (from + to)/2;
			mergeSort(arr, from, mid);
			mergeSort(arr, mid+1, to);
			merge(arr, from, mid, to);
		}
	}

	public static void merge(int [] arr, int left, int mid, int right){
		int i = 0;
		int s1 = left;
		int s2 = mid+1;

		while(s1 <= mid && s2 <= right){
			if(arr[s1] < arr[s2]){
				sorted[i++] = arr[s1++];
			}
			else if(arr[s1] > arr[s2]){
				sorted[i++] = arr[s2++];
			}
		}

		if(s1 <= mid){
			while(s1 <= mid){
				sorted[i++] = arr[s1++];
			}
		}
		else if(s2 <= right){
			while(s2 <= right){
				sorted[i++] = arr[s2++];
			}
		}

		printArray(sorted);
		System.out.println();
	}

	public static void printArray (int [] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]);
			if (i < arr.length - 1) {
				System.out.print(",");
			}
		}
	}

}
