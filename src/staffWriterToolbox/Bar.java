/*
 * @package: staffWriterToolbox
 * @file: Bar.java
 *
 * @author: Himanshu Babbar
 *
 * Copyright (C) 2013. All rights reserved.
 */
package staffWriterToolbox;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class Bar represents the Bar in the Staff.
 */
public abstract class Bar {
	/** The bar number. */
	private int barNumber = 0;
	/** The bar beats. */
	private List<BarBeat> barBeats;

	/**
	 * Instantiates a new bar.
	 * 
	 * @param barNumber
	 *            the bar number
	 */
	public Bar(int barNumber) {
		this.setBarNumber(barNumber);
		setBarBeats(new ArrayList<BarBeat>());
	}

	/**
	 * Gets the bar number.
	 * 
	 * @return the bar number
	 */
	public int getBarNumber() {
		return this.barNumber;
	}

	/**
	 * Sets the bar number.
	 * 
	 * @param barNumber
	 *            the new bar number
	 */
	public void setBarNumber(int barNumber) {
		this.barNumber = barNumber;
	}

	/**
	 * Gets the bar beats.
	 * 
	 * @return the bar beats
	 */
	public List<BarBeat> getBarBeats() {
		return barBeats;
	}

	/**
	 * Sets the bar beats.
	 * 
	 * @param barBeats
	 *            the new bar beats
	 */
	public void setBarBeats(List<BarBeat> barBeats) {
		this.barBeats = barBeats;
	}
}
