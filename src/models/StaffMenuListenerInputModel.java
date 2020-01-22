/*
 * @package: models
 * @file: StaffMenuListenerInputModel.java
 *
 * @author: Himanshu Babbar
 *
 * Copyright (C) 2013. All rights reserved.
 */
package models;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;

import staffWriterToolbox.StaffWriter;

/**
 * The Class StaffMenuListenerInputModel contains the fields required as an
 * input for StaffMenuListener.
 */
public class StaffMenuListenerInputModel {
	/** The scroll bar. */
	private JScrollBar scrollBar;
	/** The text pane. */
	private JTextPane textPane;
	/** The staff writer. */
	private StaffWriter staffWriter;
	/** The treble radio menu item. */
	private JRadioButtonMenuItem trebleRadioMenuItem;
	/** The bass radio menu item. */
	private JRadioButtonMenuItem bassRadioMenuItem;
	/** The great radio menu item. */
	private JRadioButtonMenuItem greatRadioMenuItem;

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
	 * Gets the staff writer.
	 * 
	 * @return the staff writer
	 */
	public StaffWriter getStaffWriter() {
		return staffWriter;
	}

	/**
	 * Sets the staff writer.
	 * 
	 * @param staffWriter
	 *            the new staff writer
	 */
	public void setStaffWriter(StaffWriter staffWriter) {
		this.staffWriter = staffWriter;
	}

	/**
	 * Gets the treble radio menu item.
	 * 
	 * @return the treble radio menu item
	 */
	public JRadioButtonMenuItem getTrebleRadioMenuItem() {
		return trebleRadioMenuItem;
	}

	/**
	 * Sets the treble radio menu item.
	 * 
	 * @param trebleRadioMenuItem
	 *            the new treble radio menu item
	 */
	public void setTrebleRadioMenuItem(JRadioButtonMenuItem trebleRadioMenuItem) {
		this.trebleRadioMenuItem = trebleRadioMenuItem;
	}

	/**
	 * Gets the bass radio menu item.
	 * 
	 * @return the bass radio menu item
	 */
	public JRadioButtonMenuItem getBassRadioMenuItem() {
		return bassRadioMenuItem;
	}

	/**
	 * Sets the bass radio menu item.
	 * 
	 * @param bassRadioMenuItem
	 *            the new bass radio menu item
	 */
	public void setBassRadioMenuItem(JRadioButtonMenuItem bassRadioMenuItem) {
		this.bassRadioMenuItem = bassRadioMenuItem;
	}

	/**
	 * Gets the great radio menu item.
	 * 
	 * @return the great radio menu item
	 */
	public JRadioButtonMenuItem getGreatRadioMenuItem() {
		return greatRadioMenuItem;
	}

	/**
	 * Sets the great radio menu item.
	 * 
	 * @param greatRadioMenuItem
	 *            the new great radio menu item
	 */
	public void setGreatRadioMenuItem(JRadioButtonMenuItem greatRadioMenuItem) {
		this.greatRadioMenuItem = greatRadioMenuItem;
	}
}
