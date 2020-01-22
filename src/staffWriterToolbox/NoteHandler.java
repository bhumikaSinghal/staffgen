/*
 * @package: staffWriterToolbox
 * @file: NoteHandler.java
 *
 * @author: Himanshu Babbar
 *
 * Copyright (C) 2013. All rights reserved.
 */
package staffWriterToolbox;

import staffGenUtils.StaffGenUtilities;

/**
 * The Class NoteHandler provides synchronised methods for getting and setting a
 * Musical Note.
 */
public class NoteHandler {
	/** The note. */
	private Note note;
	/** The noteSet indicates whether a note is set or not. */
	private boolean noteSet = false;

	/**
	 * Gets the note.
	 * 
	 * @return the note
	 */
	public synchronized Note getNote() {
		if (!(noteSet)) {
			try {
				wait();
			} catch (InterruptedException e) {
				int val = StaffGenUtilities.Messages
						.showErrorMsg("Note Handler Interrupted");
				if (val == 0) {
					System.exit(1);
				}
			}
		}
		noteSet = false;
		notifyAll();
		return note;
	}

	/**
	 * Sets the note.
	 * 
	 * @param note
	 *            the new note
	 */
	public synchronized void setNote(Note note) {
		if (noteSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				int val = StaffGenUtilities.Messages
						.showErrorMsg("Note Handler Interrupted");
				if (val == 0) {
					System.exit(1);
				}
			}
		}
		this.note = note;
		noteSet = true;
		notifyAll();
	}
}
