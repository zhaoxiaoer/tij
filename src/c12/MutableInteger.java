package c12;

import java.util.ArrayList;

class IntValue {
	int n;
	IntValue(int x) {
		n = x;
	}
	public String toString() {
		return Integer.toString(n);
	}
}

public class MutableInteger {
	public static void main(String[] args) {
		ArrayList l = new ArrayList();
		for (int i = 0; i < 10; i++) {
			l.add(new IntValue(i));
		}
		System.out.println(l);
		for (int i = 0; i < l.size(); i++) {
			((IntValue) l.get(i)).n++;
		}
		System.out.println(l);
	}
}
