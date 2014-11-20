package sorting;

public class SearchRotateList {
	public static int search(int[] a, int low, int high, int key) {
		int mid = (low + high) / 2;
		if (key == a[mid]) return mid;
		if (low > high) return -1;
		
		if (a[low] < a[mid]) { //left is normally ordered
			if (key >= a[low] && key <= a[mid])
				return search(a, low, mid - 1, key);
			else 
				return search(a, mid + 1, high, key);
		} else if (a[mid] < a[low]) { //right is normally ordered
			if (key >= a[mid] && key <= a[high])
				return search(a, mid + 1, high, key); //search right
			else 
				return search(a, low, mid - 1, key); //search left;
		} else { 
				if (a[mid] != a[high]) {//left half is all repeats
					return search(a, mid + 1, high, key);
				} else {
					int result = search(a, low, mid - 1, key); //search left;
					if (result == -1)
						return search(a, mid + 1, high, key);
					else return result;
				}	
		}
	}
	
	public static void main(String[] args) {
		int[] a = {2, 2, 2, 3, 4, 2};
		System.out.println(search(a, 0, a.length-1, 4));
	}
}
