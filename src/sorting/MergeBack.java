package sorting;

public class MergeBack {
	public static void merge(int[] a, int[] b, int lastA) {//index of last element in A
		int indexA = lastA;
		int indexB = b.length - 1;
		int mergeDex = a.length - 1;
		while(indexA >= 0 && indexB >= 0) {
			if (a[indexA] > b[indexB]) {
				a[mergeDex] = a[indexA];
				--indexA;
				--mergeDex;
			} else {
				a[mergeDex] = b[indexB];
				--indexB;
				--mergeDex;
			}
		}
		while(indexB >= 0) {
			a[mergeDex] = b[indexB];
			--indexB;
			--mergeDex;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {4, 5, 12, 15, 0, 0, 0, 0};
		int[] arrB = {1, 3, 5, 9};
		merge(arr, arrB, 3);
		for (int i : arr) {
			System.out.print(i + ", ");
		}
	}
}
