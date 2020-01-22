/*
 * @package: staffGenGUI
 * @file: StaffMenuListener.java
 *
 * @author: Himanshu Babbar
 *
 * Copyright (C) 2013. All rights reserved.
 */
package staffGenGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollBar;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import models.StaffMenuListenerInputModel;
import staffGenUtils.StaffGenUtilities;
import staffWriterToolbox.BassStaff;
import staffWriterToolbox.GreatStaff;
import staffWriterToolbox.Staff;
import staffWriterToolbox.StaffWriterToolbox;
import staffWriterToolbox.TrebleStaff;
import dataRecordingToolbox.DataRecordingToolbox;

/**
 * The Class StaffMenuListener is the action listener for the items in the Staff
 * menu.
 */
public class StaffMenuListener implements ActionListener {
	/** The input model. */
	private StaffMenuListenerInputModel inputModel;

	/**
	 * Instantiates a new staff menu listener.
	 * 
	 * @param inputModel
	 *            the input model
	 */
	public StaffMenuListener(StaffMenuListenerInputModel inputModel) {
		this.inputModel = inputModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (DataRecordingToolbox.getDataRecorder() != null
				&& DataRecordingToolbox.getDataRecorder().isRunning()) {
			if (StaffWriterToolbox.getStaffWriter().getStaff() instanceof TrebleStaff) {
				this.inputModel.getTrebleRadioMenuItem().setSelected(true);
				this.inputModel.getBassRadioMenuItem().setSelected(false);
				this.inputModel.getGreatRadioMenuItem().setSelected(false);
			} else if (StaffWriterToolbox.getStaffWriter().getStaff() instanceof BassStaff) {
				this.inputModel.getTrebleRadioMenuItem().setSelected(false);
				this.inputModel.getBassRadioMenuItem().setSelected(true);
				this.inputModel.getGreatRadioMenuItem().setSelected(false);
			} else if (StaffWriterToolbox.getStaffWriter().getStaff() instanceof GreatStaff) {
				this.inputModel.getTrebleRadioMenuItem().setSelected(false);
				this.inputModel.getBassRadioMenuItem().setSelected(false);
				this.inputModel.getGreatRadioMenuItem().setSelected(true);
			}
			DataRecordingToolbox.getMetronome().getTimerTask().setSuspend(true);
			DataRecordingToolbox.getDataRecorder().getDataAnalyser()
					.setSuspend(true);
			StaffWriterToolbox.getStaffWriter().setSuspend(true);
			int val = StaffGenUtilities.Messages
					.showInfoMsg("Please Stop recording");
			if (val == 0 && !StaffGenUtilities.Commands.PAUSE_PRESSED) {
				DataRecordingToolbox.getMetronome().getTimerTask().resume();
				DataRecordingToolbox.getMetronome().getTimerTask()
						.setSuspend(false);
				DataRecordingToolbox.getDataRecorder().getDataAnalyser()
						.resume();
				DataRecordingToolbox.getDataRecorder().getDataAnalyser()
						.setSuspend(false);
				StaffWriterToolbox.getStaffWriter().resume();
				StaffWriterToolbox.getStaffWriter().setSuspend(false);
			}
		} else if (e.getActionCommand().equals("trebleStaff")) {
			showTrebleStaff();
			resetScrollBarValue();
		} else if (e.getActionCommand().equals("bassStaff")) {
			showBassStaff();
			resetScrollBarValue();
		} else if (e.getActionCommand().equals("greatStaff")) {
			showGreatStaff();
			resetScrollBarValue();
		}
	}

	/**
	 * Show treble staff.
	 */
	private void showTrebleStaff() {
		StyleContext context = new StyleContext();
		StyledDocument document = new DefaultStyledDocument(context);
		Style style = context.getStyle(StyleContext.DEFAULT_STYLE);
		StyleConstants.setAlignment(style, StyleConstants.ALIGN_LEFT);
		StyleConstants.setLeftIndent(style, 90.0F);
		StyleConstants.setSpaceAbove(style, -18.2F);
		StyleConstants.setSpaceBelow(style, -18.2F);
		Staff staff = new TrebleStaff();
		try {
			StyleConstants.setForeground(style,
					StaffGenUtilities.Colors.TEXT_COLOR);
			document.insertString(document.getLength(), staff.getDisplay(),
					style);
		} catch (BadLocationException badLocationException) {
			int val = StaffGenUtilities.Messages
					.showErrorMsg("Unable to create Staff Sheet");
			if (val == 0) {
				System.exit(1);
			}
		}
		this.inputModel.getTextPane().setDocument(document);
		this.inputModel.getTextPane().setEditable(false);
		this.inputModel.getTextPane().setFont(
				StaffGenUtilities.StaffFont.MUSIC_FONT);
		this.inputModel.getStaffWriter().setStaff(null);
		this.inputModel.getStaffWriter().setStaff(staff);
		StaffWriterToolbox.setStaffWriter(null);
		StaffWriterToolbox.setStaffWriter(this.inputModel.getStaffWriter());
	}

	/**
	 * Show bass staff.
	 */
	private void showBassStaff() {
		StyleContext context = new StyleContext();
		StyledDocument document = new DefaultStyledDocument(context);
		Style style = context.getStyle(StyleContext.DEFAULT_STYLE);
		StyleConstants.setAlignment(style, StyleConstants.ALIGN_LEFT);
		StyleConstants.setLeftIndent(style, 90.0F);
		StyleConstants.setSpaceAbove(style, -18.2F);
		StyleConstants.setSpaceBelow(style, -18.2F);
		Staff staff = new BassStaff();
		try {
			StyleConstants.setForeground(style,
					StaffGenUtilities.Colors.TEXT_COLOR);
			document.insertString(document.getLength(), staff.getDisplay(),
					style);
		} catch (BadLocationException badLocationException) {
			int val = StaffGenUtilities.Messages
					.showErrorMsg("Unable to create Staff Sheet");
			if (val == 0) {
				System.exit(1);
			}
		}
		this.inputModel.getTextPane().setDocument(document);
		this.inputModel.getTextPane().setEditable(false);
		this.inputModel.getTextPane().setFont(
				StaffGenUtilities.StaffFont.MUSIC_FONT);
		this.inputModel.getStaffWriter().setStaff(null);
		this.inputModel.getStaffWriter().setStaff(staff);
		StaffWriterToolbox.setStaffWriter(null);
		StaffWriterToolbox.setStaffWriter(this.inputModel.getStaffWriter());
	}

	/**
	 * Show great staff.
	 */
	private void showGreatStaff() {
		StyleContext context = new StyleContext();
		StyledDocument document = new DefaultStyledDocument(context);
		Style style = context.getStyle(StyleContext.DEFAULT_STYLE);
		StyleConstants.setAlignment(style, StyleConstants.ALIGN_LEFT);
		StyleConstants.setLeftIndent(style, 90.0F);
		StyleConstants.setSpaceAbove(style, -15F);
		StyleConstants.setSpaceBelow(style, -15F);
		Staff staff = new GreatStaff();
		try {
			StyleConstants.setForeground(style,
					StaffGenUtilities.Colors.TEXT_COLOR);
			document.insertString(document.getLength(), staff.getDisplay(),
					style);
		} catch (BadLocationException badLocationException) {
			int val = StaffGenUtilities.Messages
					.showErrorMsg("Unable to create Staff Sheet");
			if (val == 0) {
				System.exit(1);
			}
		}
		this.inputModel.getTextPane().setDocument(document);
		this.inputModel.getTextPane().setEditable(false);
		this.inputModel.getTextPane().setFont(
				StaffGenUtilities.StaffFont.MUSIC_FONT);
		this.inputModel.getStaffWriter().setStaff(null);
		this.inputModel.getStaffWriter().setStaff(staff);
		StaffWriterToolbox.setStaffWriter(null);
		StaffWriterToolbox.setStaffWriter(this.inputModel.getStaffWriter());
	}

	/**
	 * Reset scroll bar value.
	 */
	private void resetScrollBarValue() {
		JScrollBar scrollBar = this.inputModel.getScrollBar();
		scrollBar.setValue(scrollBar.getMinimum());
	}
}
