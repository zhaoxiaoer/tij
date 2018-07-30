package c13;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Event;

public class Button1 extends Applet {
	Button b1 = new Button("Button1");
	Button b2 = new Button("Button2");
	
	public void init() {
		add(b1);
		add(b2);
	}
	
	public boolean action(Event evt, Object arg) {
//		if (evt.target.equals(b1)) {
//			getAppletContext().showStatus("Button1");
//		} else if (evt.target.equals(b2)) {
//			getAppletContext().showStatus("Button2");
//		} else {
//			return super.action(evt, arg);
//		}
		if (arg.equals("Button1")) {
			getAppletContext().showStatus("Button1");
		} else if (arg.equals("Button2")) {
			getAppletContext().showStatus("Button2");
		} else {
			return super.action(evt, arg);
		}
		
		return true;
	}
}
