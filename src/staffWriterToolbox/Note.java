/*
 * @package: staffWriterToolbox
 * @file: Note.java
 *
 * @author: Himanshu Babbar
 *
 * Copyright (C) 2013. All rights reserved.
 */
package staffWriterToolbox;

/**
 * The Class Note represents the Music Note.
 */
public class Note {
	/** The MIDI number. */
	private float midiNumber;
	/** The beat. */
	private int beat;
	/** The symbol. */
	private String symbol;
	/** The inUpperBar indicates that the note is in upper bar of the Staff. */
	private boolean inUpperBar;
	/** The inMiddleBar indicates that the note is in middle bar of the Staff. */
	private boolean inMiddleBar;
	/** The inLowerBar indicates that the note is in lower bar of the Staff. */
	private boolean inLowerBar;

	/**
	 * Instantiates a new note.
	 * 
	 * @param midiNumber
	 *            the midi number
	 * @param beat
	 *            the beat
	 */
	public Note(float midiNumber, int beat) {
		this.setMidiNumber(midiNumber);
		this.setBeat(beat);
	}

	/**
	 * Gets the MIDI number of the Note.
	 * 
	 * @return the MIDI number of the Note
	 */
	public float getMidiNumber() {
		return midiNumber;
	}

	/**
	 * Sets the MIDI number of the Note.
	 * 
	 * @param midiNumber
	 *            the new MIDI number of the Note
	 */
	public void setMidiNumber(float midiNumber) {
		this.midiNumber = midiNumber;
	}

	/**
	 * Gets the beat at which the note was played.
	 * 
	 * @return the beat at which the note was played
	 */
	public int getBeat() {
		return beat;
	}

	/**
	 * Sets the beat at which the note was played.
	 * 
	 * @param beat
	 *            the new beat at which the note was played
	 */
	public void setBeat(int beat) {
		this.beat = beat;
	}

	/**
	 * Gets the symbol of the note.
	 * 
	 * @return the symbol of the note
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * Sets the symbol of the note.
	 * 
	 * @param symbol
	 *            the new symbol of the note
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * Checks if the note is in upper bar.
	 * 
	 * @return true, if the note is in upper bar
	 */
	public boolean isInUpperBar() {
		return inUpperBar;
	}

	/**
	 * Sets the note in upper bar.
	 * 
	 * @param inUpperBar
	 *            true or false
	 */
	public void setInUpperBar(boolean inUpperBar) {
		this.inUpperBar = inUpperBar;
	}

	/**
	 * Checks if is in middle bar.
	 * 
	 * @return true, if is in middle bar
	 */
	public boolean isInMiddleBar() {
		return inMiddleBar;
	}

	/**
	 * Sets the in middle bar.
	 * 
	 * @param inMiddleBar
	 *            the new in middle bar
	 */
	public void setInMiddleBar(boolean inMiddleBar) {
		this.inMiddleBar = inMiddleBar;
	}

	/**
	 * Checks if the note is in lower bar.
	 * 
	 * @return true, if the note is in lower bar
	 */
	public boolean isInLowerBar() {
		return inLowerBar;
	}

	/**
	 * Sets the note in lower bar.
	 * 
	 * @param inLowerBar
	 *            true or false
	 */
	public void setInLowerBar(boolean inLowerBar) {
		this.inLowerBar = inLowerBar;
	}
}
