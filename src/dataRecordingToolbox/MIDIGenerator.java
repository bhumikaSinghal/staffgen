/*
 * @package: dataRecordingToolbox
 * @file: MIDIGenerator.java
 * 
 * @author: Himanshu Babbar
 * 
 * Copyright (C) 2013. All rights reserved.
 */
package dataRecordingToolbox;

import staffGenUtils.StaffGenUtilities;

/**
 * The Class MIDIGenerator generates the MIDI number for the data acquired.
 */
public class MIDIGenerator {

	/** The MIDI number. */
	private float midiNumber;

	/** The midiSet. */
	private boolean midiSet = false;

	/**
	 * Instantiates a new MIDI generator.
	 */
	public MIDIGenerator() {

	}

	/**
	 * Calculates MIDI number.
	 * 
	 * @param data
	 *            the data for which the MIDI number is to calculated
	 */
	public void calculateMIDINumber(float[] data) {

		int window = 1024;

		float[] n = new float[data.length];

		for (int tao = 0; tao < (window - 1); tao++) {
			float autoCorr = 0;
			float squareDiff = 0;

			for (int j = 0; j < (window - tao - 1); j++) {
				autoCorr += (data[j] * data[j + tao]);
				squareDiff += (data[j] * data[j])
						+ (data[j + tao] * data[j + tao]);
			}
			n[tao] = (2 * autoCorr) / (squareDiff);
		}

		Peak peaks[] = DataRecordingToolbox.findPeaks(n);
		Peak maxPeak = DataRecordingToolbox.findMaxPeak(peaks);

		float freq = (44100.0F) / (maxPeak.getLoc());

		float midi = (float) (69 + (12 * Math.log10(freq / 440))
				/ Math.log10(2.0));

		this.setMidiNumber(midi);
	}

	/**
	 * Gets the MIDI number.
	 * 
	 * @return the MIDI number generated
	 */
	public synchronized float getMidiNumber() {
		if (!(midiSet)) {
			try {
				wait();
			} catch (InterruptedException e) {
				int val = StaffGenUtilities.Messages
						.showErrorMsg("Thread Interrupted");

				if (val == 0) {
					System.exit(1);
				}
			}
		}
		midiSet = false;
		notifyAll();
		return midiNumber;
	}

	/**
	 * Sets the MIDI number.
	 * 
	 * @param midiNumber
	 *            the new MIDI number
	 */
	public synchronized void setMidiNumber(float midiNumber) {
		if (midiSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				int val = StaffGenUtilities.Messages
						.showErrorMsg("Thread Interrupted");

				if (val == 0) {
					System.exit(1);
				}
			}
		}
		this.midiNumber = midiNumber;
		midiSet = true;
		notifyAll();
	}

	/**
	 * Checks if is MIDI number generated is set.
	 * 
	 * @return true, if is MIDI number is set
	 */
	public boolean isMidiSet() {
		return midiSet;
	}
}
