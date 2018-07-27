package tij.chapter11;

import java.util.UUID;

class Candy {
	private static int mCount;
	private UUID mUUID;
	Candy() {
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
	
	static {
		System.out.println("Loading Candy");
	}
}

class Gum {
	private static int mCount;
	private UUID mUUID;
	Gum() {
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
	
	static {
		System.out.println("Loading Gum");
	}
}

class Cookie {
	private static int mCount;
	private UUID mUUID;
	Cookie() {
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
	
	static {
		System.out.println("Loading Cookie");
	}
}

public class SweetShop {
	private static int mCount;
	private UUID mUUID;
	SweetShop() {
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
		System.out.println("inside main");
		new Candy();
		System.out.println("After creating Candy");
		try {
			Class.forName("Gum");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("After Class.forName(\"Gum\")");
		new Cookie();
		System.out.println("After creating Cookie");
		
		System.runFinalizersOnExit(true);
	}
}
