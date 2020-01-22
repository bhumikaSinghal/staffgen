/*
 * @package: staffWriterToolbox
 * @file: Staff.java
 *
 * @author: Himanshu Babbar
 *
 * Copyright (C) 2013. All rights reserved.
 */
package staffWriterToolbox;

import java.util.List;

/**
 * The Interface Staff is the basic Interface of the Musical Staff and provides
 * the skeleton for generating Treble, Bass and Great Staves.
 */
public interface Staff {
	/**
	 * Gets the upper bars.
	 * 
	 * @return the upper bars
	 */
	public List<UpperBar> getUpperBars();

	/**
	 * Sets the upper bars.
	 * 
	 * @param upperBars
	 *            the new upper bars
	 */
	public void setUpperBars(List<UpperBar> upperBars);

	/**
	 * Gets the middle bars.
	 * 
	 * @return the middle bars
	 */
	public List<MiddleBar> getMiddleBars();

	/**
	 * Sets the middle bars.
	 * 
	 * @param middleBars
	 *            the new middle bars
	 */
	public void setMiddleBars(List<MiddleBar> middleBars);

	/**
	 * Gets the lower bars.
	 * 
	 * @return the lower bars
	 */
	public List<LowerBar> getLowerBars();

	/**
	 * Sets the lower bars.
	 * 
	 * @param lowerBars
	 *            the new lower bars
	 */
	public void setLowerBars(List<LowerBar> lowerBars);

	/**
	 * Gets the upper bar display list.
	 * 
	 * @return the upper bar display list
	 */
	public List<String> getUpperBarDisplayList();

	/**
	 * Sets the upper bar display list.
	 * 
	 * @param upperBarDisplayList
	 *            the new upper bar display list
	 */
	public void setUpperBarDisplayList(List<String> upperBarDisplayList);

	/**
	 * Gets the middle bar display list.
	 * 
	 * @return the middle bar display list
	 */
	public List<String> getMiddleBarDisplayList();

	/**
	 * Sets the middle bar display list.
	 * 
	 * @param middleBarDisplayList
	 *            the new middle bar display list
	 */
	public void setMiddleBarDisplayList(List<String> middleBarDisplayList);

	/**
	 * Gets the lower bar display list.
	 * 
	 * @return the lower bar display list
	 */
	public List<String> getLowerBarDisplayList();

	/**
	 * Sets the lower bar display list.
	 * 
	 * @param lowerBarDisplayList
	 *            the new lower bar display list
	 */
	public void setLowerBarDisplayList(List<String> lowerBarDisplayList);

	/**
	 * Gets the display.
	 * 
	 * @return the display
	 */
	public String getDisplay();

	/**
	 * Sets the display.
	 * 
	 * @param display
	 *            the new display
	 */
	public void setDisplay(String display);

	/**
	 * Sets the display.
	 * 
	 * @param upperBars
	 *            the upper bars
	 * @param middleBars
	 *            the middle bars
	 * @param lowerBars
	 *            the lower bars
	 */
	public void setDisplay(List<UpperBar> upperBars,
			List<MiddleBar> middleBars, List<LowerBar> lowerBars);
}
