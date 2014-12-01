package sorting;

public class SelectSort {
	public static void selectSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int minDex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[minDex])
					minDex = j;
			}
			swap(a, i, minDex);
		}
	}
	
	private static void swap(int[] a, int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
	
	public static void main(String[] args) {
		int[] a = {6, 9, 0, 123, 59, -31, 24};
		selectSort(a);
		for (int x : a) {
			System.out.print(x + ", ");
		}
	}
}
