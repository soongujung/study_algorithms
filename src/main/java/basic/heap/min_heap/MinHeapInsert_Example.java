package basic.heap.min_heap;

public class MinHeapInsert_Example {
	public static final int MAX_SIZE = 10;

	static class Heap{
		public static int array[] = new int [MAX_SIZE];
		public static int size = 0;
	}

	public static void insert(Heap h, int data){
		int currentIndex = ++h.size;

		while((currentIndex!=1) && (data < h.array[currentIndex/2])){
			h.array[currentIndex] = h.array[currentIndex/2];
			currentIndex = currentIndex/2;
		}

		h.array[currentIndex] = data;
	}

	public static void printArray(int [] array){
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]);
			if(i < array.length-1){
				System.out.print(",");
			}
		}
		System.out.println();
	}

	public static void initHeap(Heap heap){
		heap.size = 0;
	}

	public static void main(String [] args){
		Heap heap = new Heap();
		initHeap(heap);

		insert(heap, 3);
		insert(heap, 5);
		insert(heap, 7);
		System.out.println("=====================");
		System.out.println("before rebuilding :: before insert 1");
		printArray(heap.array);

		System.out.println("=====================");
		System.out.println("after rebuilding :: after insert 1");
		insert(heap, 1);
		printArray(heap.array);

	}
}
