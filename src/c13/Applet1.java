package c13;

import java.applet.Applet;
import java.awt.Graphics;

public class Applet1 extends Applet {
	public void paint(Graphics g) {
		g.drawString("First applet", 10, 10);
		g.draw3DRect(0, 0, 100, 20, true);
	}
}
