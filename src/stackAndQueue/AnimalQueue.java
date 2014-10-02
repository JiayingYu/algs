package stackAndQueue;

import java.util.LinkedList;

public class AnimalQueue {
	private LinkedList<Dog> dogList = new LinkedList<Dog>();
	private LinkedList<Cat> catList = new LinkedList<Cat>();
	private int order = 0; //act as timeStamp
	
	public void enqueue(Animal a) {
		a.setOrder(order);
		order++;
		
		if(a instanceof Dog) {
			dogList.add((Dog)a);
		} else if (a instanceof Cat) {
			catList.add((Cat)a);
		}
	}
	
	public Animal dequeueAny() {
		if (dogList.size() == 0) {
			return dequeueCat();
		} else if(catList.size() == 0) {
			return dequeueDog();
		}
		
		Dog dog = dogList.poll();
		Cat cat = catList.poll();
		if (dog.isOlderThan(cat)) {
			return dequeueDog();
		} else {
			return dequeueCat();
		}
	}
	
	public Dog dequeueDog() {
		return dogList.poll();
	}
	
	public Cat dequeueCat() {
		return catList.poll();
	}
}

abstract class Animal {
	private String name;
	private int order;
	
	public Animal(String name) {
		this.name = name;
	}
	
	public int getOrder() {
		return order;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}
	
	public boolean isOlderThan(Animal a) {
		return order < a.getOrder();
	}
}


class Dog extends Animal {
	public Dog(String name) {
		super(name);
	}
}

class Cat extends Animal {
	public Cat(String name) {
		super(name);
	}
}