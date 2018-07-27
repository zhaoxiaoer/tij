package c12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

class Int {
	static {
		System.out.println("Loading Int");
	}
	private static int mCount;
	private UUID mUUID;
	public Int() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("Int current uuid = " + mUUID.toString());
	}
	protected void finalize() {
		mCount--;
		System.out.println("Int finalized uuid = " + mUUID.toString());
	}
//	public String toString() {
//		return "This is Int #" + mUUID.toString() + ", i = " + i;
//	}
	
	private int i;
	public Int(int ii) {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("Int current uuid = " + mUUID.toString());
		
		i = ii;
	}
	public void increment() {
		i++;
	}
	public String toString() {
		return Integer.toString(i);
	}
}

public class Cloning {
	static {
		System.out.println("Loading Cloning");
	}
	private static int mCount;
	private UUID mUUID;
	public Cloning() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("Cloning current uuid = " + mUUID.toString());
	}
	protected void finalize() {
		mCount--;
		System.out.println("Cloning finalized uuid = " + mUUID.toString());
	}
	public String toString() {
		return "This is Cloning #" + mUUID.toString();
	}
	
	public static void main(String[] args) {
		ArrayList v = new ArrayList();
		for (int i = 0; i < 10; i++) {
			v.add(new Int(i));
		}
		System.out.println("v: " + v);
		ArrayList v2 = (ArrayList) v.clone();
		for (Iterator it = v2.iterator(); it.hasNext(); ) {
			((Int) it.next()).increment();
		}
		System.out.println("v: " + v);
		
		System.runFinalizersOnExit(true);
	}
}
