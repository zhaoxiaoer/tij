package tij.chapter11;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.UUID;

public class ShowMethods {
	static {
		System.out.println("Loading ShowMethods");
	}
	private static int mCount;
	private UUID mUUID;
	public ShowMethods() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("ShowMethods current uuid = " + mUUID.toString() + ", count = " + mCount);
	}
	protected void finalize() {
		mCount--;
		System.out.println("ShowMethods finalized uuid = " + mUUID.toString() + ", count = " + mCount);
	}
	public String toString() {
		return "This is ShowMethods #" + mUUID.toString();
	}
	
	static final String usage = "usage: \n" +
			"ShowMethods qualified.class.name\n" +
			"To show all methods in class or: \n" +
			"ShowMethods qualified.class.name word\n" +
			"To search for methods involving 'word'";
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println(usage);
			System.exit(0);
		}
		try {
			Class c = Class.forName(args[0]);
			Method[] m = c.getMethods();
			Constructor[] ctor = c.getConstructors();
			if (args.length == 1) {
				for (int i = 0;i < m.length; i++) {
					System.out.println(m[i].toString());
				}
				System.out.println("1111: " + ctor.length);
				for (int i = 0; i < ctor.length; i++) {
					System.out.println(ctor[i].toString());
				}
			} else {
				for (int i = 0; i < m.length; i++) {
					if (m[i].toString().indexOf(args[1]) != -1) {
						System.out.println(m[i].toString());
					}
				}
				for (int i = 0; i < ctor.length; i++) {
					if (ctor[i].toString().indexOf(args[1]) != -1) {
						System.out.println(ctor[i].toString());
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.runFinalizersOnExit(true);
	}
}
