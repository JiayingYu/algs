import java.util.Random;


public class QuickSort {
	public static void quickSort(int[] arr, int low, int high) {
		if (low >= high) return;
		int j = partition2(arr, low, high);
		quickSort(arr, low, j-1);
		quickSort(arr, j+1, high);
		
	}
	
	public static void quickSort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}
	
	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[low];
		int left = low + 1;
		int right = high;
		while(true) {
			while (arr[left] <= pivot && left < high) {
				left++;
			}
			while (arr[right] >= pivot && right > low) {
				right--;
			}
			if (left >= right) break;
			swap(arr, left, right);
		}
		swap(arr, low, right);
		return right;
	}
	
	private static int partition2(int[] arr, int low, int high) {
		int pivot = arr[low];
		int i = low;
		for (int j = low + 1; j <= high; j ++) {
			if (arr[j] < pivot) swap(arr, ++i, j);
		}
		swap(arr, low, i);
		return i;
	}
	
	private static void swap(int[] arr, int x, int y) {
		if (x != y) {
			int temp = arr[x];
			arr[x] = arr[y];
			arr[y] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {4, 5, 9, 2, 0, 5, 3};
		quickSort(a);
		for (int i : a) {
			System.out.print(i + ", ");
		}
	}
}
