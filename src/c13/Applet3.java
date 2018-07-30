package c13;

import java.applet.Applet;
import java.awt.Graphics;

public class Applet3 extends Applet {
	String s;
	int inits = 0;
	int starts = 0;
	int stops = 0;
	int paints = 0;
	int destroys = 0;
	public void init() {
		inits++;
	}
	public void start() {
		starts++;
	}
	public void paint(Graphics g) {
		s = "inits: " + inits + ", starts: " + starts + ", paints: " + paints + ", stops: " + stops;
		g.drawString(s, 10, 10);
	}
	public void stop() {
		stops++;
	}
	public void destroy() {
		destroys++;
	}
}
