package c12;

import java.util.UUID;

public class Snake implements Cloneable {
	static {
		System.out.println("Loading Snake");
	}
	private static int mCount;
	private UUID mUUID;
	public Snake() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("Snake current uuid = " + mUUID.toString());
	}
	protected void finalize() {
		mCount--;
		System.out.println("Snake finalized uuid = " + mUUID.toString());
	}
//	public String toString() {
//		return "This is Snake #" + mUUID.toString();
//	}
	
	private Snake next;
	private char c;
	Snake(int i, char x) {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("Snake current uuid = " + mUUID.toString());
		
		c = x;
		if (--i > 0) {
			next = new Snake(i, (char) (x + 1));
		}
	}
	void increment() {
		c++;
		if (next != null) {
			next.increment();
		}
	}
	public String toString() {
		String s = ": " + c;
		if (next != null) {
			s += next.toString();
		}
		return s;
	}
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	public static void main(String[] args) {
		Snake s = new Snake(5, 'a');
		System.out.println("s = " + s);
		Snake s2 = (Snake) s.clone();
		s.increment();
		System.out.println("after s.increment, s2 = " + s2);
		
		System.runFinalizersOnExit(true);
	}
}
