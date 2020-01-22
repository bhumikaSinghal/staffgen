/*
 * @package: dataRecordingToolbox
 * @file: DataRecorder.java
 * 
 * @author: Himanshu Babbar
 * 
 * Copyright (C) 2013. All rights reserved.
 */
package dataRecordingToolbox;

import java.util.Timer;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

import metronome.Metronome;
import staffGenUtils.StaffGenUtilities;

/**
 * The Class DataRecorder records the data.
 */
public class DataRecorder implements Runnable {

	/** The DataRecorder thread. */
	private Thread thread;

	/** The line from which the DataRecorder acquires data. */
	private TargetDataLine targetDataLine;

	/** The format of the audio data acquired. */
	private AudioFormat audioFormat;

	/** The audio input stream for acquiring the data. */
	private AudioInputStream audioInputStream;

	/** The timer for scheduling data analyser. */
	private Timer timerForDataAnalyser;

	/**
	 * The running is the flag used to determine whether DataRecorder is running
	 * or not.
	 */
	private boolean running = false;

	/** The data analyser. */
	private DataAnalyser dataAnalyser;

	/**
	 * Instantiates a new data recorder.
	 */
	public DataRecorder() {
		thread = new Thread(this, "AudioRecorder");
		audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
				44100.0F, 16, 1, 2, 44100.0F, false);

		DataLine.Info info = new DataLine.Info(TargetDataLine.class,
				audioFormat);

		try {
			targetDataLine = (TargetDataLine) AudioSystem.getLine(info);
			if (targetDataLine != null) {
				targetDataLine.open(audioFormat);
			} else {
				int val = StaffGenUtilities.Messages
						.showErrorMsg("Unable to get recording line");

				if (val == 0) {
					System.exit(1);
				}
			}
		} catch (LineUnavailableException e) {
			int val = StaffGenUtilities.Messages
					.showErrorMsg("Recording Line Unavailable");

			if (val == 0) {
				System.exit(1);
			}
		}

		audioInputStream = new AudioInputStream(targetDataLine);

		this.dataAnalyser = new DataAnalyser(audioInputStream,
				audioFormat.getSampleRate());

		timerForDataAnalyser = new Timer();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

		targetDataLine.start();

		Metronome metronome = DataRecordingToolbox.getMetronome();
		metronome.start();

		timerForDataAnalyser.schedule(this.dataAnalyser, metronome.getPeriod(),
				metronome.getPeriod());

	}

	/**
	 * Starts the DataRecorder thread.
	 */
	public void start() {
		thread.start();
		running = true;
	}

	/**
	 * Stops DataRecorder.
	 */
	public void stop() {
		targetDataLine.stop();
		targetDataLine.close();
		timerForDataAnalyser.cancel();
		running = false;
	}

	/**
	 * Checks if DataRecorder thread is running.
	 * 
	 * @return true, if is running
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * Gets the data analyser.
	 * 
	 * @return the data analyser
	 */
	public DataAnalyser getDataAnalyser() {
		return dataAnalyser;
	}

}
