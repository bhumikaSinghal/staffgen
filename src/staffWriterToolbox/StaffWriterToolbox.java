/*
 * @package: staffWriterToolbox
 * @file: StaffWriterToolbox.java
 *
 * @author: Himanshu Babbar
 *
 * Copyright (C) 2013. All rights reserved.
 */
package staffWriterToolbox;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import staffGenUtils.StaffGenUtilities;

/**
 * The Class StaffWriterToolbox provides methods and objects required for
 * writing a Staff .
 */
public class StaffWriterToolbox {
	/** The staff writer. */
	private static StaffWriter staffWriter;
	/** The note handler. */
	private static NoteHandler noteHandler;

	/**
	 * Gets the staff writer.
	 * 
	 * @return the staff writer
	 */
	public static StaffWriter getStaffWriter() {
		return staffWriter;
	}

	/**
	 * Sets the staff writer.
	 * 
	 * @param staffWriter
	 *            the new staff writer
	 */
	public static void setStaffWriter(StaffWriter staffWriter) {
		StaffWriterToolbox.staffWriter = staffWriter;
	}

	/**
	 * Gets the note handler.
	 * 
	 * @return the note handler
	 */
	public static NoteHandler getNoteHandler() {
		return noteHandler;
	}

	/**
	 * Sets the note handler.
	 * 
	 * @param noteHandler
	 *            the new note handler
	 */
	public static void setNoteHandler(NoteHandler noteHandler) {
		StaffWriterToolbox.noteHandler = noteHandler;
	}

	/**
	 * Populates text the pane.
	 * 
	 * @param textPane
	 *            the text pane
	 */
	public static void populateTextPane(JTextPane textPane) {
		StaffWriter staffWriter = StaffWriterToolbox.getStaffWriter();
		if (staffWriter.getStaff() instanceof TrebleStaff) {
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
			textPane.setDocument(document);
			textPane.setEditable(false);
			textPane.setFont(StaffGenUtilities.StaffFont.MUSIC_FONT);
			staffWriter.setStaff(null);
			staffWriter.setStaff(staff);
			StaffWriterToolbox.setStaffWriter(null);
			StaffWriterToolbox.setStaffWriter(staffWriter);
		} else if (staffWriter.getStaff() instanceof BassStaff) {
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
			textPane.setDocument(document);
			textPane.setEditable(false);
			textPane.setFont(StaffGenUtilities.StaffFont.MUSIC_FONT);
			staffWriter.setStaff(null);
			staffWriter.setStaff(staff);
			StaffWriterToolbox.setStaffWriter(null);
			StaffWriterToolbox.setStaffWriter(staffWriter);
		} else if (staffWriter.getStaff() instanceof GreatStaff) {
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
			textPane.setDocument(document);
			textPane.setEditable(false);
			textPane.setFont(StaffGenUtilities.StaffFont.MUSIC_FONT);
			staffWriter.setStaff(null);
			staffWriter.setStaff(staff);
			StaffWriterToolbox.setStaffWriter(null);
			StaffWriterToolbox.setStaffWriter(staffWriter);
		}
	}
}
