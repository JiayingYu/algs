package sorting;

public class MergeSort {
	public static void mergeSort(int[] array) {
		mergeSort(array, 0, array.length - 1);
	}
	public static void mergeSort(int[] array, int low, int high) {
		if (low >= high)
			return;
		int mid = (low + high) / 2;
		mergeSort(array, low, mid);
		mergeSort(array, mid+1, high);
		merge(array, low, mid, high);
	}
	
	private static void merge(int[] array, int low, int mid, int high) {
		int[] helper  = new int[array.length];
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}
		
		int left = low;
		int right = mid+1;
		int current = low;
		
		while(left <= mid && right <= high) {
			if (helper[left] <= helper[right]) {
				array[current] = helper[left];
				left++;
			} else {
				array[current] = helper[right];
				right++;
			}
			current++;
		}
		
		for (int i = left; i <= mid; i++) {
			array[current] = helper[i];
			current++;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {2, 5, 8, 0, 3, 19, 4, 42, 9};
		mergeSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
	}
}
