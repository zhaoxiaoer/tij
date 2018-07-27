package c10;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

class House implements Serializable {
	private static int mCount;
	private UUID mUUID;
	House() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println(getClass().getName() + " current uuid = " + mUUID.toString() + ", count = " + mCount);
	}
	protected void finalize() {
		mCount--;
		System.out.println(getClass().getName() + " finalized uuid = " + mUUID.toString() + ", count = " + mCount);
	}
	public String toString() {
		return "This is " + getClass().getName() + " #" + mUUID.toString();
	}
}

class Animal implements Serializable {
	private static int mCount;
	private UUID mUUID;
	Animal() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println(getClass().getName() + " current uuid = " + mUUID.toString() + ", count = " + mCount);
	}
	protected void finalize() {
		mCount--;
		System.out.println(getClass().getName() + " finalized uuid = " + mUUID.toString() + ", count = " + mCount);
	}
//	public String toString() {
//		return "This is " + getClass().getName() + " #" + mUUID.toString();
//	}
	
	String name;
	House preferredHouse;
	Animal(String nm, House h) {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println(getClass().getName() + " current uuid = " + mUUID.toString() + ", count = " + mCount);
		
		name = nm;
		preferredHouse = h;
	}
	public String toString() {
		return name + "[" + super.toString() + "], " + preferredHouse + "\n";
	}
}

public class MyWorld {
	private static int mCount;
	private UUID mUUID;
	MyWorld() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println(getClass().getName() + " current uuid = " + mUUID.toString() + ", count = " + mCount);
	}
	protected void finalize() {
		mCount--;
		System.out.println(getClass().getName() + " finalized uuid = " + mUUID.toString() + ", count = " + mCount);
	}
	public String toString() {
		return "This is " + getClass().getName() + " #" + mUUID.toString();
	}
	
	public static void main(String[] args) {
		House house = new House();
		ArrayList animals = new ArrayList();
		animals.add(new Animal("Bosco the dog", house));
		animals.add(new Animal("Ralph the hamster", house));
		animals.add(new Animal("Fronk the cat", house));
		System.out.println("animals: " + animals);
		
		try {
			 ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
			 ObjectOutputStream o1 = new ObjectOutputStream(buf1);
			 o1.writeObject(animals);
			 o1.writeObject(animals); // Write a 2nd set
			 // Write to a different stream
			 ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
			 ObjectOutputStream o2 = new ObjectOutputStream(buf2);
			 o2.writeObject(animals);
			 
			 // Now get them back:
			 ObjectInputStream in1 = new ObjectInputStream(
					 new ByteArrayInputStream(
							 buf1.toByteArray()));
			 ObjectInputStream in2 = new ObjectInputStream(
					 new ByteArrayInputStream(
							 buf2.toByteArray()));
			 ArrayList animals1 = (ArrayList) in1.readObject();
			 ArrayList animals2 = (ArrayList) in1.readObject();
			 ArrayList animals3 = (ArrayList) in2.readObject();
			 System.out.println("animals1: " + animals1);
			 System.out.println("animals2: " + animals2);
			 System.out.println("animals3: " + animals3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.runFinalizersOnExit(true);
	}
}
