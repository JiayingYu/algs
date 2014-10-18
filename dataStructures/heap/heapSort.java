package heap;

public class HeapSort {
	public static void heapSort(int[] array, int maxSize) {
		Heap heap = new Heap(maxSize, array);
		int size = array.length;
		
		for (int i = size / 2 - 1; i >=0; i--) {
			heap.trickleDown(i);
		}
		
		for (int i = 0; i < size; i++) {
			array[i] = heap.remove().getKey();
		}
	}
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		int[] rdArray = {35, 89, 90, 2 ,-32};
		heapSort(rdArray, 10);
		for (int i = 0; i < rdArray.length; i++) {
			System.out.print(rdArray[i] + " ");
		}
	}
}
