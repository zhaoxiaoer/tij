package tij.chapter10;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.UUID;

public class FreezeAlien {
	private static int mCount;
	private UUID mUUID;
	FreezeAlien() {
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
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("file.x"));
		Alien zorcon = new Alien();
		out.writeObject(zorcon);
		
		System.runFinalizersOnExit(true);
	}
}
