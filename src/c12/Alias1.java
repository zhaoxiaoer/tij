package c12;

import java.util.UUID;

public class Alias1 {
	static {
		System.out.println("Loading Alias1");
	}
	private static int mCount;
	private UUID mUUID;
	public Alias1() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("Alias1 current uuid = " + mUUID.toString());
	}
	int i;
	public Alias1(int ii) {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("Alias1 current uuid = " + mUUID.toString());
		
		i = ii;
	}
	protected void finalize() {
		mCount--;
		System.out.println("Alias1 finalized uuid = " + mUUID.toString());
	}
	public String toString() {
		return "This is Alias1 #" + mUUID.toString() + ", i = " + i;
	}
	
	public static void main(String[] args) {
		Alias1 x = new Alias1(7);
		Alias1 y = x;
		System.out.println("x: " + x.i);
		System.out.println("y: " + y.i);
		System.out.println("Incrementing x");
		x.i++;
		System.out.println("x: " + x.i);
		System.out.println("y: " + y.i);
		
		System.runFinalizersOnExit(true);
	}
}
