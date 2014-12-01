package sorting;

public class InsertionSort {
	public static void main(String[] args) {
		int[] a = {6, 9, 0, 167, 59, -31, 24};
		insertionSort(a);
		for (int x : a) {
			System.out.print(x + ", ");
		}
	}
	
	public static void insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int key = a[i];
			int j = i -1;
			while (j >= 0 && a[j] > key) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = key;
		}
	}
}
