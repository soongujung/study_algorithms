import java.util.Arrays;
import org.junit.jupiter.api.Test;

class JavaCollectionTest {

	@Test
	void testCopyOfRange(){
		int [] numbers = {1,2,3,4,5,6,7,8,9,10};
		int[] left = Arrays.copyOfRange(numbers, 0, 4);
		int[] right = Arrays.copyOfRange(numbers, 4, numbers.length);

		System.out.println("left = " + Arrays.toString(left) + ", right = " + Arrays.toString(right));
	}
}
