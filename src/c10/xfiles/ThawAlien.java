package c10.xfiles;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.UUID;

public class ThawAlien {
	private static int mCount;
	private UUID mUUID;
	ThawAlien() {
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
	
	public static void main(String[] args) throws Exception {
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("file.x"));
		Object mystery = in.readObject();
		System.out.println(mystery.getClass().toString());
	}
}
