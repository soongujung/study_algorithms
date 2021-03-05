package basic.devide_and_conquer.major_element;

import java.util.Arrays;

public class MajorityElement {
	public static void main (String [] args){
		int [] sample1 = {3,2,3};
		int [] sample2 = {2,2,1,1,1,2,2};
		int [] sample3 = {2,7,7};

		MajorityElement m = new MajorityElement();
//		int result1 = m.majorityElement(sample1);
//		int result2 = m.majorityElement(sample2);
		int result3 = m.majorityElement(sample3);
//		System.out.println("sample1 의 과반수 숫자 = " + result1);
//		System.out.println("sample2 의 과반수 숫자 = " + result2);
		System.out.println("sample2 의 과반수 숫자 = " + result3);

	}

	public static int countNumber(int [] arr, int number){
		int cnt = 0;
		for(int i=0; i<arr.length; i++){
			int data_i = arr[i];
			if(data_i == number){
				cnt++;
			}
		}
		return cnt;
	}

	public int majorityElement(int[] nums) {
		final int SIZE = nums.length;
		final int HALF = SIZE/2;

		if(SIZE == 1) return nums[0];

		int [] left = Arrays.copyOfRange(nums, 0, HALF);
		int [] right = Arrays.copyOfRange(nums, HALF, SIZE);

		int leftMax = majorityElement(left);
		int rightMax = majorityElement(right);
//		boolean isLeftMaxMajor = leftMax > HALF;
		boolean isLeftMaxMajor = countNumber(nums, leftMax) > HALF;

		if(isLeftMaxMajor) return leftMax;
		else return rightMax;
	}
}
