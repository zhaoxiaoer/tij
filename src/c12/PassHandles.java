package c12;

import java.util.UUID;

public class PassHandles {
	static {
		System.out.println("Loading PassHandles");
	}
	private static int mCount;
	private UUID mUUID;
	public PassHandles() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("PassHandles current uuid = " + mUUID.toString());
	}
	protected void finalize() {
		mCount--;
		System.out.println("PassHandles finalized uuid = " + mUUID.toString());
	}
	public String toString() {
		return "This is PassHandles #" + mUUID.toString();
	}
	
	static void f(PassHandles h) {
		System.out.println("h inside f(): " + h);
	}
	
	public static void main(String[] args) {
		PassHandles p = new PassHandles();
		System.out.println("p inside main(): " + p);
		f(p); 
		
		System.runFinalizersOnExit(true);
	}
}
