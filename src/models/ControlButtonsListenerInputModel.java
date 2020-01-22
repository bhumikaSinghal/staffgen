/*
 * @package: models
 * @file: ControlButtonsListenerInputModel.java
 *
 * @author: Himanshu Babbar
 *
 * Copyright (C) 2013. All rights reserved.
 */
package models;

import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 * The Class ControlButtonsListenerInputModel contains the fields required as an
 * input for ControlButtonsListener.
 */
public class ControlButtonsListenerInputModel {
	/** The scrollBar. */
	private JScrollBar scrollBar;
	/** The bpmTextField. */
	private JTextField bpmTextField;
	/** The currBeatTextField. */
	private JTextField currBeatTextField;
	/** The textPane. */
	private JTextPane textPane;
	/** The record button. */
	private JButton recordBtn;
	/** The pause button. */
	private JButton pauseBtn;
	/** The play button. */
	private JButton playBtn;
	/** The stop button. */
	private JButton stopBtn;

	/**
	 * Gets the scroll bar.
	 * 
	 * @return the scroll bar
	 */
	public JScrollBar getScrollBar() {
		return scrollBar;
	}

	/**
	 * Sets the scroll bar.
	 * 
	 * @param scrollBar
	 *            the new scroll bar
	 */
	public void setScrollBar(JScrollBar scrollBar) {
		this.scrollBar = scrollBar;
	}

	/**
	 * Gets the bpm text field.
	 * 
	 * @return the bpm text field
	 */
	public JTextField getBpmTextField() {
		return bpmTextField;
	}

	/**
	 * Sets the bpm text field.
	 * 
	 * @param bpmTextField
	 *            the new bpm text field
	 */
	public void setBpmTextField(JTextField bpmTextField) {
		this.bpmTextField = bpmTextField;
	}

	/**
	 * Gets the curr beat text field.
	 * 
	 * @return the curr beat text field
	 */
	public JTextField getCurrBeatTextField() {
		return currBeatTextField;
	}

	/**
	 * Sets the curr beat text field.
	 * 
	 * @param currBeatTextField
	 *            the new curr beat text field
	 */
	public void setCurrBeatTextField(JTextField currBeatTextField) {
		this.currBeatTextField = currBeatTextField;
	}

	/**
	 * Gets the text pane.
	 * 
	 * @return the text pane
	 */
	public JTextPane getTextPane() {
		return textPane;
	}

	/**
	 * Sets the text pane.
	 * 
	 * @param textPane
	 *            the new text pane
	 */
	public void setTextPane(JTextPane textPane) {
		this.textPane = textPane;
	}

	/**
	 * Gets the record button.
	 * 
	 * @return the record button
	 */
	public JButton getRecordBtn() {
		return recordBtn;
	}

	/**
	 * Sets the record button.
	 * 
	 * @param recordBtn
	 *            the new record button
	 */
	public void setRecordBtn(JButton recordBtn) {
		this.recordBtn = recordBtn;
	}

	/**
	 * Gets the pause button.
	 * 
	 * @return the pause button
	 */
	public JButton getPauseBtn() {
		return pauseBtn;
	}

	/**
	 * Sets the pause button.
	 * 
	 * @param pauseBtn
	 *            the new pause button
	 */
	public void setPauseBtn(JButton pauseBtn) {
		this.pauseBtn = pauseBtn;
	}

	/**
	 * Gets the play button.
	 * 
	 * @return the play button
	 */
	public JButton getPlayBtn() {
		return playBtn;
	}

	/**
	 * Sets the play button.
	 * 
	 * @param playBtn
	 *            the new play button
	 */
	public void setPlayBtn(JButton playBtn) {
		this.playBtn = playBtn;
	}

	/**
	 * Gets the stop button.
	 * 
	 * @return the stop button
	 */
	public JButton getStopBtn() {
		return stopBtn;
	}

	/**
	 * Sets the stop button.
	 * 
	 * @param stopBtn
	 *            the new stop button
	 */
	public void setStopBtn(JButton stopBtn) {
		this.stopBtn = stopBtn;
	}
}
