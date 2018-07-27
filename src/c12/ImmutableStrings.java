package c12;

public class ImmutableStrings {
	public static void main(String[] args) {
		String foo = "foo";
		String s = "abc" + foo + "def" + Integer.toString(47);
		System.out.println(s);
		StringBuffer sb = new StringBuffer("abc");
		sb.append(foo);
		sb.append("def");
		sb.append(Integer.toString(47));
		System.out.println(sb);
	}
}
