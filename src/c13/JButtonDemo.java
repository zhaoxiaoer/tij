package c13;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class JButtonDemo extends Applet {
	JButton b1 = new JButton("JButton1");
	JButton b2 = new JButton("JButton2");
	JTextField t = new JTextField(20);
	public void init() {
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = ((JButton) e.getSource()).getText();
				t.setText(name + " Pressed");
			}
		};
		b1.addActionListener(al);
		add(b1);
		b2.addActionListener(al);
		add(b2);
		add(t);
	}
	
	public static void main(String args[]) {
		JFrame frame = new JFrame("TextAreaNew");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setSize(300, 100);
		JButtonDemo applet = new JButtonDemo();
		frame.getContentPane().add(applet, BorderLayout.CENTER);
		applet.init();
		applet.start();
		frame.setVisible(true);
		
		System.out.println("111");
	}
}
