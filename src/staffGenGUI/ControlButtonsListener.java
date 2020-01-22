/*
 * @package: staffGenGUI
 * @file: ControlButtonsListener.java
 *
 * @author: Himanshu Babbar
 *
 * Copyright (C) 2013. All rights reserved.
 */
package staffGenGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollBar;

import metronome.Beat;
import metronome.Metronome;
import models.ControlButtonsListenerInputModel;
import staffGenUtils.StaffGenUtilities;
import staffWriterToolbox.NoteHandler;
import staffWriterToolbox.StaffWriterToolbox;
import dataRecordingToolbox.DataRecorder;
import dataRecordingToolbox.DataRecordingToolbox;
import dataRecordingToolbox.DigitalToAnalogConverter;
import dataRecordingToolbox.MIDIGenerator;

/**
 * The Class ControlButtonsListener is the action listener for record, play,
 * pause and stop buttons.
 */
public class ControlButtonsListener implements ActionListener {
	/** The input model. */
	private ControlButtonsListenerInputModel inputModel;

	/**
	 * Instantiates a new control buttons listener.
	 * 
	 * @param inputModel
	 *            the input model
	 */
	public ControlButtonsListener(ControlButtonsListenerInputModel inputModel) {
		this.inputModel = inputModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton recordBtn = this.inputModel.getRecordBtn();
		JButton pauseBtn = this.inputModel.getPauseBtn();
		JButton playBtn = this.inputModel.getPlayBtn();
		JButton stopBtn = this.inputModel.getStopBtn();
		if (event.getActionCommand().equals(
				StaffGenUtilities.Commands.BTN_REC_COMMAND)) {
			StaffGenUtilities.Commands.PAUSE_PRESSED = false;
			JScrollBar scrollBar = this.inputModel.getScrollBar();
			scrollBar.setValue(scrollBar.getMinimum());
			StaffWriterToolbox.populateTextPane(this.inputModel.getTextPane());
			recordBtn.setEnabled(false);
			pauseBtn.setEnabled(true);
			playBtn.setEnabled(false);
			stopBtn.setEnabled(true);
			int bpm = Integer.parseInt(this.inputModel.getBpmTextField()
					.getText());
			Beat beat = new Beat();
			Metronome m = new Metronome(beat, bpm,
					this.inputModel.getCurrBeatTextField());
			DataRecordingToolbox.setMetronome(m);
			MIDIGenerator midiGenerator = new MIDIGenerator();
			DataRecordingToolbox.setMidiGenerator(midiGenerator);
			DigitalToAnalogConverter digitalToAnalogConverter = new DigitalToAnalogConverter();
			DataRecordingToolbox
					.setDigitalToAnalogConverter(digitalToAnalogConverter);
			NoteHandler noteHandler = new NoteHandler();
			StaffWriterToolbox.setNoteHandler(noteHandler);
			DataRecorder dataRecorder = new DataRecorder();
			DataRecordingToolbox.setDataRecorder(dataRecorder);
			dataRecorder.start();
			StaffWriterToolbox.getStaffWriter().start();
		} else if (event.getActionCommand().equals(
				StaffGenUtilities.Commands.BTN_PAUSE_COMMAND)) {
			StaffGenUtilities.Commands.PAUSE_PRESSED = true;
			pauseBtn.setEnabled(false);
			playBtn.setEnabled(true);
			stopBtn.setEnabled(false);
			if (DataRecordingToolbox.getDataRecorder().isRunning()) {
				DataRecordingToolbox.getMetronome().getTimerTask()
						.setSuspend(true);
				DataRecordingToolbox.getDataRecorder().getDataAnalyser()
						.setSuspend(true);
				StaffWriterToolbox.getStaffWriter().setSuspend(true);
			}
		} else if (event.getActionCommand().equals(
				StaffGenUtilities.Commands.BTN_PLAY_COMMAND)) {
			StaffGenUtilities.Commands.PAUSE_PRESSED = false;
			pauseBtn.setEnabled(true);
			playBtn.setEnabled(false);
			stopBtn.setEnabled(true);
			DataRecordingToolbox.getMetronome().getTimerTask().resume();
			DataRecordingToolbox.getMetronome().getTimerTask()
					.setSuspend(false);
			DataRecordingToolbox.getDataRecorder().getDataAnalyser().resume();
			DataRecordingToolbox.getDataRecorder().getDataAnalyser()
					.setSuspend(false);
			StaffWriterToolbox.getStaffWriter().resume();
			StaffWriterToolbox.getStaffWriter().setSuspend(false);
		} else if (event.getActionCommand().equals(
				StaffGenUtilities.Commands.BTN_STOP_COMMAND)) {
			StaffGenUtilities.Commands.PAUSE_PRESSED = false;
			recordBtn.setEnabled(true);
			pauseBtn.setEnabled(false);
			playBtn.setEnabled(false);
			stopBtn.setEnabled(false);
			if (DataRecordingToolbox.getDataRecorder().isRunning()) {
				DataRecordingToolbox.getMetronome().stop();
				DataRecordingToolbox.getDataRecorder().stop();
				StaffWriterToolbox.getStaffWriter().stop();
			}
		}
	}
}
