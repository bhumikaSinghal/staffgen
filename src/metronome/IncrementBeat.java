/*
 * @package: metronome
 * @file: IncrementBeat.java
 *
 * @author: Himanshu Babbar
 *
 * Copyright (C) 2013. All rights reserved.
 */
package metronome;

import java.util.TimerTask;

import javax.swing.JTextField;

import staffGenUtils.StaffGenUtilities;

/**
 * The Class IncrementBeat is a TimerTask that increments the metronome beat
 * according to the bpm value entered by the user.
 */
public class IncrementBeat extends TimerTask {
	/**
	 * The beatVal is an internal variable for calculating the value to be set
	 * in metronome beat.
	 */
	private int beatVal = 0;
	/** The beat is an instance of the Beat class. */
	private Beat beat;
	/**
	 * The textField is the text field in which the value of the metronome is
	 * updated at according to the beats per minute (bpm) entered by the user.
	 */
	private JTextField textField;
	/**
	 * The suspend flag is used to suspend the Timer Task from incrementing the
	 * metronome beat.
	 */
	private boolean suspend = false;

	/**
	 * Instantiates a new Timer Task IncrementBeat.
	 * 
	 * @param beat
	 *            is the beat of metronome beat
	 * @param textField
	 *            is the text field in which the value of the metronome is
	 *            updated at according to the beats per minute (bpm) entered by
	 *            the user.
	 */
	public IncrementBeat(Beat beat, JTextField textField) {
		this.beat = beat;
		this.textField = textField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.TimerTask#run()
	 */
	@Override
	public void run() {
		if (this.suspend) {
			synchronized (this) {
				while (this.suspend) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						int val = StaffGenUtilities.Messages
								.showErrorMsg("Metronome Beat Interrupted");
						if (val == 0) {
							System.exit(1);
						}
					}
				}
			}
		} else {
			beat.setValue(++beatVal);
			if (beatVal % 2 == 0) {
				this.textField
						.setBackground(StaffGenUtilities.Colors.TEXT_COLOR);
				this.textField.setForeground(StaffGenUtilities.Colors.WHITE);
			} else {
				this.textField.setBackground(StaffGenUtilities.Colors.WHITE);
				this.textField
						.setForeground(StaffGenUtilities.Colors.TEXT_COLOR);
			}
			this.textField.setText(String.valueOf(beatVal));
		}
	}

	/**
	 * Sets the suspend flag in the Timer Task IncrementBeat.
	 * 
	 * @param suspend
	 *            the new suspend flag in the Timer Task IncrementBeat.
	 */
	public void setSuspend(boolean suspend) {
		this.suspend = suspend;
	}

	/**
	 * Resume is used to resume the functionality of the Timer Task
	 * IncrementBeat.
	 */
	public void resume() {
		synchronized (this) {
			this.notify();
		}
	}
}
