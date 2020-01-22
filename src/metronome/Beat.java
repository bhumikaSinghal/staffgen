/*
 * @package: metronome
 * @file: Beat.java
 *
 * @author: Himanshu Babbar
 *
 * Copyright (C) 2013. All rights reserved.
 */
package metronome;

/**
 * The Class Beat maintains the value of the beat of the metronome.
 */
public class Beat {
	/** The value is the value of the metronome beat. */
	private int value;

	/**
	 * Sets the value of the metronome beat.
	 * 
	 * @param value
	 *            the new value of the metronome beat.
	 */
	public synchronized void setValue(int value) {
		this.value = value;
	}

	/**
	 * Gets the current value of the metronome beat.
	 * 
	 * @return the value of the metronome beat
	 */
	public synchronized int getValue() {
		return value;
	}
}
