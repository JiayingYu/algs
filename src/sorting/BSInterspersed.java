package sorting;

public class BSInterspersed {
	private static int search(String[] strings, String key, int low, int high) {
		int mid = (low + high) / 2;
		if (strings[mid].isEmpty()) {
			mid = findNewMid(strings, mid, low, high);
		}
		if (mid == -1) return -1;
		if (key.equals(strings[mid])) return mid;
		if (key.compareTo(strings[mid]) > 0) {
			return search(strings, key, mid + 1, high);
		}else {
			return search(strings, key, low, mid - 1);
		}
	}
	
	private static int findNewMid(String[] strings, int mid, int low, int high) {
		int left = mid - 1;
		int right = mid + 1;
		while (left >= low && right <= high) {
			if (!strings[left].isEmpty()) {
				return left;
			}
			if (!strings[right].isEmpty()) {
				return right;
			}
			left--;
			right++;
		}
		return -1;
	}
	
	public static int search(String[] strs, String key) {
		return search(strs, key, 0, strs.length - 1);
	}
	
	public static void main(String[] args) {
		String[] strs = {"abc", "", "abcd", "fred", "", "deal", "", "real"};
		System.out.println(search(strs, "fred"));
	}
}
