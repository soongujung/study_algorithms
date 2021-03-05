import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class JavaRecursionTest {

	public int halfArray(int [] arr){
		final int SIZE = arr.length;
		final int HALF = SIZE/2;

		if(SIZE == 1) return arr[0];

		int[] subArray = Arrays.copyOfRange(arr, 0, HALF);
		int result = halfArray(subArray);
		return result;
	}

	@Test
	void testJavaRecursion(){
		int [] sampleArray1 = {1,2,3,4,5,6,7};
		halfArray(sampleArray1);
	}
}
