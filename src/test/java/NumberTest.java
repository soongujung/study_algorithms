import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberTest {

	// Math.ceil 올림
	// Math.round 반올림
	// Math.floor 버림

	@Test
	@DisplayName("올림")
	void testMathCeil(){
		Double d = 100.111;
		double ceilResult = Math.ceil(d);
		System.out.println(ceilResult);
	}

	@Test
	@DisplayName("반올림")
	void testMathRound(){
		Double d1 = 100.71D;
		long roundResult1 = Math.round(d1);
		System.out.println(roundResult1);

		// 소숫점 세번째 자리에서 반올림 (소숫점 두번째 자리까지 표시)
		Double d2 = 100.717D;
		double roundResult2 = Math.round(d2 * 100) / 100.0;
		System.out.println(roundResult2);
	}
	
	@Test
	@DisplayName("버림")
	void testMathFloor(){
		Double d = 100.6789;
		double floorResult = Math.floor(d);
		System.out.println(floorResult);
	}
}
