/*
 * @package: dataRecordingToolbox
 * @file: Peak.java
 * 
 * @author: Himanshu Babbar
 * 
 * Copyright (C) 2013. All rights reserved.
 */
package dataRecordingToolbox;

/**
 * The Class Peak contains information of the highest voltage value in the data.
 */
public class Peak {

	/** The value of the peak. */
	private float val;

	/** The location of the peak. */
	private int loc;

	/**
	 * Instantiates a new peak.
	 */
	Peak() {
		this.val = 0;
		this.loc = 0;
	}

	/**
	 * Sets the value of the peak.
	 * 
	 * @param val
	 *            the new value of the peak
	 */
	public void setVal(float val) {
		this.val = val;
	}

	/**
	 * Gets the value of the peak.
	 * 
	 * @return the value of the peak
	 */
	public float getVal() {
		return val;
	}

	/**
	 * Sets the location of the peak.
	 * 
	 * @param loc
	 *            the new location of the peak
	 */
	public void setLoc(int loc) {
		this.loc = loc;
	}

	/**
	 * Gets the location of the peak.
	 * 
	 * @return the location of the peak
	 */
	public int getLoc() {
		return loc;
	}

}
