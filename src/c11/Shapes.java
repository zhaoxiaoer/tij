package c11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

interface Shape {
	void draw();
}

class Circle implements Shape {
	private static int mCount;
	private UUID mUUID;
	Circle() {
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
	
	public void draw() {
		System.out.println("Circle.draw");
	}
}

class Square implements Shape {
	private static int mCount;
	private UUID mUUID;
	Square() {
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
	
	public void draw() {
		System.out.println("Square.draw");
	}
}

class Triangle implements Shape {
	private static int mCount;
	private UUID mUUID;
	Triangle() {
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
	
	public void draw() {
		System.out.println("Triangle.draw");
	}
}

public class Shapes {
	private static int mCount;
	private UUID mUUID;
	Shapes() {
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
		ArrayList<Shape> list = new ArrayList<Shape>();
		list.add(new Circle());
		list.add(new Square());
		list.add(new Triangle());
		Iterator<Shape> it = list.iterator();
		while (it.hasNext()) {
//			((Shape) it.next()).draw();
			it.next().draw();
		}
		
		System.runFinalizersOnExit(true);
	}
}
