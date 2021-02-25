import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComparableTest {

	@Test
	@DisplayName("Integer 데이터의 [small.compareTo(bigger)]")
	void testIntegerCompareTo(){
		Integer small = 1;
		Integer bigger = 2;
		int compare = small.compareTo(bigger); // small 이 bigger 보다 작으면 -1, small 이 bigger 보다 크면 +1
		System.out.println(compare);
	}

	/**
	 * 단순 priorityQueue 를 순회하는 것은 우선순위 순으로 데이터를 출력하지는 않는다.
	 */
	@Test
	@DisplayName("Priority Queue 테스트 #1 :: 단순 컬렉션 순회")
	void testIntegerCompareToPriorityQueue1(){
		PriorityQueue<Integer> iQueue = new PriorityQueue<>();
		List<Integer> integers = Arrays.asList(7, 6, 7, 5, 5, 4);
		integers.stream()
			.forEach(i -> {
				iQueue.offer(i);
			});

		iQueue.stream()
			.forEach(i -> {
				System.out.println(i);
			});
	}

	@Test
	@DisplayName("Priority Queue 테스트 #2 :: poll 을 이용한 순회")
	void testIntegerCompareToPriorityQueue2(){
		PriorityQueue<Integer> iQueue = new PriorityQueue<>();
		List<Integer> integers = Arrays.asList(7, 6, 7, 5, 5, 4);
		integers.stream()
			.forEach(i -> {
				iQueue.offer(i);
			});

		while(!iQueue.isEmpty()){
			Integer poll = iQueue.poll();
			System.out.println(poll);
		}
	}

	@Test
	void testArrayList(){
		List<Integer> integers = Arrays.asList(5, 1, 2, 3, 4);
		int a = 0;
		Integer data = integers.get(a);
		System.out.println(data);
	}
}
