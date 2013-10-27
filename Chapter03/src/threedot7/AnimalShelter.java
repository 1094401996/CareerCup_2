package threedot7;

import java.util.Deque;
import java.util.LinkedList;

abstract class Animal{
	protected String name;
	protected int order;
	
	public Animal(String name){
		this.name = name;
	}
	
	public int getOrder(){
		return this.order;
	}
	public void setOrder(int order){
		this.order = order;
	}
	public boolean isOlderthan(Animal a){
		return this.order < a.getOrder();
	}
	
	public String getName(){
		return this.name;
	}
	
}

class Dog extends Animal{
	public Dog(String name){
		super(name);
	}
}

class Cat extends Animal{
	public Cat(String name){
		super(name);
	}
}


public class AnimalShelter {
	Deque<Dog> dogs = new LinkedList<Dog>();
	Deque<Cat> cats = new LinkedList<Cat>();
	private int order;
	
	public void enqueue(Animal a){
		a.setOrder(order);
		if(a instanceof Dog){
			dogs.offer((Dog)a);
		}
		else{
			cats.offer((Cat)a);
		}
		order++;	
	}
	public Animal dequeueAny(){
		if(cats.isEmpty())
			return dogs.poll();
		if(dogs.isEmpty())
			return cats.poll();
		if(dogs.peek().isOlderthan(cats.peek())){
			return dogs.poll();
		}
		return cats.poll();
	}
	public Cat dequeueCat(){
		return cats.poll();
	}
	public Dog dequeueDog(){
		return dogs.poll();
	}
	public static void main(String[] args){
		Dog d1 = new Dog("d1");
        Dog d2 = new Dog("d2");
        Dog d3 = new Dog("d3");
        Dog d4 = new Dog("d4");
        Dog d5 = new Dog("d5");
        Cat c1 = new Cat("c1");
        Cat c2 = new Cat("c2");
        Cat c3 = new Cat("c3");
        Cat c4 = new Cat("c4");
        AnimalShelter as = new AnimalShelter();
        as.enqueue(d1);
        as.enqueue(c4);
        as.enqueue(d3);
        as.enqueue(d2);
        as.enqueue(c1);
        as.enqueue(c2);
        as.enqueue(d5);
        as.enqueue(d4);
        as.enqueue(c3);
        for(int i = 0 ; i < 3 ; i++ ){
                System.out.println(as.dequeueAny().getName());
        }
        System.out.println(as.dequeueCat().getName());
	}
}
