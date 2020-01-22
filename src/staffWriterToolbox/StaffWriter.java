/*
 * @package: staffWriterToolbox
 * @file: StaffWriter.java
 *
 * @author: Himanshu Babbar
 *
 * Copyright (C) 2013. All rights reserved.
 */
package staffWriterToolbox;

import java.util.List;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import staffGenUtils.StaffGenUtilities;
import dataRecordingToolbox.DataRecordingToolbox;

/**
 * The Class StaffWriter provides the functionality of writing the Staff.
 */
public class StaffWriter implements Runnable {
	/** The thread. */
	private Thread thread;
	/** The scroll bar. */
	private JScrollBar scrollBar;
	/** The text pane. */
	private JTextPane textPane;
	/** The staff. */
	private Staff staff;
	/** The upper bars. */
	private List<UpperBar> upperBars;
	/** The middle bars. */
	private List<MiddleBar> middleBars;
	/** The lower bars. */
	private List<LowerBar> lowerBars;
	/** The semibreveExist indicates whether semibreve exists in a Bar or not. */
	private boolean semibreveExist;
	/** The suspend. */
	private boolean suspend = false;

	/**
	 * Instantiates a new staff writer.
	 * 
	 * @param scrollPane
	 *            the scroll pane
	 * @param textPane
	 *            the text pane
	 * @param staff
	 *            the staff
	 */
	public StaffWriter(JScrollPane scrollPane, JTextPane textPane, Staff staff) {
		this.textPane = textPane;
		this.staff = staff;
		this.scrollBar = scrollPane.getVerticalScrollBar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while (DataRecordingToolbox.getDataRecorder().isRunning()) {
			if (isSuspend()) {
				synchronized (this) {
					while (isSuspend()) {
						try {
							this.wait();
						} catch (InterruptedException e) {
							int val = StaffGenUtilities.Messages
									.showErrorMsg("Staff Writer Interrupted");
							if (val == 0) {
								System.exit(1);
							}
						}
					}
				}
			} else {
				NoteHandler noteHandler = StaffWriterToolbox.getNoteHandler();
				Note note = noteHandler.getNote();
				if (note != null) {
					if (note.getMidiNumber() > 39 & note.getMidiNumber() < 85) {
						int barNumber;
						if (note.getBeat() > 4) {
							float n = (float) ((note.getBeat()) / 4.0);
							int n1 = (note.getBeat()) / 4;
							if (n > n1) {
								barNumber = n1 + 1;
							} else {
								barNumber = n1;
							}
						} else {
							barNumber = 1;
						}
						this.upperBars = this.staff.getUpperBars();
						this.middleBars = this.staff.getMiddleBars();
						this.lowerBars = this.staff.getLowerBars();
						UpperBar currUpperBar = findUpperBar(barNumber);
						MiddleBar currMiddleBar = findMiddleBar(barNumber);
						LowerBar currLowerBar = findLowerBar(barNumber);
						if (currUpperBar == null | currMiddleBar == null
								| currLowerBar == null) {
							currUpperBar = new UpperBar(barNumber);
							currUpperBar.setDisplay(" ");
							this.upperBars.add(currUpperBar);
							for (int i = 1; i < 4; i++) {
								UpperBar upperBar = new UpperBar(barNumber + i);
								upperBar.setDisplay(" ");
								this.upperBars.add(upperBar);
							}
							currMiddleBar = new MiddleBar(barNumber);
							if (staff instanceof TrebleStaff
									| staff instanceof GreatStaff) {
								currMiddleBar.setDisplay("================!");
							} else {
								currMiddleBar.setDisplay(" ");
							}
							this.middleBars.add(currMiddleBar);
							for (int i = 1; i < 4; i++) {
								MiddleBar middleBar = new MiddleBar(barNumber
										+ i);
								if (staff instanceof TrebleStaff
										| staff instanceof GreatStaff) {
									middleBar.setDisplay("================!");
								} else {
									middleBar.setDisplay(" ");
								}
								this.middleBars.add(middleBar);
							}
							currLowerBar = new LowerBar(barNumber);
							if (staff instanceof BassStaff
									| staff instanceof GreatStaff) {
								currLowerBar.setDisplay("================!");
							} else {
								currLowerBar.setDisplay(" ");
							}
							this.lowerBars.add(currLowerBar);
							for (int i = 1; i < 4; i++) {
								LowerBar lowerBar = new LowerBar(barNumber + i);
								if (staff instanceof BassStaff
										| staff instanceof GreatStaff) {
									lowerBar.setDisplay("================!");
								} else {
									lowerBar.setDisplay(" ");
								}
								this.lowerBars.add(lowerBar);
							}
						}
						if (this.staff instanceof TrebleStaff & barNumber > 16) {
							scrollBar.setValue(scrollBar.getMaximum());
						} else if ((this.staff instanceof BassStaff || this.staff instanceof GreatStaff)
								& barNumber > 12) {
							scrollBar.setValue(scrollBar.getMaximum());
						}
						int barBeatValue = (note.getBeat()) % 4;
						if (barBeatValue == 0) {
							barBeatValue = 4;
						}
						BarBeat currBarBeat = new BarBeat(barBeatValue);
						List<BarBeat> barBeats = currMiddleBar.getBarBeats();
						char[] currUpperBarDisplay = currUpperBar.getDisplay()
								.toCharArray();
						char[] currMiddleBarDisplay = currMiddleBar
								.getDisplay().toCharArray();
						char[] currLowerBarDisplay = currLowerBar.getDisplay()
								.toCharArray();
						if (barBeats.size() == 0) {
							int currBarBeatVal = currBarBeat.getValue();
							int symbolPos = (4 * currBarBeatVal - 2);
							char[] symbol = null;
							if (currBarBeatVal == 2) {
								note.setSymbol("1.5*Minim");
								this.semibreveExist = false;
								symbol = SymbolFinder.findSymbol(note);
							} else if (currBarBeatVal == 3) {
								note.setSymbol("Minim");
								this.semibreveExist = false;
								symbol = SymbolFinder.findSymbol(note);
							} else if (currBarBeatVal == 4) {
								note.setSymbol("Crotchet");
								this.semibreveExist = false;
								symbol = SymbolFinder.findSymbol(note);
							} else {
								note.setSymbol("Semibreve");
								this.semibreveExist = true;
								symbol = SymbolFinder.findSymbol(note);
							}
							plotSymbol(symbol, symbolPos, note,
									currUpperBarDisplay, currMiddleBarDisplay,
									currLowerBarDisplay);
							currBarBeat.setNote(note);
							barBeats.add(currBarBeat);
							StringBuffer upperBarBuffer = new StringBuffer();
							for (char c : currUpperBarDisplay) {
								upperBarBuffer.append(c);
							}
							currUpperBar.setDisplay(upperBarBuffer.toString());
							StringBuffer mainBarBuffer = new StringBuffer();
							for (char c : currMiddleBarDisplay) {
								mainBarBuffer.append(c);
							}
							currMiddleBar.setDisplay(mainBarBuffer.toString());
							StringBuffer lowerBarBuffer = new StringBuffer();
							for (char c : currLowerBarDisplay) {
								lowerBarBuffer.append(c);
							}
							currLowerBar.setDisplay(lowerBarBuffer.toString());
						} else {
							BarBeat prevBarBeat = barBeats
									.get((barBeats.size() - 1));
							int prevBarBeatVal = prevBarBeat.getValue();
							int prevSymbolPos = (4 * prevBarBeatVal - 2);
							int currBarBeatVal = currBarBeat.getValue();
							int currSymbolPos = (4 * currBarBeatVal - 2);
							if ((currBarBeatVal - prevBarBeatVal) == 1) {
								char[] prevNoteSymbol = null;
								char[] currNoteSymbol = null;
								Note prevNote = prevBarBeat.getNote();
								prevNote.setSymbol("Crotchet");
								this.semibreveExist = false;
								prevNoteSymbol = SymbolFinder
										.findSymbol(prevNote);
								if (currBarBeatVal == 2) {
									note.setSymbol("1.5*Minim");
									this.semibreveExist = false;
									currNoteSymbol = SymbolFinder
											.findSymbol(note);
								} else if (currBarBeatVal == 3) {
									note.setSymbol("Minim");
									this.semibreveExist = false;
									currNoteSymbol = SymbolFinder
											.findSymbol(note);
								} else if (currBarBeatVal == 4) {
									note.setSymbol("Crotchet");
									this.semibreveExist = false;
									currNoteSymbol = SymbolFinder
											.findSymbol(note);
								}
								int positionOfDot = plotSymbol(prevNoteSymbol,
										prevSymbolPos, prevNote,
										currUpperBarDisplay,
										currMiddleBarDisplay,
										currLowerBarDisplay);
								removeDot(prevSymbolPos, positionOfDot,
										prevNote, currUpperBarDisplay,
										currMiddleBarDisplay,
										currLowerBarDisplay);
								plotSymbol(currNoteSymbol, currSymbolPos, note,
										currUpperBarDisplay,
										currMiddleBarDisplay,
										currLowerBarDisplay);
								prevBarBeat.setNote(prevNote);
								currBarBeat.setNote(note);
								barBeats.add(currBarBeat);
								StringBuffer upperBarBuffer = new StringBuffer();
								for (char c : currUpperBarDisplay) {
									upperBarBuffer.append(c);
								}
								currUpperBar.setDisplay(upperBarBuffer
										.toString());
								StringBuffer mainBarBuffer = new StringBuffer();
								for (char c : currMiddleBarDisplay) {
									mainBarBuffer.append(c);
								}
								currMiddleBar.setDisplay(mainBarBuffer
										.toString());
								StringBuffer lowerBarBuffer = new StringBuffer();
								for (char c : currLowerBarDisplay) {
									lowerBarBuffer.append(c);
								}
								currLowerBar.setDisplay(lowerBarBuffer
										.toString());
							} else if ((currBarBeatVal - prevBarBeatVal) == 2) {
								char[] prevNoteSymbol = null;
								char[] currNoteSymbol = null;
								Note prevNote = prevBarBeat.getNote();
								prevNote.setSymbol("Minim");
								this.semibreveExist = false;
								prevNoteSymbol = SymbolFinder
										.findSymbol(prevNote);
								note.setSymbol("Minim");
								this.semibreveExist = false;
								currNoteSymbol = SymbolFinder.findSymbol(note);
								int positionOfDot = plotSymbol(prevNoteSymbol,
										prevSymbolPos, prevNote,
										currUpperBarDisplay,
										currMiddleBarDisplay,
										currLowerBarDisplay);
								removeDot(prevSymbolPos, positionOfDot,
										prevNote, currUpperBarDisplay,
										currMiddleBarDisplay,
										currLowerBarDisplay);
								plotSymbol(currNoteSymbol, currSymbolPos, note,
										currUpperBarDisplay,
										currMiddleBarDisplay,
										currLowerBarDisplay);
								prevBarBeat.setNote(prevNote);
								currBarBeat.setNote(note);
								barBeats.add(currBarBeat);
								StringBuffer upperBarBuffer = new StringBuffer();
								for (char c : currUpperBarDisplay) {
									upperBarBuffer.append(c);
								}
								currUpperBar.setDisplay(upperBarBuffer
										.toString());
								StringBuffer mainBarBuffer = new StringBuffer();
								for (char c : currMiddleBarDisplay) {
									mainBarBuffer.append(c);
								}
								currMiddleBar.setDisplay(mainBarBuffer
										.toString());
								StringBuffer lowerBarBuffer = new StringBuffer();
								for (char c : currLowerBarDisplay) {
									lowerBarBuffer.append(c);
								}
								currLowerBar.setDisplay(lowerBarBuffer
										.toString());
							} else if ((currBarBeatVal - prevBarBeatVal) == 3) {
								Note prevNote = prevBarBeat.getNote();
								prevNote.setSymbol("1.5*Minim");
								this.semibreveExist = false;
								char[] prevNoteSymbol = SymbolFinder
										.findSymbol(prevNote);
								note.setSymbol("Crotchet");
								this.semibreveExist = false;
								char[] currNoteSymbol = SymbolFinder
										.findSymbol(note);
								plotSymbol(prevNoteSymbol, prevSymbolPos,
										prevNote, currUpperBarDisplay,
										currMiddleBarDisplay,
										currLowerBarDisplay);
								plotSymbol(currNoteSymbol, currSymbolPos, note,
										currUpperBarDisplay,
										currMiddleBarDisplay,
										currLowerBarDisplay);
								prevBarBeat.setNote(prevNote);
								currBarBeat.setNote(note);
								barBeats.add(currBarBeat);
								StringBuffer upperBarBuffer = new StringBuffer();
								for (char c : currUpperBarDisplay) {
									upperBarBuffer.append(c);
								}
								currUpperBar.setDisplay(upperBarBuffer
										.toString());
								StringBuffer middleBarBuffer = new StringBuffer();
								for (char c : currMiddleBarDisplay) {
									middleBarBuffer.append(c);
								}
								currMiddleBar.setDisplay(middleBarBuffer
										.toString());
								StringBuffer lowerBarBuffer = new StringBuffer();
								for (char c : currLowerBarDisplay) {
									lowerBarBuffer.append(c);
								}
								currLowerBar.setDisplay(lowerBarBuffer
										.toString());
							}
						}
						this.getStaff().setDisplay(this.upperBars,
								this.middleBars, this.lowerBars);
						this.textPane.setText(this.staff.getDisplay());
						if (barNumber > 16) {
							scrollBar.setValue(scrollBar.getMaximum());
						}
					}
				}
			}
		}
	}

	/**
	 * Starts the StaffWriter thread.
	 */
	public void start() {
		this.thread = new Thread(this, "StaffWriter");
		this.thread.start();
	}

	/**
	 * Stop the StaffWriter thread.
	 */
	public void stop() {
		this.thread = null;
	}

	/**
	 * Gets the staff.
	 * 
	 * @return the staff
	 */
	public Staff getStaff() {
		return staff;
	}

	/**
	 * Sets the staff.
	 * 
	 * @param staff
	 *            the new staff
	 */
	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	/**
	 * Find upper bar.
	 * 
	 * @param barNumber
	 *            the bar number
	 * @return the upper bar
	 */
	private UpperBar findUpperBar(int barNumber) {
		List<UpperBar> upperBars = this.getStaff().getUpperBars();
		UpperBar currUpperBar = null;
		for (UpperBar upperBar : upperBars) {
			if (upperBar.getBarNumber() == barNumber) {
				currUpperBar = upperBar;
				break;
			}
		}
		return currUpperBar;
	}

	/**
	 * Find middle bar.
	 * 
	 * @param barNumber
	 *            the bar number
	 * @return the middle bar
	 */
	private MiddleBar findMiddleBar(int barNumber) {
		List<MiddleBar> middleBars = this.getStaff().getMiddleBars();
		MiddleBar currMiddleBar = null;
		for (MiddleBar middleBar : middleBars) {
			if (middleBar.getBarNumber() == barNumber) {
				currMiddleBar = middleBar;
				break;
			}
		}
		return currMiddleBar;
	}

	/**
	 * Find lower bar.
	 * 
	 * @param barNumber
	 *            the bar number
	 * @return the lower bar
	 */
	private LowerBar findLowerBar(int barNumber) {
		List<LowerBar> lowerBars = this.getStaff().getLowerBars();
		LowerBar currLowerBar = null;
		for (LowerBar lowerBar : lowerBars) {
			if (lowerBar.getBarNumber() == barNumber) {
				currLowerBar = lowerBar;
				break;
			}
		}
		return currLowerBar;
	}

	/**
	 * Plots symbol on the Staff.
	 * 
	 * @param symbol
	 *            the symbol
	 * @param symbolPos
	 *            the symbol position
	 * @param note
	 *            the note
	 * @param currUpperBarDisplay
	 *            the current display of the upper bar
	 * @param currMiddleBarDisplay
	 *            the current display of the middle bar
	 * @param currLowerBarDisplay
	 *            the current display of the lower bar
	 * @return the position of the symbol in the staff
	 */
	private int plotSymbol(char[] symbol, int symbolPos, Note note,
			char[] currUpperBarDisplay, char[] currMiddleBarDisplay,
			char[] currLowerBarDisplay) {
		int pos = 0;
		if (symbol != null) {
			int i = 0;
			if (note.isInUpperBar()) {
				for (; i < symbol.length; i++) {
					currUpperBarDisplay[symbolPos + i] = symbol[i];
					if (this.staff instanceof BassStaff) {
						if (this.semibreveExist) {
							currMiddleBarDisplay[symbolPos + i + 1] = '=';
						} else {
							currMiddleBarDisplay[symbolPos + i] = '=';
						}
					}
				}
			} else if (note.isInMiddleBar()) {
				while (i < symbol.length) {
					currMiddleBarDisplay[symbolPos + i] = symbol[i];
					i++;
				}
			} else if (note.isInLowerBar()) {
				while (i < symbol.length) {
					currLowerBarDisplay[symbolPos + i] = symbol[i];
					i++;
				}
			}
			pos = i;
		}
		return pos;
	}

	/**
	 * Removes the dot from the bar.
	 * 
	 * @param symbolPos
	 *            the symbol position
	 * @param pos
	 *            the position
	 * @param note
	 *            the note
	 * @param currUpperBarDisplay
	 *            the current display of the upper bar
	 * @param currMiddleBarDisplay
	 *            the current display of the middle bar
	 * @param currLowerBarDisplay
	 *            the current display of the lower bar
	 */
	private void removeDot(int symbolPos, int pos, Note note,
			char[] currUpperBarDisplay, char[] currMiddleBarDisplay,
			char[] currLowerBarDisplay) {
		if (note.isInUpperBar()) {
			currUpperBarDisplay[symbolPos + pos] = ' ';
			if (this.staff instanceof BassStaff) {
				currMiddleBarDisplay[symbolPos + pos] = ' ';
			}
		} else if (note.isInMiddleBar()) {
			if (this.staff instanceof TrebleStaff
					| this.staff instanceof GreatStaff) {
				currMiddleBarDisplay[symbolPos + pos] = '=';
			} else {
				currMiddleBarDisplay[symbolPos + pos] = ' ';
			}
		} else if (note.isInLowerBar()) {
			if (this.staff instanceof BassStaff
					| this.staff instanceof GreatStaff) {
				currLowerBarDisplay[symbolPos + pos] = '=';
			} else {
				currLowerBarDisplay[symbolPos + pos] = ' ';
			}
		}
	}

	/**
	 * Checks if StaffWriter is suspended.
	 * 
	 * @return true, if StaffWriter is suspended
	 */
	public boolean isSuspend() {
		return suspend;
	}

	/**
	 * Sets the suspend.
	 * 
	 * @param suspend
	 *            the new suspend
	 */
	public void setSuspend(boolean suspend) {
		this.suspend = suspend;
	}

	/**
	 * Resumes StaffWriter thread.
	 */
	public void resume() {
		synchronized (this) {
			this.notify();
		}
	}
}
