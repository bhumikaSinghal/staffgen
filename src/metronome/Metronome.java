/*
 * @package: metronome
 * @file: Metronome.java
 *
 * @author: Himanshu Babbar
 *
 * Copyright (C) 2013. All rights reserved.
 */
package metronome;

import java.util.Timer;

import javax.swing.JTextField;

/**
 * The Class Metronome provides the functionality of a metronome used for
 * maintaining the timing of a composition.
 */
public class Metronome {
	/** The timer of the metronome. */
	private Timer timer;
	/** The bpm is the beats per minute of the metronome. */
	private int bpm;
	/** The period. */
	private int period;
	/** The beat of the metronome. */
	private Beat beat;
	/**
	 * The currBeatTextField is the text field in which the metronome beat is
	 * updated according to the bpm of the metronome.
	 */
	private JTextField currBeatTextField;
	/**
	 * The timer task is used to increment the beat of the metronome according
	 * to the bpm of the metronome.
	 */
	private IncrementBeat timerTask;

	/**
	 * Instantiates a new metronome.
	 * 
	 * @param beat
	 *            is the beat of the metronome
	 * @param bpm
	 *            is the bpm entered by the user
	 * @param currBeatTextField
	 *            is the text field in which the metronome beat is updated
	 *            according to the bpm of the metronome.
	 */
	public Metronome(Beat beat, int bpm, JTextField currBeatTextField) {
		this.bpm = bpm;
		this.setPeriod(calculatePeriod());
		this.setBeat(beat);
		this.currBeatTextField = currBeatTextField;
	}

	/**
	 * Starts the metronome.
	 */
	public void start() {
		timer = new Timer();
		timerTask = new IncrementBeat(this.getBeat(), this.currBeatTextField);
		timer.schedule(timerTask, getPeriod(), getPeriod());
	}

	/**
	 * Stops the metronome.
	 */
	public void stop() {
		timer.cancel();
	}

	/**
	 * Calculates period at which the timer of the metronome is scheduled. The
	 * period is calculated according to the bpm entered by the user.
	 * 
	 * @return the int is the period calulated.
	 */
	private int calculatePeriod() {
		period = (int) Math.ceil(1000 / (double) (this.bpm / 60.0));
		return period;
	}

	/**
	 * Gets the period of the metronome.
	 * 
	 * @return the period of the metronome.
	 */
	public int getPeriod() {
		return period;
	}

	/**
	 * Sets the period of the metronome.
	 * 
	 * @param period
	 *            the new period of the metronome.
	 */
	public void setPeriod(int period) {
		this.period = period;
	}

	/**
	 * Gets the beat of the metronome.
	 * 
	 * @return the beat of the metronome.
	 */
	public Beat getBeat() {
		return beat;
	}

	/**
	 * Sets the of the metronome.
	 * 
	 * @param beat
	 *            the new beat of the metronome.
	 */
	public void setBeat(Beat beat) {
		this.beat = beat;
	}

	/**
	 * Gets the timer task of the metronome.
	 * 
	 * @return the timer task of the metronome.
	 */
	public IncrementBeat getTimerTask() {
		return timerTask;
	}

	/**
	 * Sets the timer task of the metronome.
	 * 
	 * @param timerTask
	 *            the new timer task of the metronome.
	 */
	public void setTimerTask(IncrementBeat timerTask) {
		this.timerTask = timerTask;
	}
}
