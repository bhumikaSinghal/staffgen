/*
 * @package: staffWriterToolbox
 * @file: GreatStaff.java
 *
 * @author: Himanshu Babbar
 *
 * Copyright (C) 2013. All rights reserved.
 */
package staffWriterToolbox;

import java.util.ArrayList;
import java.util.List;

import staffGenUtils.StaffGenUtilities;

/**
 * The Class GreatStaff represents the Great Staff.
 */
public class GreatStaff implements Staff {
	/** The upper bars of the Great Staff. */
	private List<UpperBar> upperBars;
	/** The middle bars of the Great Staff. */
	private List<MiddleBar> middleBars;
	/** The lower bars of the Great Staff. */
	private List<LowerBar> lowerBars;
	/** The upper bar display list of the Great Staff. */
	private List<String> upperBarDisplayList;
	/** The middle bar display list of the Great Staff. */
	private List<String> middleBarDisplayList;
	/** The lower bar display list of the Great Staff. */
	private List<String> lowerBarDisplayList;
	/** The display of the Great Staff. */
	private String display;

	/**
	 * Instantiates a new great staff.
	 */
	public GreatStaff() {
		this.upperBars = new ArrayList<UpperBar>();
		this.middleBars = new ArrayList<MiddleBar>();
		this.lowerBars = new ArrayList<LowerBar>();
		for (int i = 0; i < 16; i++) {
			UpperBar upperBar = new UpperBar(i + 1);
			upperBar.setDisplay(" ");
			this.upperBars.add(upperBar);
			MiddleBar middleBar = new MiddleBar(i + 1);
			middleBar.setDisplay("================!");
			this.middleBars.add(middleBar);
			LowerBar lowerBar = new LowerBar(i + 1);
			lowerBar.setDisplay("================!");
			this.lowerBars.add(lowerBar);
		}
		this.setUpperBarDisplay(upperBars);
		this.setMiddleBarDisplay(middleBars);
		this.setLowerBarDisplay(lowerBars);
		this.setDisplay(getCompleteDisplay());
	}

	/**
	 * Sets the upper bar display.
	 * 
	 * @param upperBars
	 *            the new upper bar display
	 */
	private void setUpperBarDisplay(List<UpperBar> upperBars) {
		this.upperBarDisplayList = new ArrayList<String>();
		StringBuffer upperBarDisplay = new StringBuffer(" ");
		int count = 0;
		for (UpperBar upperBar : upperBars) {
			upperBarDisplay.append(upperBar.getDisplay());
			count++;
			if (count == 4) {
				upperBarDisplayList.add(upperBarDisplay.toString());
				upperBarDisplay = null;
				upperBarDisplay = new StringBuffer(" ");
				count = 0;
			}
		}
	}

	/**
	 * Sets the middle bar display.
	 * 
	 * @param middleBars
	 *            the new middle bar display
	 */
	private void setMiddleBarDisplay(List<MiddleBar> middleBars) {
		this.middleBarDisplayList = new ArrayList<String>();
		StringBuffer middleBarDisplay = new StringBuffer(
				StaffGenUtilities.Clefs.TREBLE_CLEF
						+ StaffGenUtilities.TimeSignature.FOUR_BY_FOUR);
		int count = 0;
		for (MiddleBar mainbar : middleBars) {
			middleBarDisplay.append(mainbar.getDisplay());
			count++;
			if (count == 4) {
				middleBarDisplayList.add(middleBarDisplay.toString());
				middleBarDisplay = null;
				middleBarDisplay = new StringBuffer(
						StaffGenUtilities.Clefs.TREBLE_CLEF
								+ StaffGenUtilities.TimeSignature.FOUR_BY_FOUR);
				count = 0;
			}
		}
	}

	/**
	 * Sets the lower bar display.
	 * 
	 * @param lowerBars
	 *            the new lower bar display
	 */
	private void setLowerBarDisplay(List<LowerBar> lowerBars) {
		this.lowerBarDisplayList = new ArrayList<String>();
		StringBuffer lowerBarDisplay = new StringBuffer(
				StaffGenUtilities.Clefs.BASS_CLEF
						+ StaffGenUtilities.TimeSignature.FOUR_BY_FOUR);
		int count = 0;
		for (LowerBar auxiliaryLowerBar : lowerBars) {
			lowerBarDisplay.append(auxiliaryLowerBar.getDisplay());
			count++;
			if (count == 4) {
				lowerBarDisplayList.add(lowerBarDisplay.toString());
				lowerBarDisplay = null;
				lowerBarDisplay = new StringBuffer(
						StaffGenUtilities.Clefs.BASS_CLEF
								+ StaffGenUtilities.TimeSignature.FOUR_BY_FOUR);
				count = 0;
			}
		}
	}

	/**
	 * Gets the complete display.
	 * 
	 * @return the complete display
	 */
	private String getCompleteDisplay() {
		StringBuffer completeDisplay = new StringBuffer("");
		for (int i = 0; i < upperBarDisplayList.size(); i++) {
			completeDisplay.append("\n");
			completeDisplay.append(upperBarDisplayList.get(i));
			completeDisplay.append("\n");
			completeDisplay.append(middleBarDisplayList.get(i));
			completeDisplay.append("\n");
			completeDisplay.append(lowerBarDisplayList.get(i));
			completeDisplay.append("\n");
		}
		return completeDisplay.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see staffWriterToolbox.Staff#getUpperBars()
	 */
	@Override
	public List<UpperBar> getUpperBars() {
		return this.upperBars;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see staffWriterToolbox.Staff#setUpperBars(java.util.List)
	 */
	@Override
	public void setUpperBars(List<UpperBar> upperBars) {
		this.upperBars = upperBars;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see staffWriterToolbox.Staff#getMiddleBars()
	 */
	@Override
	public List<MiddleBar> getMiddleBars() {
		return this.middleBars;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see staffWriterToolbox.Staff#setMiddleBars(java.util.List)
	 */
	@Override
	public void setMiddleBars(List<MiddleBar> middleBars) {
		this.middleBars = middleBars;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see staffWriterToolbox.Staff#getLowerBars()
	 */
	@Override
	public List<LowerBar> getLowerBars() {
		return lowerBars;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see staffWriterToolbox.Staff#setLowerBars(java.util.List)
	 */
	@Override
	public void setLowerBars(List<LowerBar> lowerBars) {
		this.lowerBars = lowerBars;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see staffWriterToolbox.Staff#getUpperBarDisplayList()
	 */
	@Override
	public List<String> getUpperBarDisplayList() {
		return upperBarDisplayList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see staffWriterToolbox.Staff#setUpperBarDisplayList(java.util.List)
	 */
	@Override
	public void setUpperBarDisplayList(List<String> upperBarDisplayList) {
		this.upperBarDisplayList = upperBarDisplayList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see staffWriterToolbox.Staff#getMiddleBarDisplayList()
	 */
	@Override
	public List<String> getMiddleBarDisplayList() {
		return middleBarDisplayList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see staffWriterToolbox.Staff#setMiddleBarDisplayList(java.util.List)
	 */
	@Override
	public void setMiddleBarDisplayList(List<String> middleBarDisplayList) {
		this.middleBarDisplayList = middleBarDisplayList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see staffWriterToolbox.Staff#getLowerBarDisplayList()
	 */
	@Override
	public List<String> getLowerBarDisplayList() {
		return lowerBarDisplayList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see staffWriterToolbox.Staff#setLowerBarDisplayList(java.util.List)
	 */
	@Override
	public void setLowerBarDisplayList(List<String> lowerBarDisplayList) {
		this.lowerBarDisplayList = lowerBarDisplayList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see staffWriterToolbox.Staff#getDisplay()
	 */
	@Override
	public String getDisplay() {
		return display;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see staffWriterToolbox.Staff#setDisplay(java.lang.String)
	 */
	@Override
	public void setDisplay(String display) {
		this.display = display;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see staffWriterToolbox.Staff#setDisplay(java.util.List, java.util.List,
	 * java.util.List)
	 */
	@Override
	public void setDisplay(List<UpperBar> upperBars,
			List<MiddleBar> middleBars, List<LowerBar> lowerBars) {
		this.upperBarDisplayList = null;
		this.middleBarDisplayList = null;
		this.lowerBarDisplayList = null;
		setUpperBarDisplay(upperBars);
		setMiddleBarDisplay(middleBars);
		setLowerBarDisplay(lowerBars);
		String completeDisplay = getCompleteDisplay();
		this.setDisplay(completeDisplay);
	}
}
