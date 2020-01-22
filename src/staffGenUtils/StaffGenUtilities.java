/*
 * @package: staffGenUtils
 * @file: StaffGenUtilities.java
 *
 * @author: Himanshu Babbar
 *
 * Copyright (C) 2013. All rights reserved.
 */
package staffGenUtils;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * The Class StaffGenUtilities contains constants, methods and classes for
 * providing basic functionalities in StaffGen.
 */
public class StaffGenUtilities {
	/**
	 * The Class ImageIcons.
	 */
	public static class ImageIcons {
		/** The Constant BTN_REC. */
		public static final ImageIcon BTN_REC = getBtnIcn("/resources/icons/icn_record.jpg");
		/** The Constant BTN_PAUSE. */
		public static final ImageIcon BTN_PAUSE = getBtnIcn("/resources/icons/icn_pause.jpg");
		/** The Constant BTN_PLAY. */
		public static final ImageIcon BTN_PLAY = getBtnIcn("/resources/icons/icn_play.jpg");
		/** The Constant BTN_STOP. */
		public static final ImageIcon BTN_STOP = getBtnIcn("/resources/icons/icn_stop.jpg");
		/** The Constant BTN_REC_PRESSED. */
		public static final ImageIcon BTN_REC_PRESSED = getBtnIcn("/resources/icons/icn_record_pressed.jpg");
		/** The Constant BTN_PAUSE_PRESSED. */
		public static final ImageIcon BTN_PAUSE_PRESSED = getBtnIcn("/resources/icons/icn_pause_pressed.jpg");
		/** The Constant BTN_PLAY_PRESSED. */
		public static final ImageIcon BTN_PLAY_PRESSED = getBtnIcn("/resources/icons/icn_play_pressed.jpg");
		/** The Constant BTN_STOP_PRESSED. */
		public static final ImageIcon BTN_STOP_PRESSED = getBtnIcn("/resources/icons/icn_stop_pressed.jpg");

		/**
		 * Gets the buttonn iconn.
		 * 
		 * @param url
		 *            the url
		 * @return the button icon
		 */
		private static ImageIcon getBtnIcn(String url) {
			URL btnIconLocation = StaffGenUtilities.class.getResource(url);
			ImageIcon imageIcon = new ImageIcon(btnIconLocation);
			return imageIcon;
		}
	}

	/**
	 * The Class ImageUrls.
	 */
	public static class ImageUrls {
		/** The Constant TITLE_IMAGE. */
		public static final URL TITLE_IMAGE = StaffGenUtilities.class
				.getResource("/resources/icons/TitleImage.png");
		/** The Constant IMAGE_ICON_FRAME. */
		public static final URL IMAGE_ICON_FRAME = StaffGenUtilities.class
				.getResource("/resources/icons/StaffGenIcon.png");
		/** The Constant WOODEN_PANEL. */
		public static final URL WOODEN_PANEL = StaffGenUtilities.class
				.getResource("/resources/icons/BackgroundPanel.png");
		/** The Constant TEXT_PANEL. */
		public static final URL TEXT_PANEL = StaffGenUtilities.class
				.getResource("/resources/icons/MetronomePanel.png");
		/** The Constant PARCHMENT_PAPER. */
		public static final URL PARCHMENT_PAPER = StaffGenUtilities.class
				.getResource("/resources/icons/StaffSheet.png");
		/** The Constant STAFF_SHEET_NOTES. */
		public static final URL STAFF_SHEET_NOTES = StaffGenUtilities.class
				.getResource("/resources/icons/StaffSheetNotes.png");
	}

	/**
	 * The Class Commands.
	 */
	public static class Commands {
		/** The Constant BTN_REC_COMMAND. */
		public static final String BTN_REC_COMMAND = "record";
		/** The Constant BTN_PAUSE_COMMAND. */
		public static final String BTN_PAUSE_COMMAND = "pause";
		/** The Constant BTN_STOP_COMMAND. */
		public static final String BTN_STOP_COMMAND = "stop";
		/** The Constant BTN_PLAY_COMMAND. */
		public static final String BTN_PLAY_COMMAND = "play";
		/** The pause pressed. */
		public static boolean PAUSE_PRESSED = false;
	}

	/**
	 * The Class Colors.
	 */
	public static class Colors {
		/** The Constant MAIN_BACKGROUND_COLOR. */
		public static final Color MAIN_BACKGROUND_COLOR = new Color(61, 0, 0);
		/** The Constant TEXT_BACKGROUND_COLOR. */
		public static final Color TEXT_BACKGROUND_COLOR = new Color(255, 255,
				218);
		/** The Constant TEXT_COLOR. */
		public static final Color TEXT_COLOR = new Color(61, 0, 0);
		/** The Constant MENU_BAR_COLOR. */
		public static final Color MENU_BAR_COLOR = new Color(37, 18, 18);
		/** The Constant MENU_BAR_TEXT_COLOR. */
		public static final Color MENU_BAR_TEXT_COLOR = new Color(255, 255, 218);
		/** The Constant PROGRESS_BAR_COLOR. */
		public static final Color PROGRESS_BAR_COLOR = new Color(34, 0, 0);
		/** The Constant WHITE. */
		public static final Color WHITE = new Color(255, 255, 255);
	}

	/**
	 * The Class Clefs.
	 */
	public static class Clefs {
		/** The Constant TREBLE_CLEF. */
		public static final String TREBLE_CLEF = generateTrebleClef();
		/** The Constant BASS_CLEF. */
		public static final String BASS_CLEF = generateBassClef();

		/**
		 * Generate treble clef.
		 * 
		 * @return the string
		 */
		private static String generateTrebleClef() {
			char[] bassClef = new char[2];
			bassClef[0] = (char) 39;
			bassClef[1] = (char) 38;
			StringBuffer sb = new StringBuffer();
			sb.append(bassClef[0]);
			sb.append(bassClef[1]);
			return sb.toString();
		}

		/**
		 * Generate bass clef.
		 * 
		 * @return the string
		 */
		private static String generateBassClef() {
			char[] bassClef = new char[2];
			bassClef[0] = (char) 39;
			bassClef[1] = (char) 175;
			StringBuffer sb = new StringBuffer();
			sb.append(bassClef[0]);
			sb.append(bassClef[1]);
			return sb.toString();
		}
	}

	/**
	 * The Class PaperSize.
	 */
	public static class PaperSize {
		/** The Constant PAPER_WIDTH. */
		public static final int PAPER_WIDTH = 612;
		/** The Constant PAPER_HEIGHT. */
		public static final int PAPER_HEIGHT = 792;
	}

	/**
	 * The Class TimeSignature.
	 */
	public static class TimeSignature {
		/** The Constant FOUR_BY_FOUR. */
		public static final String FOUR_BY_FOUR = "4!";
		/** The Constant THREE_BY_FOUR. */
		public static final String THREE_BY_FOUR = "3!";
	}

	/**
	 * The Class StaffFont.
	 */
	public static class StaffFont {
		/** The Constant MUSIC_FONT. */
		public static final Font MUSIC_FONT = getFont();

		/**
		 * Gets the font.
		 * 
		 * @return the font
		 */
		private static Font getFont() {
			URL fontLocation = StaffGenUtilities.class
					.getResource("/resources/font/MusiQwik-Bold.ttf");
			Font font = null;
			try {
				font = Font.createFont(Font.TRUETYPE_FONT,
						fontLocation.openStream());
				GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment
						.getLocalGraphicsEnvironment();
				graphicsEnvironment.registerFont(font);
			} catch (FontFormatException e) {
				int val = StaffGenUtilities.Messages
						.showErrorMsg("Unable to get Music Notation Font");
				if (val == 0) {
					System.exit(1);
				}
			} catch (IOException e) {
				int val = StaffGenUtilities.Messages
						.showErrorMsg("Unable to get Music Notation Font");
				if (val == 0) {
					System.exit(1);
				}
			}
			int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize()
					.getWidth();
			float fontSize = (float) (screenWidth * ((float) 40 / 1366));
			return font.deriveFont(fontSize);
		}
	}

	/**
	 * The Class Messages.
	 */
	public static class Messages {
		/**
		 * Show error msg.
		 * 
		 * @param msg
		 *            the msg
		 * @return the int
		 */
		public static int showErrorMsg(String msg) {
			int val = -1;
			Object[] options = { "OK" };
			val = JOptionPane.showOptionDialog(null, msg, "Message",
					JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
					null, options, options[0]);
			return val;
		}

		/**
		 * Show info msg.
		 * 
		 * @param msg
		 *            the msg
		 * @return the int
		 */
		public static int showInfoMsg(String msg) {
			int val = -1;
			Object[] options = { "OK" };
			val = JOptionPane.showOptionDialog(null, msg, "Message",
					JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
			return val;
		}
	}
}
