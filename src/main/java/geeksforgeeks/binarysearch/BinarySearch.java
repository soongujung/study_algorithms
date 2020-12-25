package geeksforgeeks.binarysearch;

public class BinarySearch {

	public static int searchNumber(int [] a, int target){
		int result = -1;
		int left = 0;
		int right = a.length;
		int mid = 0;

		while(left < right){
			mid = (left + right)/2;
			int e = a[mid];

			if(e < target){			// 찾으려는 숫자가 더 크면 검색 범위를 오른쪽 그룹으로 이동
				left = mid +1;
			}
			else if (e > target){	// 찾으려는 숫자가 더 작으면 검색 범위를 왼쪽 그룹으로 이동
				right = mid -1;
			}
			else{
				result = mid;
				break;
			}
		}

		return result;
	}

	public static void main (String [] args){
		int [] sortedArr = new int [] {1,2,3,4,5};
		int number = 1;
		System.out.println("The number " + number + " is at " + BinarySearch.searchNumber(sortedArr, number));
	}
}
