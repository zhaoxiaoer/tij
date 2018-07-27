package c11;

import java.util.UUID;

interface HasBetteries {
	
}

interface Waterproof {
	
}

interface ShootsThings {
	
}

class Toy {
	static {
		System.out.println("Loading Toy");
	}
	private static int mCount;
	private UUID mUUID;
	Toy() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("Toy current uuid = " + mUUID.toString() + ", count = " + mCount);
	}
	Toy(int i) {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("Toy current uuid = " + mUUID.toString() + ", count = " + mCount);
	}
	protected void finalize() {
		mCount--;
		System.out.println("Toy finalized uuid = " + mUUID.toString() + ", count = " + mCount);
	}
	public String toString() {
		return "This is Toy #" + mUUID.toString();
	}
}

class FancyToy extends Toy implements HasBetteries, Waterproof, ShootsThings {
	static {
		System.out.println("Loading FancyToy");
	}
	private static int mCount;
	private UUID mUUID;
	FancyToy() {
		super(1);
		
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("FancyToy current uuid = " + mUUID.toString() + ", count = " + mCount);
	}
	protected void finalize() {
		mCount--;
		System.out.println("FancyToy finalized uuid = " + mUUID.toString() + ", count = " + mCount);
	}
	public String toString() {
		return "This is FancyToy #" + mUUID.toString();
	}
}

public class ToyTest {
	static {
		System.out.println("Loading ToyTest");
	}
	private static int mCount;
	private UUID mUUID;
	ToyTest() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("ToyTest current uuid = " + mUUID.toString() + ", count = " + mCount);
	}
	protected void finalize() {
		mCount--;
		System.out.println("ToyTest finalized uuid = " + mUUID.toString() + ", count = " + mCount);
	}
	public String toString() {
		return "This is ToyTest #" + mUUID.toString();
	}
	
	static void printInfo(Class c) {
		System.out.println("Class name: " + c.getName() + " is interface?[" + c.isInterface() + "]");
	}
	public static void main(String[] args) {
		Class c = null;
		try {
			c = Class.forName("tij.chapter11.FancyToy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		printInfo(c);
		Class[] faces = c.getInterfaces();
		for (int i = 0; i < faces.length; i++) {
			printInfo(faces[i]);
		}
		Class cy = c.getSuperclass();
		Object o = null;
		try {
			o = cy.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		printInfo(o.getClass());
		
		System.runFinalizersOnExit(true);
	}
}
