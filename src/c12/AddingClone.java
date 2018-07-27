package c12;

import java.util.ArrayList;
import java.util.Iterator;

class Int2 implements Cloneable {
	private int i;
	public Int2(int ii) {
		i = ii;
	}
	public void increment() {
		i++;
	}
	public String toString() {
		return Integer.toString(i);
	}
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Int2 can't clone");
		}
		return o;
	}
}

class Int3 extends Int2 {
	private int j;
	public Int3(int i) {
		super(i);
	}
}

public class AddingClone {
	public static void main(String[] args) {
		Int2 x = new Int2(10);
		Int2 x2 = (Int2) x.clone();
		x2.increment();
		System.out.println("x = " + x + ", x2 = " + x2);
		// Anything inherited is also cloneable:
		Int3 x3 = new Int3(7);
		x3 = (Int3) x3.clone();
		
		ArrayList list = new ArrayList();
		for (int i = 0; i < 10; i++) {
			list.add(new Int2(i));
		}
		System.out.println("list: " + list);
		ArrayList list2 = (ArrayList) list.clone();
		for (int i = 0; i < list2.size(); i++) {
			list2.set(i, ((Int2) list2.get(i)).clone());
		}
		for (Iterator it = list2.iterator(); it.hasNext(); ) {
			((Int2) it.next()).increment();
		}
		System.out.println("list: " + list);
		System.out.println("list2: " + list2);
	}
}
