/*
 * @package: staffWriterToolbox
 * @file: BarBeat.java
 *
 * @author: Himanshu Babbar
 *
 * Copyright (C) 2013. All rights reserved.
 */
package staffWriterToolbox;

/**
 * The Class BarBeat represents the Beat in a Bar.
 */
public class BarBeat {
	/** The value. */
	private int value;
	/** The note. */
	private Note note;

	/**
	 * Instantiates a new bar beat.
	 * 
	 * @param value
	 *            the value
	 */
	public BarBeat(int value) {
		this.setValue(value);
	}

	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 * 
	 * @param value
	 *            the new value
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * Gets the note.
	 * 
	 * @return the note
	 */
	public Note getNote() {
		return note;
	}

	/**
	 * Sets the note.
	 * 
	 * @param note
	 *            the new note
	 */
	public void setNote(Note note) {
		this.note = note;
	}
}
