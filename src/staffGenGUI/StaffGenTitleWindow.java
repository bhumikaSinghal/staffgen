/*
 * @package: staffGenGUI
 * @file: StaffGenTitleWindow.java
 *
 * @author: Himanshu Babbar
 *
 * Copyright (C) 2013. All rights reserved.
 */
package staffGenGUI;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingWorker;

import staffGenUtils.StaffGenUtilities;
import dataRecordingToolbox.DataRecordingToolbox;
import dataRecordingToolbox.DigitalToAnalogConverter;

/**
 * The Class StaffGenTitleWindow.
 */
public class StaffGenTitleWindow implements PropertyChangeListener {
	/** The Constant ENCRYPT_CHAR. */
	private static final char ENCRYPT_CHAR = (char) 250;
	/** The frame. */
	private JWindow frame;
	/** The progress bar. */
	private JProgressBar progressBar;

	/**
	 * The Class TriggerValueFinder.
	 */
	private class TriggerValueFinder extends SwingWorker<Void, Void> {
		/*
		 * (non-Javadoc)
		 * 
		 * @see javax.swing.SwingWorker#doInBackground()
		 */
		@Override
		public Void doInBackground() {
			Random random = new Random();
			int progress = 10;
			setProgress(0);
			while (progress < 100) {
				try {
					Thread.sleep(random.nextInt(500));
				} catch (InterruptedException ignore) {
					int val = StaffGenUtilities.Messages
							.showErrorMsg("Progress Interrupted");
					if (val == 0) {
						System.exit(1);
					}
				}
				progress += random.nextInt(10);
				setProgress(Math.min(progress, 100));
			}
			return null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see javax.swing.SwingWorker#done()
		 */
		@Override
		public void done() {
			frame.dispose();
			StaffGenGUI gui = new StaffGenGUI();
			gui.getFrame().setVisible(true);
		}
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffGenTitleWindow window = new StaffGenTitleWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					int val = StaffGenUtilities.Messages
							.showErrorMsg("Initialization error");
					if (val == 0) {
						System.exit(1);
					}
				}
			}
		});
	}

	/**
	 * Instantiates a new title window.
	 */
	public StaffGenTitleWindow() {
		initialize();
	}

	/**
	 * Initialises the title window.
	 */
	private void initialize() {
		String[][] procIdAndSerialNum = {
				{ "CMD", "/C", "WMIC CPU GET ProcessorId" },
				{ "CMD", "/C", "WMIC BASEBOARD GET SerialNumber" } };
		int infoIndex = 0;
		String[] info = new String[4];
		for (int i = 0; i < procIdAndSerialNum.length; i++) {
			try {
				Process proc = Runtime.getRuntime().exec(procIdAndSerialNum[i]);
				proc.getOutputStream().close();
				BufferedReader br = new BufferedReader(new InputStreamReader(
						proc.getInputStream()));
				String s = null;
				while ((s = br.readLine()) != null) {
					if (!"".equals(s)) {
						info[infoIndex] = s.trim();
						infoIndex++;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		StringBuffer key = new StringBuffer();
		int t = 1;
		for (String s : info) {
			if (t % 2 == 0)
				key.append(s);
			t++;
		}
		File file = new File(new File("staffGen.ini").getAbsolutePath());
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			char[] ch = new char[1];
			StringBuffer decryptedInfo = new StringBuffer();
			while ((br.read(ch)) != -1) {
				decryptedInfo.append((char) (ch[0] ^ ENCRYPT_CHAR));
			}
			br.close();
			String[] str = decryptedInfo.toString().split(":");
			if (!str[0].equals("#")) {
				int val = StaffGenUtilities.Messages
						.showErrorMsg("Initialization file format error");
				if (val == 0) {
					System.exit(1);
				}
			} else {
				BufferedWriter bw = new BufferedWriter(new FileWriter(file));
				if (str.length == 1) {
					String keyToWrite = key.toString();
					StringBuilder encryptedInfo = new StringBuilder();
					for (int i = 0; i < keyToWrite.length(); i++) {
						encryptedInfo
								.append((char) (keyToWrite.charAt(i) ^ ENCRYPT_CHAR));
					}
					bw.write((char) ('#' ^ ENCRYPT_CHAR));
					bw.append((char) (':' ^ ENCRYPT_CHAR));
					bw.append(encryptedInfo.toString());
					bw.close();
				} else {
					if (!key.toString().equals(str[1])) {
						int val = StaffGenUtilities.Messages
								.showErrorMsg("The current installation is valid for only a single machine.");
						if (val == 0) {
							StringBuilder encryptedInfo = new StringBuilder();
							for (int i = 0; i < str[1].length(); i++) {
								encryptedInfo
										.append((char) (str[1].charAt(i) ^ ENCRYPT_CHAR));
							}
							bw.write((char) ('#' ^ ENCRYPT_CHAR));
							bw.append((char) (':' ^ ENCRYPT_CHAR));
							bw.append(encryptedInfo.toString());
							bw.close();
							System.exit(1);
						}
					}
					StringBuilder encryptedInfo = new StringBuilder();
					for (int i = 0; i < str[1].length(); i++) {
						encryptedInfo
								.append((char) (str[1].charAt(i) ^ ENCRYPT_CHAR));
					}
					bw.write((char) ('#' ^ ENCRYPT_CHAR));
					bw.append((char) (':' ^ ENCRYPT_CHAR));
					bw.append(encryptedInfo.toString());
					bw.close();
				}
			}
		} catch (IOException e) {
			int val = StaffGenUtilities.Messages
					.showErrorMsg("Initialization file not found");
			if (val == 0) {
				System.exit(1);
			}
		}
		int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize()
				.getWidth();
		int screeHeight = (int) Toolkit.getDefaultToolkit().getScreenSize()
				.getHeight();
		frame = new JWindow();
		JPanel panel = null;
		try {
			panel = new ImagePanel(
					ImageIO.read(StaffGenUtilities.ImageUrls.TITLE_IMAGE));
		} catch (IOException e1) {
			int val = StaffGenUtilities.Messages
					.showErrorMsg("Title Image not found");
			if (val == 0) {
				System.exit(1);
			}
		}
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE));
		progressBar = new JProgressBar();
		progressBar.setVisible(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addComponent(progressBar,
				GroupLayout.DEFAULT_SIZE,
				(int) (screenWidth * ((float) 434 / 1366)), Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addContainerGap(
								(int) (screenWidth * ((float) 248 / 1366)),
								Short.MAX_VALUE)
						.addComponent(progressBar, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)));
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
		frame.setBounds(((screenWidth / 2) - 250), ((screeHeight / 2) - 200),
				500, 400);
		frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		frame.setVisible(true);
		findTriggerConditionValue();
		createProgressBar();
		TriggerValueFinder triggerValueFinder = new TriggerValueFinder();
		triggerValueFinder.addPropertyChangeListener(this);
		triggerValueFinder.execute();
	}

	/**
	 * Creates the progress bar.
	 */
	private void createProgressBar() {
		progressBar.setForeground(StaffGenUtilities.Colors.PROGRESS_BAR_COLOR);
		progressBar.setVisible(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.
	 * PropertyChangeEvent)
	 */
	@Override
	public void propertyChange(PropertyChangeEvent e) {
		if ("progress" == e.getPropertyName()) {
			int progress = (Integer) e.getNewValue();
			progressBar.setValue(progress);
		}
	}

	/**
	 * Finds the trigger condition value.
	 */
	private void findTriggerConditionValue() {
		AudioFormat audioFormat = new AudioFormat(
				AudioFormat.Encoding.PCM_SIGNED, 44100.0F, 16, 1, 2, 44100.0F,
				false);
		DataLine.Info info = new DataLine.Info(TargetDataLine.class,
				audioFormat);
		TargetDataLine targetDataLine = null;
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
		AudioInputStream audioInputStream = new AudioInputStream(targetDataLine);
		float sum = 0.0F;
		for (int i = 0; i < 5; i++) {
			targetDataLine.start();
			byte[] dataSamples = new byte[(int) (2 * (audioFormat
					.getSampleRate()))];
			try {
				audioInputStream.read(dataSamples, 0, (dataSamples.length));
			} catch (IOException e) {
				int val = StaffGenUtilities.Messages
						.showErrorMsg("Unable to read data");
				if (val == 0) {
					System.exit(1);
				}
			}
			targetDataLine.stop();
			DigitalToAnalogConverter digitalToAnalogConveter = new DigitalToAnalogConverter();
			float[] dataVolts = digitalToAnalogConveter
					.convertDataToVolts(dataSamples);
			if (i > 0) {
				sum += DataRecordingToolbox.findMax(dataVolts);
			}
		}
		targetDataLine.flush();
		targetDataLine.drain();
		targetDataLine.close();
		float triggerConditionValue = (float) ((sum / 4) + 0.018);
		System.out.println(triggerConditionValue);
		DataRecordingToolbox.setTriggerConditionValue(triggerConditionValue);
	}
}
