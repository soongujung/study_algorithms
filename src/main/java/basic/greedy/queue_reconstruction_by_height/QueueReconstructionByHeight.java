package basic.greedy.queue_reconstruction_by_height;

import java.util.PriorityQueue;

public class QueueReconstructionByHeight {

	public static void main (String [] args){
		QueueReconstructionByHeight q = new QueueReconstructionByHeight();
		int [][] inputSample1 = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		int [][] inputSample2 = {{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}};

		int[][] result = q.reconstructQueue(inputSample1);

		q.printExpectedSample1();

//		q.printWholeArray(inputSample1);
	}

	class Person implements Comparable<Person>{
		public Integer height;
		public Integer tallerThanMeCnt;

		public Person(int height, int tallerThanMeCnt){
			this.height = height;
			this.tallerThanMeCnt = tallerThanMeCnt;
		}

		@Override
		public int compareTo(Person other) {
			if(this.height.equals(other.height)){
				return this.tallerThanMeCnt < other.tallerThanMeCnt ? -1: 1;
			}
//			return this.height < other.height ? 1: -1; // 역순 비교
			return this.height < other.height ? -1: 1;
//			return this.height.compareTo(other.height);
		}

		@Override
		public String toString() {
			return "Person{" +
				"height=" + height +
				", tallerThanMeCnt=" + tallerThanMeCnt +
				'}';
		}
	}

	public int[][] reconstructQueue(int[][] people) {
		PriorityQueue<Person> personQueue = new PriorityQueue<>();

		for (int i=0; i <people.length; i++){
			int height = people[i][0];
			int tallerThanMeCnt = people[i][1];

			Person p = new Person(height, tallerThanMeCnt);
			personQueue.offer(p);
		}

		System.out.println("======= answer ======= ");

		int size = personQueue.size();
		Person [] personArr = new Person [size];

		int minIndex = 0;
		while(!personQueue.isEmpty()){
			Person poll = personQueue.poll();

			if(personArr[poll.tallerThanMeCnt] == null){
				personArr[poll.tallerThanMeCnt] = poll;
			}
			else{
				while(personArr[minIndex] != null){
					minIndex++;
				}
				personArr[minIndex] = poll;
			}

			if(minIndex > poll.tallerThanMeCnt){
				minIndex = poll.tallerThanMeCnt;
			}
		}

		int [][] resultArr = new int[people.length][2];

		for(int i=0; i<personArr.length; i++){
			Person p = personArr[i];
			resultArr[i][0] = p.height;
			resultArr[i][1] = p.tallerThanMeCnt;
		}

		printWholeArray(resultArr);
		return resultArr;
	}

	public void printWholeArray(int [][] array){
		for(int [] subArr: array){
			System.out.print("(");
//			for(int d : subArr){
			for(int i=0; i<subArr.length; i++){
				System.out.print(subArr[i]);
				if (i == 0) {
					System.out.print(",");
				}
			}
			System.out.print(")->");
		}
		System.out.println("||");
	}

	public void printExpectedSample1(){
		System.out.println("======= expected data :: sample1 ======= ");
		int [][] expected = {{5,0},{7,0},{5,2},{6,1},{4,4},{7,1}};
		printWholeArray(expected);
	}
}
