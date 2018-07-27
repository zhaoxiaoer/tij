package c12;

import java.util.UUID;

class MyObject implements Cloneable {
	static {
		System.out.println("Loading MyObject");
	}
	private static int mCount;
	private UUID mUUID;
	public MyObject() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("MyObject current uuid = " + mUUID.toString());
	}
	protected void finalize() {
		mCount--;
		System.out.println("MyObject finalized uuid = " + mUUID.toString() + ", " + this);
	}
//	public String toString() {
//		return "This is MyObject #" + mUUID.toString();
//	}
	
	int i;
	MyObject(int ii) {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("MyObject current uuid = " + mUUID.toString());
		
		i = ii;
	}
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("MyObject can't clone");
		}
		return o;
	}
	public String toString() {
		return Integer.toString(i);
	}
}

public class LocalCopy {
	static {
		System.out.println("Loading LocalCopy");
	}
	private static int mCount;
	private UUID mUUID;
	public LocalCopy() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("LocalCopy current uuid = " + mUUID.toString());
	}
	protected void finalize() {
		mCount--;
		System.out.println("LocalCopy finalized uuid = " + mUUID.toString());
	}
	public String toString() {
		return "This is LocalCopy #" + mUUID.toString();
	}
	
	static MyObject g(MyObject v) {
		v.i++;
		return v;
	}
	static MyObject f(MyObject v) {
		v = (MyObject) v.clone();
		v.i++;
		return v;
	}
	
	public static void main(String[] args) {
		MyObject a = new MyObject(11);
		MyObject b = g(a);
		if (a == b) {
			System.out.println("a == b");
		} else {
			System.out.println("a != b");
		}
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		MyObject c = new MyObject(47);
		MyObject d = f(c);
		if (c == d) {
			System.out.println("c == d");
		} else {
			System.out.println("c != d");
		}
		
		System.runFinalizersOnExit(true);
	}
}
