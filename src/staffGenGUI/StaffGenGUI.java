/*
 * @package: staffGenGUI
 * @file: StaffGenGUI.java
 *
 * @author: Himanshu Babbar
 *
 * Copyright (C) 2013. All rights reserved.
 */
package staffGenGUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import models.ControlButtonsListenerInputModel;
import models.StaffMenuListenerInputModel;
import staffGenUtils.StaffGenUtilities;
import staffWriterToolbox.Staff;
import staffWriterToolbox.StaffWriter;
import staffWriterToolbox.StaffWriterToolbox;
import staffWriterToolbox.TrebleStaff;

/**
 * The Class StaffGenGUI provides the Graphical User Interface for StaffGen.
 */
public class StaffGenGUI {
	/** The frame of the application. */
	private JFrame frame;

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
					StaffGenGUI window = new StaffGenGUI();
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
	 * Instantiates a new GUI.
	 */
	public StaffGenGUI() {
		initialize();
	}

	/**
	 * Initialises the GUI.
	 */
	private void initialize() {
		frame = new JFrame("StaffGen");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				StaffGenUtilities.ImageUrls.IMAGE_ICON_FRAME));
		int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize()
				.getWidth();
		int screeHeight = (int) Toolkit.getDefaultToolkit().getScreenSize()
				.getHeight();
		try {
			frame.setContentPane(new ImageContentPane(ImageIO
					.read(StaffGenUtilities.ImageUrls.WOODEN_PANEL)));
		} catch (IOException e) {
			int val = StaffGenUtilities.Messages
					.showErrorMsg("Frame initialization error");
			if (val == 0) {
				System.exit(1);
			}
		}
		JPanel panel = null;
		try {
			panel = new ImagePanel(
					ImageIO.read(StaffGenUtilities.ImageUrls.TEXT_PANEL));
		} catch (IOException e1) {
			int val = StaffGenUtilities.Messages
					.showErrorMsg("Text Panel Image not found");
			if (val == 0) {
				System.exit(1);
			}
		}
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED,
				StaffGenUtilities.Colors.MENU_BAR_COLOR, null, null, null));
		panel.setForeground(StaffGenUtilities.Colors.TEXT_COLOR);
		panel.setBackground(StaffGenUtilities.Colors.TEXT_BACKGROUND_COLOR);
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
		JTextPane textPane = null;
		try {
			textPane = new ImageTextPane(
					ImageIO.read(StaffGenUtilities.ImageUrls.PARCHMENT_PAPER));
		} catch (IOException e) {
			int val = StaffGenUtilities.Messages
					.showErrorMsg("Paper Image not found");
			if (val == 0) {
				System.exit(1);
			}
		}
		textPane.setDocument(document);
		textPane.setEditable(false);
		textPane.setFont(StaffGenUtilities.StaffFont.MUSIC_FONT);
		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setPreferredSize(textPane.getPreferredSize());
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED,
				StaffGenUtilities.Colors.MENU_BAR_COLOR, null, null, null));
		scrollPane.setAutoscrolls(true);
		JLabel enterBpmLabel = new JLabel("Enter Beats Per Minute:");
		enterBpmLabel.setForeground(StaffGenUtilities.Colors.TEXT_COLOR);
		enterBpmLabel.setFont(new Font(
				StaffGenGUIConstants.METRONOME_PANEL_FONT, Font.BOLD,
				StaffGenGUIConstants.METRONOME_PANEL_FONT_SIZE));
		JTextField bpmTextField = new JTextField();
		bpmTextField.setFont(new Font(
				StaffGenGUIConstants.METRONOME_PANEL_FONT, Font.BOLD,
				StaffGenGUIConstants.METRONOME_PANEL_FONT_SIZE));
		bpmTextField.setColumns(10);
		bpmTextField.setForeground(StaffGenUtilities.Colors.TEXT_COLOR);
		bpmTextField.setText("60");
		JLabel bpmLabel = new JLabel(StaffGenGUIConstants.BPM_LABEL_VALUE);
		bpmLabel.setForeground(StaffGenUtilities.Colors.TEXT_COLOR);
		bpmLabel.setFont(new Font(StaffGenGUIConstants.METRONOME_PANEL_FONT,
				Font.BOLD, StaffGenGUIConstants.METRONOME_PANEL_FONT_SIZE));
		JLabel currentBeatLabel = new JLabel(
				StaffGenGUIConstants.CURRENT_BEAT_LABEL_VAL);
		currentBeatLabel.setForeground(StaffGenUtilities.Colors.TEXT_COLOR);
		currentBeatLabel.setFont(new Font(
				StaffGenGUIConstants.METRONOME_PANEL_FONT, Font.BOLD, 26));
		JTextField currBeatTextField = new JTextField();
		currBeatTextField.setBackground(StaffGenUtilities.Colors.WHITE);
		currBeatTextField.setForeground(StaffGenUtilities.Colors.TEXT_COLOR);
		currBeatTextField.setHorizontalAlignment(JTextField.CENTER);
		currBeatTextField.setFont(new Font(
				StaffGenGUIConstants.METRONOME_PANEL_FONT, Font.BOLD, 36));
		currBeatTextField.setEditable(false);
		currBeatTextField.setColumns(3);
		currBeatTextField.setText("0");
		StaffWriter staffWriter = new StaffWriter(scrollPane, textPane, staff);
		StaffWriterToolbox.setStaffWriter(staffWriter);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(StaffGenUtilities.Colors.MENU_BAR_TEXT_COLOR);
		menuBar.setBackground(StaffGenUtilities.Colors.MENU_BAR_COLOR);
		frame.setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu(StaffGenGUIConstants.FILE_MENU_TEXT);
		fileMenu.setForeground(StaffGenUtilities.Colors.MENU_BAR_TEXT_COLOR);
		menuBar.add(fileMenu);
		FileMenuListener fileMenuListener = new FileMenuListener(frame,
				textPane);
		JMenuItem newMenuItem = new JMenuItem(
				StaffGenGUIConstants.NEW_MENU_TEXT);
		newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				InputEvent.CTRL_MASK));
		newMenuItem.setBackground(StaffGenUtilities.Colors.MENU_BAR_COLOR);
		newMenuItem.setForeground(StaffGenUtilities.Colors.MENU_BAR_TEXT_COLOR);
		newMenuItem.setActionCommand("new");
		newMenuItem.addActionListener(fileMenuListener);
		fileMenu.add(newMenuItem);
		JMenuItem exportMenuItem = new JMenuItem(
				StaffGenGUIConstants.EXPORT_MENU_TEXT);
		exportMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				InputEvent.CTRL_MASK));
		exportMenuItem.setBackground(StaffGenUtilities.Colors.MENU_BAR_COLOR);
		exportMenuItem
				.setForeground(StaffGenUtilities.Colors.MENU_BAR_TEXT_COLOR);
		exportMenuItem.setActionCommand("save");
		exportMenuItem.addActionListener(fileMenuListener);
		fileMenu.add(exportMenuItem);
		JMenuItem printMenuItem = new JMenuItem(
				StaffGenGUIConstants.PRINT_MENU_TEXT);
		printMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
				InputEvent.CTRL_MASK));
		printMenuItem.setBackground(StaffGenUtilities.Colors.MENU_BAR_COLOR);
		printMenuItem
				.setForeground(StaffGenUtilities.Colors.MENU_BAR_TEXT_COLOR);
		printMenuItem.setActionCommand("print");
		printMenuItem.addActionListener(fileMenuListener);
		fileMenu.add(printMenuItem);
		JMenuItem exitMenuItem = new JMenuItem(
				StaffGenGUIConstants.EXIT_MENU_TEXT);
		exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				InputEvent.CTRL_MASK));
		exitMenuItem.setBackground(StaffGenUtilities.Colors.MENU_BAR_COLOR);
		exitMenuItem
				.setForeground(StaffGenUtilities.Colors.MENU_BAR_TEXT_COLOR);
		exitMenuItem.setActionCommand("exit");
		exitMenuItem.addActionListener(fileMenuListener);
		fileMenu.add(exitMenuItem);
		JMenu staffMenu = new JMenu(StaffGenGUIConstants.STAFF_MENU_TEXT);
		staffMenu.setForeground(StaffGenUtilities.Colors.MENU_BAR_TEXT_COLOR);
		menuBar.add(staffMenu);
		StaffMenuListenerInputModel staffMenuListenerInputModel = new StaffMenuListenerInputModel();
		staffMenuListenerInputModel.setScrollBar(scrollPane
				.getVerticalScrollBar());
		staffMenuListenerInputModel.setTextPane(textPane);
		staffMenuListenerInputModel.setStaffWriter(staffWriter);
		JRadioButtonMenuItem trebleRadioMenuItem = new JRadioButtonMenuItem(
				StaffGenGUIConstants.TREBLE_RADIO_BTN_TEXT);
		trebleRadioMenuItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_T, InputEvent.CTRL_MASK));
		trebleRadioMenuItem.setSelected(true);
		trebleRadioMenuItem
				.setBackground(StaffGenUtilities.Colors.MENU_BAR_COLOR);
		trebleRadioMenuItem
				.setForeground(StaffGenUtilities.Colors.MENU_BAR_TEXT_COLOR);
		trebleRadioMenuItem.setActionCommand("trebleStaff");
		staffMenuListenerInputModel.setTrebleRadioMenuItem(trebleRadioMenuItem);
		trebleRadioMenuItem.addActionListener(new StaffMenuListener(
				staffMenuListenerInputModel));
		staffMenu.add(trebleRadioMenuItem);
		JRadioButtonMenuItem bassRadioMenuItem = new JRadioButtonMenuItem(
				StaffGenGUIConstants.BASS_RADIO_BTN_TEXT);
		bassRadioMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,
				InputEvent.CTRL_MASK));
		bassRadioMenuItem
				.setBackground(StaffGenUtilities.Colors.MENU_BAR_COLOR);
		bassRadioMenuItem
				.setForeground(StaffGenUtilities.Colors.MENU_BAR_TEXT_COLOR);
		bassRadioMenuItem.setActionCommand("bassStaff");
		staffMenuListenerInputModel.setBassRadioMenuItem(bassRadioMenuItem);
		bassRadioMenuItem.addActionListener(new StaffMenuListener(
				staffMenuListenerInputModel));
		staffMenu.add(bassRadioMenuItem);
		JRadioButtonMenuItem greatRadioMenuItem = new JRadioButtonMenuItem(
				StaffGenGUIConstants.GREAT_RADIO_BTN_TEXT);
		greatRadioMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,
				InputEvent.CTRL_MASK));
		greatRadioMenuItem
				.setBackground(StaffGenUtilities.Colors.MENU_BAR_COLOR);
		greatRadioMenuItem
				.setForeground(StaffGenUtilities.Colors.MENU_BAR_TEXT_COLOR);
		greatRadioMenuItem.setActionCommand("greatStaff");
		staffMenuListenerInputModel.setGreatRadioMenuItem(greatRadioMenuItem);
		greatRadioMenuItem.addActionListener(new StaffMenuListener(
				staffMenuListenerInputModel));
		staffMenu.add(greatRadioMenuItem);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(trebleRadioMenuItem);
		buttonGroup.add(bassRadioMenuItem);
		buttonGroup.add(greatRadioMenuItem);
		JButton recordBtn = new JButton("");
		recordBtn.setIcon(StaffGenUtilities.ImageIcons.BTN_REC);
		recordBtn.setDisabledIcon(StaffGenUtilities.ImageIcons.BTN_REC_PRESSED);
		recordBtn.setActionCommand(StaffGenUtilities.Commands.BTN_REC_COMMAND);
		JButton pauseBtn = new JButton("");
		pauseBtn.setIcon(StaffGenUtilities.ImageIcons.BTN_PAUSE);
		pauseBtn.setDisabledIcon(StaffGenUtilities.ImageIcons.BTN_PAUSE_PRESSED);
		pauseBtn.setActionCommand(StaffGenUtilities.Commands.BTN_PAUSE_COMMAND);
		pauseBtn.setEnabled(false);
		JButton playBtn = new JButton("");
		playBtn.setIcon(StaffGenUtilities.ImageIcons.BTN_PLAY);
		playBtn.setDisabledIcon(StaffGenUtilities.ImageIcons.BTN_PLAY_PRESSED);
		playBtn.setActionCommand(StaffGenUtilities.Commands.BTN_PLAY_COMMAND);
		playBtn.setEnabled(false);
		JButton stopBtn = new JButton("");
		stopBtn.setIcon(StaffGenUtilities.ImageIcons.BTN_STOP);
		stopBtn.setDisabledIcon(StaffGenUtilities.ImageIcons.BTN_STOP_PRESSED);
		stopBtn.setActionCommand(StaffGenUtilities.Commands.BTN_STOP_COMMAND);
		stopBtn.setEnabled(false);
		ControlButtonsListenerInputModel inputModel = new ControlButtonsListenerInputModel();
		inputModel.setScrollBar(scrollPane.getVerticalScrollBar());
		inputModel.setBpmTextField(bpmTextField);
		inputModel.setCurrBeatTextField(currBeatTextField);
		inputModel.setTextPane(textPane);
		inputModel.setRecordBtn(recordBtn);
		inputModel.setPauseBtn(pauseBtn);
		inputModel.setPlayBtn(playBtn);
		inputModel.setStopBtn(stopBtn);
		ControlButtonsListener controlButtonsListener = new ControlButtonsListener(
				inputModel);
		recordBtn.addActionListener(controlButtonsListener);
		pauseBtn.addActionListener(controlButtonsListener);
		playBtn.addActionListener(controlButtonsListener);
		stopBtn.addActionListener(controlButtonsListener);
		JPanel staffSheetNotesPanel = new JPanel();
		try {
			staffSheetNotesPanel = new ImagePanel(
					ImageIO.read(StaffGenUtilities.ImageUrls.STAFF_SHEET_NOTES));
		} catch (IOException e1) {
			int val = StaffGenUtilities.Messages
					.showErrorMsg("Staff Sheet Notes Image not found");
			if (val == 0) {
				System.exit(1);
			}
		}
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												scrollPane,
												(int) (screenWidth * ((float) 300 / 1366)),
												(int) (screenWidth * ((float) 655 / 1366)),
												Short.MAX_VALUE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																panel,
																screenWidth / 8,
																screenWidth / 8,
																Short.MAX_VALUE)
														.addComponent(
																staffSheetNotesPanel,
																screenWidth / 8,
																screenWidth / 8,
																Short.MAX_VALUE))
										.addContainerGap()));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																scrollPane,
																Alignment.TRAILING,
																GroupLayout.DEFAULT_SIZE,
																569,
																Short.MAX_VALUE)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				panel,
																				224,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				staffSheetNotesPanel,
																				GroupLayout.DEFAULT_SIZE,
																				347,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		JLabel metronomeLabel = new JLabel(
				StaffGenGUIConstants.METRONOME_LABEL_VAL);
		metronomeLabel.setForeground(StaffGenUtilities.Colors.TEXT_COLOR);
		metronomeLabel.setFont(new Font(
				StaffGenGUIConstants.METRONOME_PANEL_FONT, Font.BOLD
						| Font.ITALIC, 36));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING, false)
												.addComponent(metronomeLabel)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		enterBpmLabel)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		bpmTextField,
																		GroupLayout.PREFERRED_SIZE,
																		48,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		bpmLabel))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		currentBeatLabel)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		currBeatTextField,
																		GroupLayout.PREFERRED_SIZE,
																		75,
																		GroupLayout.PREFERRED_SIZE))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		recordBtn,
																		GroupLayout.PREFERRED_SIZE,
																		48,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(
																		pauseBtn,
																		GroupLayout.PREFERRED_SIZE,
																		48,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(
																		playBtn,
																		GroupLayout.PREFERRED_SIZE,
																		48,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(
																		stopBtn,
																		GroupLayout.PREFERRED_SIZE,
																		48,
																		GroupLayout.PREFERRED_SIZE)))
								.addGap(81)));
		gl_panel.setVerticalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.TRAILING)
												.addGroup(
														gl_panel.createParallelGroup(
																Alignment.BASELINE)
																.addComponent(
																		bpmTextField,
																		GroupLayout.PREFERRED_SIZE,
																		21,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(
																		bpmLabel))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		metronomeLabel)
																.addPreferredGap(
																		ComponentPlacement.UNRELATED)
																.addComponent(
																		enterBpmLabel)))
								.addGap(17)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(currentBeatLabel)
												.addComponent(
														currBeatTextField,
														GroupLayout.PREFERRED_SIZE,
														38,
														GroupLayout.PREFERRED_SIZE))
								.addGap(35)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING, false)
												.addComponent(stopBtn, 0, 0,
														Short.MAX_VALUE)
												.addComponent(playBtn, 0, 0,
														Short.MAX_VALUE)
												.addComponent(pauseBtn, 0, 0,
														Short.MAX_VALUE)
												.addComponent(
														recordBtn,
														GroupLayout.PREFERRED_SIZE,
														49, Short.MAX_VALUE))
								.addContainerGap(23, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
		frame.pack();
		frame.setBounds(0, 0, screenWidth, screeHeight);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Gets the frame.
	 * 
	 * @return the frame
	 */
	public JFrame getFrame() {
		return this.frame;
	}
}
