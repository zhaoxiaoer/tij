package c12;

import java.util.UUID;

class DepthReading implements Cloneable {
	static {
		System.out.println("Loading DepthReading");
	}
	private static int mCount;
	private UUID mUUID;
	public DepthReading() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("DepthReading current uuid = " + mUUID.toString());
	}
	protected void finalize() {
		mCount--;
		System.out.println("DepthReading finalized uuid = " + mUUID.toString());
	}
	public String toString() {
		return "This is DepthReading #" + mUUID.toString();
	}
	
	private double mDepth;
	public DepthReading(double depth) {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("DepthReading current uuid = " + mUUID.toString());
		
		mDepth = depth;
	}
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
}

class TemperatureReading implements Cloneable {
	static {
		System.out.println("Loading TemperatureReading");
	}
	private static int mCount;
	private UUID mUUID;
	public TemperatureReading() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("TemperatureReading current uuid = " + mUUID.toString());
	}
	protected void finalize() {
		mCount--;
		System.out.println("TemperatureReading finalized uuid = " + mUUID.toString());
	}
	public String toString() {
		return "This is TemperatureReading #" + mUUID.toString();
	}
	
	private long mTime;
	private double mTemperature;
	public TemperatureReading(double temperature) {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("TemperatureReading current uuid = " + mUUID.toString());
		
		mTime = System.currentTimeMillis();
		mTemperature = temperature;
	}
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
}

class OceanReading implements Cloneable {
	static {
		System.out.println("Loading OceanReading");
	}
	private static int mCount;
	private UUID mUUID;
	public OceanReading() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("OceanReading current uuid = " + mUUID.toString());
	}
	protected void finalize() {
		mCount--;
		System.out.println("OceanReading finalized uuid = " + mUUID.toString());
	}
	public String toString() {
		return "This is OceanReading #" + mUUID.toString();
	}
	
	private DepthReading mDepthReading;
	private TemperatureReading mTemperatureReading;
	public OceanReading(double tdata, double ddata) {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("OceanReading current uuid = " + mUUID.toString());
		
		mDepthReading = new DepthReading(tdata);
		mTemperatureReading = new TemperatureReading(ddata);
	}
	public Object clone() {
		OceanReading o = null;
		try {
			o = (OceanReading) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		o.mDepthReading = (DepthReading) o.mDepthReading.clone();
		o.mTemperatureReading = (TemperatureReading) o.mTemperatureReading.clone();
		return o;
	}
}

public class DeepCopy {
	static {
		System.out.println("Loading DeepCopy");
	}
	private static int mCount;
	private UUID mUUID;
	public DeepCopy() {
		mCount++;
		mUUID = UUID.randomUUID();
		System.out.println("DeepCopy current uuid = " + mUUID.toString());
	}
	protected void finalize() {
		mCount--;
		System.out.println("DeepCopy finalized uuid = " + mUUID.toString());
	}
	public String toString() {
		return "This is DeepCopy #" + mUUID.toString();
	}
	
	public static void main(String[] args) {
		OceanReading reading = new OceanReading(33.9, 100.5);
		OceanReading r = (OceanReading) reading.clone();
		
		System.runFinalizersOnExit(true);
	}
}
