package basic.sort.mergesort;

public class MergeSort_MergeFunction {

	public static int [] sorted = new int [8];
	public static int [] array = {2,5,7,8, 1,3,4,6};

	/**
	 * 처음 짜본 merge1 함수는 좀 구리다. 그래서 merge2 함수를 하나 더 만들기로 결정했다.
	 * @param array
	 * @param left
	 * @param mid
	 * @param right
	 */
	public static void merge1 (int [] array, int left, int mid, int right){
//		int s1 = left;
//		int s2 = mid+1;
		int s1 = array[left];
		int s2 = array[mid+1];

		int leftIndex = left;
		int rightIndex = mid+1;

		int i = 0;

		while(i < array.length && leftIndex<=mid && rightIndex <=right){
			if(s1 < s2){
				sorted[i] = array[leftIndex];
				leftIndex++;
				if(leftIndex <= mid) s1 = array[leftIndex];
			}
			else{
				sorted[i] = array[rightIndex];
				rightIndex++;
				if(rightIndex <= right) s2 = array[rightIndex];
			}
			i++;
		}

		if(leftIndex != mid){
			while(i < array.length){
				sorted[i] = array[leftIndex++];
				i++;
			}
		}

		if(rightIndex != right){

		}
	}

	/**
	 * 병합정렬의 분할/정복/병합 파트 중 병합 부분
	 * 병합정렬은 실질적으로 마지막에 모두 분해한 요소를 병합할때 정렬을 수행한다.
	 * 소규모 배열을 1/2 크기만큼 쪼개서 비교해가며 요소를 배치한다.
	 * @param array
	 * @param left
	 * @param mid
	 * @param right
	 */
	public static void merge2 (int [] array, int left, int mid, int right){
		int i=0;
		int s1 = left;
		int s2 = mid+1;

		while(s1 <= mid && s2 <= right){
			if(array[s1] < array[s2]){
				sorted[i++] = array[s1++];
			}
			else{
				sorted[i++] = array[s2++];
			}
		}

		if(s1 < mid){
			while(s1<=mid){
				sorted[i++] = array[s1++];
			}
		}
		else{
			while(s2<=right){
				sorted[i++] = array[s2++];
			}
		}
	}

	public static void printArray (int [] array){
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]);

			if (i < array.length-1) System.out.print(",");
		}
		System.out.println("");
	}


	public static void main (String [] args){
//		merge1(array, 0, array.length/2 -1, array.length-1);
//		printArray(sorted);

		merge2 (array, 0, array.length/2 -1, array.length-1);
		printArray(sorted);
	}
}
