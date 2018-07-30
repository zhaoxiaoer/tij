package c13;

import java.awt.Color;

class Spots {
	
}

public class Frog {
	private int jumps;
	private Color color;
	private Spots spots;
	private boolean jumper;
	public int getJumps() {
		return jumps;
	}
	public void setJumps(int newJumps) {
		jumps = newJumps;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color newColor) {
		color = newColor;
	}
	public Spots getSpots() {
		return spots;
	}
	public void setSpots(Spots newSpots) {
		spots = newSpots;
	}
	public boolean isJumper() {
		return jumper;
	}
	public void setJumper(boolean j) {
		jumper = j;
	}
}
