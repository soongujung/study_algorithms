import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JavaStringTest {

	@Test
	@DisplayName("String::substring(i)")
	void testSubstringTest1(){
		String hello = "hello";
		String substring = hello.substring(1);
		System.out.println("substring = " + substring);
	}

	@Test
	@DisplayName("String::substring(i,j)")
	void testSubstringTest2(){
		String hello = "hello";
		String substring1 = hello.substring(0,1);
		System.out.println("substring1 = " + substring1);

		String substring2 = hello.substring(1,2);
		System.out.println("substring2 = " + substring2);
	}
}
