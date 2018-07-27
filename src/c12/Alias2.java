package c12;

import java.util.UUID;

public class Alias2 {
	static {
		System.out.println("Loading Alias2");
	}
	private static int mCount;
	private UUID mUUID;
	public Alias2() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("Alias2 current uuid = " + mUUID.toString());
	}
	int i;
	public Alias2(int ii) {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("Alias2 current uuid = " + mUUID.toString());
		
		i = ii;
	}
	protected void finalize() {
		mCount--;
		System.out.println("Alias2 finalized uuid = " + mUUID.toString());
	}
	public String toString() {
		return "This is Alias2 #" + mUUID.toString() + ", i = " + i;
	}
	
	static void f(Alias2 handle) {
		handle.i++;
	}
	
	public static void main(String[] args) {
		Alias2 x = new Alias2(7);
		System.out.println("x: " + x.i);
		System.out.println("Calling f(x)");
		f(x);
		System.out.println("x: " + x.i);
		
		System.runFinalizersOnExit(true);
	}
}
