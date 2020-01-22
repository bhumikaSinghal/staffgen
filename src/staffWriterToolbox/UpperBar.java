/*
 * @package: staffWriterToolbox
 * @file: UpperBar.java
 *
 * @author: Himanshu Babbar
 *
 * Copyright (C) 2013. All rights reserved.
 */
package staffWriterToolbox;

/**
 * The Class UpperBar represents the upper bar of the staff.
 */
public class UpperBar extends Bar {
	/** The display. */
	private String display;

	/**
	 * Instantiates a new upper bar.
	 * 
	 * @param barNumber
	 *            the bar number
	 */
	public UpperBar(int barNumber) {
		super(barNumber);
	}

	/**
	 * Gets the display.
	 * 
	 * @return the display
	 */
	public String getDisplay() {
		return this.display;
	}

	/**
	 * Sets the display.
	 * 
	 * @param display
	 *            the new display
	 */
	public void setDisplay(String display) {
		this.display = display;
	}
}
