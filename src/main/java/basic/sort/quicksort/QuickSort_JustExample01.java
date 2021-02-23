package basic.sort.quicksort;

public class QuickSort_JustExample01 {

	public static int [] arr = {11, 3, 7, 5, 9};

	public static void swap (int [] array, int left, int right){
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public static int partition (int [] subArray, int start, int end){
		int right = end;
		int pivot = end;
		int i = 0;

		for(int s = start; s<right; s++){
			if (subArray[pivot] > arr[s]){
				swap(subArray,i,s);
				i++;
			}
		}
		swap(subArray, pivot, i);

		return i;
	}

	public static void quickSort(int [] arr, int left, int right){
		if(left < right){
			int pivot = partition(arr, left, right);
			quickSort(arr, left, pivot-1);
			quickSort(arr, pivot+1, right);
		}
	}

	public static void printArray(int [] array){
		for(int i=0; i<array.length; i++){
			System.out.print(array[i] + "->");
		}
		System.out.println("||");
	}

	public static void main(String [] args){
		System.out.println("swap 전");
		printArray(arr);

		System.out.println("swap 후");
		swap(arr, 0,1);
		printArray(arr);

		System.out.println("");
		System.out.println("partition 해보기");
		int partition = partition(arr, 0, arr.length - 1);

		System.out.println("partition 후의 인덱스 = " + partition);
		printArray(arr);

		System.out.println("");
		System.out.println("quicksort 해보기");
		quickSort(arr, 0, arr.length-1);
		printArray(arr);
	}
}
