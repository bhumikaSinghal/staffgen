/*
 * @package: dataRecordingToolbox
 * @file: DataRecordingToolbox.java
 * 
 * @author: Himanshu Babbar
 * 
 * Copyright (C) 2013. All rights reserved.
 */
package dataRecordingToolbox;

import metronome.Metronome;

/**
 * The Class DataRecordingToolbox provides methods, objects and variables
 * required for recording data.
 */
public class DataRecordingToolbox {

	/** The data recorder. */
	private static DataRecorder dataRecorder;

	/** The metronome. */
	private static Metronome metronome;

	/** The MIDI generator. */
	private static MIDIGenerator midiGenerator;

	/** The digital to analog converter. */
	private static DigitalToAnalogConverter digitalToAnalogConverter;

	/** The trigger condition value. */
	private static float triggerConditionValue;

	/** The new trigger condition value. */
	private static float newTriggerConditionValue;

	/** The last midi number. */
	private static float lastMidiNumber;

	/**
	 * Gets the data recorder.
	 * 
	 * @return the data recorder
	 */
	public static DataRecorder getDataRecorder() {
		return dataRecorder;
	}

	/**
	 * Sets the data recorder.
	 * 
	 * @param dataRecorder
	 *            the new data recorder
	 */
	public static void setDataRecorder(DataRecorder dataRecorder) {
		DataRecordingToolbox.dataRecorder = dataRecorder;
	}

	/**
	 * Gets the metronome.
	 * 
	 * @return the metronome
	 */
	public static Metronome getMetronome() {
		return metronome;
	}

	/**
	 * Sets the metronome.
	 * 
	 * @param metronome
	 *            the new metronome
	 */
	public static void setMetronome(Metronome metronome) {
		DataRecordingToolbox.metronome = metronome;
	}

	/**
	 * Gets the midi generator.
	 * 
	 * @return the midi generator
	 */
	public static MIDIGenerator getMidiGenerator() {
		return midiGenerator;
	}

	/**
	 * Sets the midi generator.
	 * 
	 * @param midiGenerator
	 *            the new midi generator
	 */
	public static void setMidiGenerator(MIDIGenerator midiGenerator) {
		DataRecordingToolbox.midiGenerator = midiGenerator;
	}

	/**
	 * Gets the digital to analog converter.
	 * 
	 * @return the digital to analog converter
	 */
	public static DigitalToAnalogConverter getDigitalToAnalogConverter() {
		return digitalToAnalogConverter;
	}

	/**
	 * Sets the digital to analog converter.
	 * 
	 * @param digitalToAnalogConverter
	 *            the new digital to analog converter
	 */
	public static void setDigitalToAnalogConverter(
			DigitalToAnalogConverter digitalToAnalogConverter) {
		DataRecordingToolbox.digitalToAnalogConverter = digitalToAnalogConverter;
	}

	/**
	 * Gets the trigger condition value.
	 * 
	 * @return the trigger condition value
	 */
	public static float getTriggerConditionValue() {
		return triggerConditionValue;
	}

	/**
	 * Sets the trigger condition value.
	 * 
	 * @param triggerConditionValue
	 *            the new trigger condition value
	 */
	public static void setTriggerConditionValue(float triggerConditionValue) {
		DataRecordingToolbox.triggerConditionValue = triggerConditionValue;
	}

	/**
	 * Gets the new trigger condition value.
	 * 
	 * @return the new trigger condition value
	 */
	public static float getNewTriggerConditionValue() {
		return newTriggerConditionValue;
	}

	/**
	 * Sets the new trigger condition value.
	 * 
	 * @param newTriggerConditionValue
	 *            the new new trigger condition value
	 */
	public static void setNewTriggerConditionValue(
			float newTriggerConditionValue) {
		DataRecordingToolbox.newTriggerConditionValue = newTriggerConditionValue;
	}

	/**
	 * Gets the last midi number.
	 * 
	 * @return the last midi number
	 */
	public static float getLastMidiNumber() {
		return lastMidiNumber;
	}

	/**
	 * Sets the last midi number.
	 * 
	 * @param lastMidiNumber
	 *            the new last midi number
	 */
	public static void setLastMidiNumber(float lastMidiNumber) {
		DataRecordingToolbox.lastMidiNumber = lastMidiNumber;
	}

	/**
	 * Find max.
	 * 
	 * @param dataVolts
	 *            the data volts
	 * @return the float
	 */
	public static float findMax(float[] dataVolts) {
		float max = 0.0F;

		for (float dataVolt : dataVolts) {
			if (max < dataVolt) {
				max = dataVolt;
			}
		}
		return max;
	}

	/**
	 * Find peaks.
	 * 
	 * @param n
	 *            the n
	 * @return the peak[]
	 */
	public static Peak[] findPeaks(float[] n) {

		int numOfPeaks = 0;

		for (int i = 1; i < (n.length - 1); i++) {
			if (n[i] > n[i - 1] & n[i] > n[i + 1]) {
				numOfPeaks++;
			}
		}

		Peak[] peaks = new Peak[numOfPeaks];

		for (int i = 0; i < peaks.length; i++) {
			peaks[i] = new Peak();
		}

		for (int i = 1, k = 0; i < (n.length - 1); i++) {
			if (n[i] > n[i - 1] & n[i] > n[i + 1]) {
				peaks[k].setVal(n[i]);
				peaks[k].setLoc(i + 1);
				k++;
			}
		}

		return peaks;
	}

	/**
	 * Find max peak.
	 * 
	 * @param peaks
	 *            the peaks
	 * @return the peak
	 */
	public static Peak findMaxPeak(Peak[] peaks) {
		Peak maxPeak = new Peak();

		for (int k = 0; k < peaks.length; k++) {
			if (peaks[k].getVal() >= maxPeak.getVal()) {
				maxPeak = peaks[k];

			}
		}
		return maxPeak;
	}
}
