package c12;

import java.util.ArrayList;

public class ImmutableInteger {
	public static void main(String[] args) {
		ArrayList l = new ArrayList();
		for (int i = 0; i < 10; i++) {
			l.add(new Integer(i));
		}
	}
}
