package stackAndQueue;

import java.util.LinkedList;

public class AnimalQueue {
	private LinkedList<Dog> dogList = new LinkedList<Dog>();
	private LinkedList<Cat> catList = new LinkedList<Cat>();
	private int order = 0; // act as timeStamp

	public void enqueue(Animal a) {
		a.setOrder(order);
		order++;

		if (a instanceof Dog) {
			dogList.add((Dog) a);
		} else if (a instanceof Cat) {
			catList.add((Cat) a);
		}
	}

	public Animal dequeueAny() {
		if (dogList.size() == 0) {
			return dequeueCat();
		} else if (catList.size() == 0) {
			return dequeueDog();
		}

		Dog dog = dogList.peek();
		Cat cat = catList.peek();
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

	public static void main(String[] args) {
		Dog d1 = new Dog("dog 1");
		Dog d2 = new Dog("dog 2");
		Dog d3 = new Dog("dog 3");
		Cat c1 = new Cat("cat 1");
		Cat c2 = new Cat("cat 2");
		Cat c3 = new Cat("cat 3");
		
		AnimalQueue q = new AnimalQueue();
		q.enqueue(c1);
		q.enqueue(d1);
		q.enqueue(c2);
		q.enqueue(d2);
		q.enqueue(c3);
		q.enqueue(d3);
		
		System.out.println(q.dequeueAny());
		System.out.println(q.dequeueAny());
		
		System.out.println(q.dequeueCat());
		System.out.println(q.dequeueCat());

		System.out.println(q.dequeueDog());
		System.out.println(q.dequeueDog());

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
	
	public String toString() {
		return name;
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