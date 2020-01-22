/*
 * @package: staffWriterToolbox
 * @file: LowerBar.java
 *
 * @author: Himanshu Babbar
 *
 * Copyright (C) 2013. All rights reserved.
 */
package staffWriterToolbox;

/**
 * The Class LowerBar represents the lower bar of the staff.
 */
public class LowerBar extends Bar {
	/** The display. */
	private String display;

	/**
	 * Instantiates a new lower bar.
	 * 
	 * @param barNumber
	 *            the bar number
	 */
	public LowerBar(int barNumber) {
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
