package sorting;

public class BinarySearch {
	public static int binarySearch(int[] a, int key) {
		int low = 0;
		int high = a.length;
		int mid;
		
		while (low <= high) {
			mid = (low + high) / 2;
			if (key < a[mid])
				high = mid - 1;
			else if (key > a[mid])
				low = mid + 1;
			else
				return mid;
		}
		
		return -1;
	}
	
	public static int BSRec(int[] a, int key, int low, int high) {
		if (low > high) return -1;
		int mid = (low + high) / 2;
		if (a[mid] > key)
			return BSRec(a, key, low, mid - 1);
		else if (a[mid] < key)
			return BSRec(a, key, mid + 1, high);
		else
			return mid;
	}
}
