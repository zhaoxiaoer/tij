package tij.chapter11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

class Pet {
	private static int mCount;
	private UUID mUUID;
	Pet() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("Pet current uuid = " + mUUID.toString() + ", count = " + mCount);
	}
	protected void finalize() {
		mCount--;
		System.out.println("Pet finalized uuid = " + mUUID.toString() + ", count = " + mCount);
	}
	public String toString() {
		return "This is Pet #" + mUUID.toString();
	}
	static {
		System.out.println("Loading Pet");
	}
}

class Dog extends Pet {
	private static int mCount;
	private UUID mUUID;
	Dog() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("Dog current uuid = " + mUUID.toString() + ", count = " + mCount);
	}
	protected void finalize() {
		mCount--;
		System.out.println("Dog finalized uuid = " + mUUID.toString() + ", count = " + mCount);
	
		super.finalize();
	}
	public String toString() {
		return "This is Dog #" + mUUID.toString();
	}
	static {
		System.out.println("Loading Dog");
	}
}

class Pug extends Dog {
	private static int mCount;
	private UUID mUUID;
	Pug() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("Pug current uuid = " + mUUID.toString() + ", count = " + mCount);
	}
	protected void finalize() {
		mCount--;
		System.out.println("Pug finalized uuid = " + mUUID.toString() + ", count = " + mCount);
	
		super.finalize();
	}
	public String toString() {
		return "This is Pug #" + mUUID.toString();
	}
	static {
		System.out.println("Loading Pug");
	}
}

class Cat extends Pet {
	private static int mCount;
	private UUID mUUID;
	Cat() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("Cat current uuid = " + mUUID.toString() + ", count = " + mCount);
	}
	protected void finalize() {
		mCount--;
		System.out.println("Cat finalized uuid = " + mUUID.toString() + ", count = " + mCount);
	
		super.finalize();
	}
	public String toString() {
		return "This is Cat #" + mUUID.toString();
	}
	static {
		System.out.println("Loading Cat");
	}
}

class Rodent extends Pet {
	private static int mCount;
	private UUID mUUID;
	Rodent() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("Rodent current uuid = " + mUUID.toString() + ", count = " + mCount);
	}
	protected void finalize() {
		mCount--;
		System.out.println("Rodent finalized uuid = " + mUUID.toString() + ", count = " + mCount);
	
		super.finalize();
	}
	public String toString() {
		return "This is Rodent #" + mUUID.toString();
	}
	static {
		System.out.println("Loading Rodent");
	}
}

class Gerbil extends Rodent {
	private static int mCount;
	private UUID mUUID;
	Gerbil() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("Gerbil current uuid = " + mUUID.toString() + ", count = " + mCount);
	}
	protected void finalize() {
		mCount--;
		System.out.println("Gerbil finalized uuid = " + mUUID.toString() + ", count = " + mCount);
	
		super.finalize();
	}
	public String toString() {
		return "This is Gerbil #" + mUUID.toString();
	}
	static {
		System.out.println("Loading Gerbil");
	}
}

class Hamster extends Rodent {
	private static int mCount;
	private UUID mUUID;
	Hamster() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("Hamster current uuid = " + mUUID.toString() + ", count = " + mCount);
	}
	protected void finalize() {
		mCount--;
		System.out.println("Hamster finalized uuid = " + mUUID.toString() + ", count = " + mCount);
	
		super.finalize();
	}
	public String toString() {
		return "This is Hamster #" + mUUID.toString();
	}
	static {
		System.out.println("Loading Hamster");
	}
}

class Counter {
	private static int mCount;
	private UUID mUUID;
	Counter() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("Counter current uuid = " + mUUID.toString() + ", count = " + mCount);
	}
	protected void finalize() {
		mCount--;
		System.out.println("Counter finalized uuid = " + mUUID.toString() + ", count = " + mCount);
	}
	public String toString() {
		return "This is Counter #" + mUUID.toString();
	}
	static {
		System.out.println("Loading Counter");
	}
	
	int i;
}

public class PetCount {
	private static int mCount;
	private UUID mUUID;
	PetCount() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("PetCount current uuid = " + mUUID.toString() + ", count = " + mCount);
	}
	protected void finalize() {
		mCount--;
		System.out.println("PetCount finalized uuid = " + mUUID.toString() + ", count = " + mCount);
	}
	public String toString() {
		return "This is PetCount #" + mUUID.toString();
	}
	static {
		System.out.println("Loading PetCount");
	}
	
	static String[] typenames = {
			"Pet", "Dog", "Pug", "Cat",
			"Rodent", "Gerbil", "Hamster",
	};
	
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		try {
			Class[] petTypes = {
					Pet.class,
					Dog.class,
					Pug.class,
					Cat.class,
					Rodent.class,
					Gerbil.class,
					Hamster.class,
			};
			for (int i = 0; i < 15; i++) {
				int rand = (int) (Math.random() * petTypes.length);
				System.out.println("rand: " + rand);
				list.add(petTypes[rand].newInstance());
			}
			
			HashMap map = new HashMap();
			for (int i = 0; i < petTypes.length; i++) {
				map.put(petTypes[i].toString(), new Counter());
			}
			for (int i = 0; i < list.size(); i++) {
				Object o = list.get(i);
				for (int j = 0; j < petTypes.length; j++) {
					if (petTypes[j].isInstance(o)) {
						String key = petTypes[j].toString();
						((Counter) map.get(key)).i++;
					}
				}
//				if (o instanceof Pet) {
//					((Counter) map.get("Pet")).i++;
//				}
//				if (o instanceof Dog) {
//					((Counter) map.get("Dog")).i++;
//				}
//				if (o instanceof Pug) {
//					((Counter) map.get("Pug")).i++;
//				}
//				if (o instanceof Cat) {
//					((Counter) map.get("Cat")).i++;
//				}
//				if (o instanceof Rodent) {
//					((Counter) map.get("Rodent")).i++;
//				}
//				if (o instanceof Gerbil) {
//					((Counter) map.get("Gerbil")).i++;
//				}
//				if (o instanceof Hamster) {
//					((Counter) map.get("Hamster")).i++;
//				}
			}
			Set keys = map.keySet();
			Iterator it = keys.iterator();
			while (it.hasNext()) {
				String key = (String) it.next();
				System.out.println(key + " quantity: " + ((Counter) map.get(key)).i);
			}
			
			Class[] faces = petTypes[1].getInterfaces();
			System.out.println("faces.length: " + faces.length);
			Class a = petTypes[2].getSuperclass();
			System.out.println(petTypes[2].toString() + " superclass: " + a.toString());
			a.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		System.runFinalizersOnExit(true);
	}
}
