package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.LinkedList;

class AnagramComparator implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		return sortChars(s1).compareTo(sortChars(s2));
	}
	
	public String sortChars(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}

}

public class SortAnagram {
	public static void sort(String[] a) {
		Arrays.sort(a, new AnagramComparator());
	}
	
	public static void hashSort(String[] a) {
		Hashtable<String, LinkedList<String>> hash = 
				new Hashtable<String, LinkedList<String>>();
		
		for (String s : a) {
			String key = sortChars(s);
			if (!hash.containsKey(key)) {
				hash.put(key, new LinkedList<String>());
			}
			LinkedList<String> anagrams = hash.get(key);
			anagrams.push(s);
		}
		
		int index = 0;
		for (String key : hash.keySet()) {
			LinkedList<String> list = hash.get(key);
			for (String t : list) {
				a[index] = t;
				index++;
			}
		}
	}
	
	private static String sortChars(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	public static void main(String[] args) {
		String[] a = {"car", "foo", "gun", "rac", "ofo", "arc", "nug", "jamm"};
//		sort(a);
		hashSort(a);
		for(String s : a) {
			System.out.print(s + ", ");
		}
	}
}
         