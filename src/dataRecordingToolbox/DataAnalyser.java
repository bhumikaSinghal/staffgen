/*
 * @package: dataRecordingToolbox
 * @file: DataAnalyser.java
 * 
 * @author: Himanshu Babbar
 * 
 * Copyright (C) 2013. All rights reserved.
 */
package dataRecordingToolbox;

import java.io.IOException;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;

import metronome.Beat;
import staffGenUtils.StaffGenUtilities;
import staffWriterToolbox.Note;
import staffWriterToolbox.NoteHandler;
import staffWriterToolbox.StaffWriterToolbox;

/**
 * The Class DataAnalyser reads sampled data from the audio input streams and
 * analyses it for the calculation of MIDI number.
 */
public class DataAnalyser extends TimerTask {

	/** The audio input stream for acquiring data. */
	private AudioInputStream audioInputStream;

	/** The sampling rate of data. */
	private float sampleRate;

	/** The suspend is a flag for suspending the thread . */
	private boolean suspend = false;

	/**
	 * Instantiates a new data analyser.
	 * 
	 * @param audioInputStream
	 *            the audio input stream
	 * @param sampleRate
	 *            the sample rate
	 */
	public DataAnalyser(AudioInputStream audioInputStream, float sampleRate) {
		this.audioInputStream = audioInputStream;
		this.sampleRate = sampleRate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.TimerTask#run()
	 */
	@Override
	public void run() {

		if (isSuspend()) {
			synchronized (this) {
				while (isSuspend()) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						int val = StaffGenUtilities.Messages
								.showErrorMsg("Data analyser Interrupted");

						if (val == 0) {
							System.exit(1);
						}
					}
				}
			}
		} else {

			byte[] dataSamples = new byte[(int) (2 * sampleRate)];

			try {
				audioInputStream.read(dataSamples, 0, (dataSamples.length));
			} catch (IOException e) {
				int val = StaffGenUtilities.Messages
						.showErrorMsg("Unable to read data");

				if (val == 0) {
					System.exit(1);
				}
			}

			DigitalToAnalogConverter digitalToAnalogConverter = DataRecordingToolbox
					.getDigitalToAnalogConverter();
			float[] dataVolts = digitalToAnalogConverter
					.convertDataToVolts(dataSamples);

			float maxVolt = 0.0F;

			int triggerConditionValueIndex = analyseDataForTriggerCondition(dataVolts);

			if (triggerConditionValueIndex != -1) {

				float[] dataForMIDIGenerator = new float[(dataVolts.length)
						- triggerConditionValueIndex];

				for (int k = triggerConditionValueIndex, l = 0; k < dataVolts.length; k++) {
					dataForMIDIGenerator[l] = dataVolts[k];
					l++;
				}

				if (dataForMIDIGenerator.length >= 1024) {

					MIDIGenerator midiGenerator = DataRecordingToolbox
							.getMidiGenerator();
					float lastMidi = DataRecordingToolbox.getLastMidiNumber();

					midiGenerator.calculateMIDINumber(dataForMIDIGenerator);

					float midi = midiGenerator.getMidiNumber();

					NoteHandler noteHandler = StaffWriterToolbox
							.getNoteHandler();
					noteHandler.setNote(null);

					for (float volt : dataForMIDIGenerator) {
						if (volt > maxVolt) {
							maxVolt = volt;
						}
					}

					Beat beat = DataRecordingToolbox.getMetronome().getBeat();
					int beatValue = beat.getValue();

					if (Math.abs(midi - lastMidi) <= 1.0F) {
						if (maxVolt <= DataRecordingToolbox
								.getNewTriggerConditionValue()) {
							noteHandler.setNote(null);
						} else {

							float newTriggerConditionValue = (float) ((float) maxVolt / 1.245);

							DataRecordingToolbox
									.setNewTriggerConditionValue(newTriggerConditionValue);
						}
					} else {

						float newTriggerConditionValue = (float) ((float) maxVolt / 1.5);

						DataRecordingToolbox
								.setNewTriggerConditionValue(newTriggerConditionValue);

						Note note = new Note(midi, beatValue);
						noteHandler.setNote(note);
					}

					DataRecordingToolbox.setLastMidiNumber(midi);
				}
			}
		}
	}

	/**
	 * Analyse data for trigger condition.
	 * 
	 * @param dataVolts
	 *            the data volts containing the voltage values of the data
	 *            acquired.
	 * @return the index where the voltage is greater than the trigger condition
	 *         value.
	 */
	private int analyseDataForTriggerCondition(float[] dataVolts) {

		for (int i = 1; i < dataVolts.length; i++) {
			if ((dataVolts[i] - dataVolts[i - 1]) > 0
					& (dataVolts[i] > DataRecordingToolbox
							.getTriggerConditionValue())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Checks if the suspend flag of DataAnalyser is true.
	 * 
	 * @return true, if the suspend flag is true
	 */
	public boolean isSuspend() {
		return suspend;
	}

	/**
	 * Sets the suspend flag of the DataAnalyser thread.
	 * 
	 * @param suspend
	 *            the new suspend flag
	 */
	public void setSuspend(boolean suspend) {
		this.suspend = suspend;
	}

	/**
	 * Resume is used to resume the DataAnalyser thread from its waiting state.
	 */
	public void resume() {
		synchronized (this) {
			this.notify();
		}
	}

}
