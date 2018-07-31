package c15;

import java.net.InetAddress;

public class WhoAmI {
	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			System.err.println("Usage: WhoAmI MachineName");
			System.exit(1);
		}
//		InetAddress a = InetAddress.getByName(args[0]);
//		InetAddress a = InetAddress.getByName(null);
		InetAddress a = InetAddress.getLocalHost();
		System.out.println(a);
	}
}
