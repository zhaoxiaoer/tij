package tij.chapter10;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.UUID;

class Data implements Serializable {
	private static int mCount;
	private UUID mUUID;
	Data() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println(getClass().getName() + " current uuid = " + mUUID.toString() + ", count = " + mCount);
	}
	protected void finalize() {
		mCount--;
		System.out.println(getClass().getName() + " finalized uuid = " + mUUID.toString() + ", count = " + mCount);
	}
//	public String toString() {
//		return "This is " + getClass().getName() + " #" + mUUID.toString();
//	}
	
	private int i;
	Data(int x) {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println(getClass().getName() + " current uuid = " + mUUID.toString() + ", count = " + mCount);
	
		i = x;
	}
	public String toString() {
		return "This is " + getClass().getName() + " #" + mUUID.toString()
			+ ", i: " + Integer.toString(i);
	}
}

public class Worm implements Serializable {
	private static int mCount;
	private UUID mUUID;
//	Worm() {
//		mCount++;
//		mUUID = UUID.randomUUID();
//		System.out.println(getClass().getName() + " current uuid = " + mUUID.toString() + ", count = " + mCount);
//	}
	protected void finalize() {
		mCount--;
		System.out.println(getClass().getName() + " finalized uuid = " + mUUID.toString() + ", count = " + mCount);
	}
//	public String toString() {
//		return "This is " + getClass().getName() + " #" + mUUID.toString();
//	}
	
	// Generate a random int value
	private static int r() {
		return (int) (Math.random() * 10);
	}
	private Data[] d = {
			new Data(r()), new Data(r()), new Data(r())
	};
	private Worm next;
	private char c;
	// Value of i == number of segments
	Worm(int i, char x) {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println(getClass().getName() + " current uuid = " + mUUID.toString() + ", count = " + mCount);
		
		System.out.println("Worm constructor: " + i);
		c = x;
		if (--i > 0) {
			next = new Worm(i, (char) (x + 1));
		}
	}
	Worm() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println(getClass().getName() + " current uuid = " + mUUID.toString() + ", count = " + mCount);
		System.out.println("Default constructor");
	}
	public String toString() {
		String s = ":" + c + "(";
		for (int i = 0; i < d.length; i++)
			s += d[i].toString();
		s += ")";
		if (next != null)
			s += next.toString();
		
		return "This is " + getClass().getName() + " #" + mUUID.toString()
			+ ", " + s;
	}
	
	public static void main(String[] args) {
		Worm w = new Worm(6, 'a');
		System.out.println("w = " + w);
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("worm.out"));
			out.writeObject("Worm storage");
			out.writeObject(w);
			out.close(); // Also flushes output
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("worm.out"));
			String s = (String) in.readObject();
			Worm w2 = (Worm) in.readObject();
			System.out.println(s + ", w2 = " + w2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bout);
			out.writeObject("Worm storage");
			out.writeObject(w);
			out.flush();
			ObjectInputStream in = new ObjectInputStream(
					new ByteArrayInputStream(
							bout.toByteArray()));
			String s = (String) in.readObject();
			Worm w3 = (Worm) in.readObject();
			System.out.println(s + ", w3 = " + w3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.runFinalizersOnExit(true);
	}
}
