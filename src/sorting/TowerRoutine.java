package sorting;

import java.util.ArrayList;
import java.util.Collections;

public class TowerRoutine {
	public static int longestTower(ArrayList<Person> people) {
		Collections.sort(people);
		int[] r = longestSeq(people);
		int longest = 0;
		for (int len : r) {
			if (len > longest)
				longest = len;
		}
		return longest;
	}
	
	private static int[] longestSeq(ArrayList<Person> people) {
		int[] r = new int[people.size()]; //store the LIS length end at i
		r[0] = 1;
		for (int i = 1; i < people.size(); i++) {
			int maxlen = 0;
			for (int j = 0; j < i; j++) {
				if (people.get(i).wt > people.get(j).wt && r[j]> maxlen)
					maxlen = r[j];
			}
			r[i] = maxlen + 1;
		}
		return r;
	}
	
	public static void main(String[] args) {
		ArrayList<Person> people = new ArrayList<Person>();
		people.add(new Person(111, 160));
		people.add(new Person(120, 159));
		people.add(new Person(121, 168));
		people.add(new Person(127, 171));
		people.add(new Person(130, 173));
		people.add(new Person(135, 176));
		people.add(new Person(143, 169));
		people.add(new Person(146, 178));
		int longest = longestTower(people);
		System.out.println(longest);
	}
}



class Person implements Comparable<Person>{
	int wt;
	int ht;
	
	public Person (int weight, int height){
		wt = weight;
		ht = height;
	}

	@Override
	public int compareTo(Person p2) {
		if (this.ht != p2.ht) {
			return ((Integer)this.ht).compareTo(p2.ht);
		} else {
			return ((Integer)this.wt).compareTo(p2.wt);
		}
	}
}

