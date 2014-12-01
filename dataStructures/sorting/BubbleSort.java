package sorting;

public class BubbleSort {
	public static void bubbleSort(int[] a) {
		for (int out = a.length - 1; out > 1; out--) {
			for (int in = 0; in < out; in++) {
				if (a[in] > a[in + 1])
					swap(a, in, in + 1);
			}
		}
	}
	
	private static void swap(int[] a, int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
	
	public static void main(String[] args) {
		int[] a = {6, 9, 0, 123, 59, -33, 24};
		bubbleSort(a);
		for (int x : a) {
			System.out.print(x + ", ");
		}
	}
}
