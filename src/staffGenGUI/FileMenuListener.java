/*
 * @package: staffGenGUI
 * @file: FileMenuListener.java
 *
 * @author: Himanshu Babbar
 *
 * Copyright (C) 2013. All rights reserved.
 */
package staffGenGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextPane;

import staffGenUtils.StaffGenUtilities;
import staffWriterToolbox.Staff;
import staffWriterToolbox.StaffWriterToolbox;

/**
 * The Class FileMenuListener is the action listener for the items in the File
 * menu.
 */
public class FileMenuListener implements ActionListener, Printable {
	/** The page breaks. */
	private int[] pageBreaks;
	/** The upper bar display list. */
	private List<String> upperBarDisplayList;
	/** The middle bar display list. */
	private List<String> middleBarDisplayList;
	/** The lower bar display list. */
	private List<String> lowerBarDisplayList;
	/** The frame. */
	private JFrame frame;
	/** The text pane. */
	private JTextPane textPane;
	/** The font. */
	private Font font;

	/**
	 * Instantiates a new file menu listener.
	 */
	public FileMenuListener() {
		this.font = StaffGenUtilities.StaffFont.MUSIC_FONT.deriveFont(30f);
	}

	/**
	 * Instantiates a new file menu listener.
	 * 
	 * @param frame
	 *            the frame
	 * @param textPane
	 *            the text pane
	 */
	public FileMenuListener(JFrame frame, JTextPane textPane) {
		this.frame = frame;
		this.font = StaffGenUtilities.StaffFont.MUSIC_FONT.deriveFont(30f);
		this.textPane = textPane;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("new")) {
			StaffWriterToolbox.populateTextPane(textPane);
		} else if (e.getActionCommand().equals("save")) {
			saveImage();
		} else if (e.getActionCommand().equals("print")) {
			PrinterJob job = PrinterJob.getPrinterJob();
			job.setPrintable(this);
			setDisplayLists();
			boolean ok = job.printDialog();
			if (ok) {
				try {
					job.print();
				} catch (PrinterException ex) {
					StaffGenUtilities.Messages.showErrorMsg("Printer error");
				}
			}
		} else if (e.getActionCommand().equals("exit")) {
			frame.dispose();
			System.exit(0);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.print.Printable#print(java.awt.Graphics,
	 * java.awt.print.PageFormat, int)
	 */
	@Override
	public int print(Graphics g, PageFormat pf, int pageIndex)
			throws PrinterException {
		FontMetrics fontMetrics = g.getFontMetrics(font);
		int lineHeight = fontMetrics.getHeight();
		if (pageBreaks == null) {
			int linesPerPage = (int) (pf.getImageableHeight() / lineHeight);
			int numBreaks = (3 * (middleBarDisplayList.size()) - 1)
					/ linesPerPage;
			pageBreaks = new int[numBreaks];
			for (int b = 0; b < numBreaks; b++) {
				pageBreaks[b] = (b + 1) * linesPerPage;
			}
		}
		if (pageIndex > pageBreaks.length) {
			return NO_SUCH_PAGE;
		}
		Graphics2D translatedGraphics = (Graphics2D) g;
		translatedGraphics.translate(pf.getImageableX(), pf.getImageableY());
		g.setFont(font);
		int y = 0;
		int start = (pageIndex == 0) ? 0 : pageBreaks[pageIndex - 1];
		int end = (pageIndex == pageBreaks.length) ? 3 * (middleBarDisplayList
				.size()) : pageBreaks[pageIndex];
		for (int line = (start / 3); line < (end / 3); line++) {
			y += lineHeight;
			g.drawString(upperBarDisplayList.get(line), 50, y);
			y += lineHeight;
			g.drawString(middleBarDisplayList.get(line), 50, y);
			y += lineHeight;
			g.drawString(lowerBarDisplayList.get(line), 50, y);
		}
		return PAGE_EXISTS;
	}

	/**
	 * Saves the staff as an image.
	 */
	private void saveImage() {
		setDisplayLists();
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int valueSelected = fileChooser.showSaveDialog(frame);
		if (valueSelected == JFileChooser.APPROVE_OPTION) {
			File location = fileChooser.getSelectedFile();
			File staffSheetsDir = new File(location + "//Staff Sheets");
			staffSheetsDir.mkdir();
			int w = StaffGenUtilities.PaperSize.PAPER_WIDTH;
			int h = StaffGenUtilities.PaperSize.PAPER_HEIGHT;
			Paper p = new Paper();
			p.setSize(w, h);
			p.setImageableArea(0, 0, w, h);
			PageFormat pf = new PageFormat();
			pf.setPaper(p);
			BufferedImage image = new BufferedImage(w, h,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D imageG2D = image.createGraphics();
			imageG2D.setColor(Color.WHITE);
			imageG2D.fillRect(0, 0, w, h);
			imageG2D.setColor(Color.BLACK);
			imageG2D.setFont(font);
			FontMetrics metrics = imageG2D.getFontMetrics(font);
			int lineHeight = metrics.getHeight();
			int[] pageBreaks = null;
			if (pageBreaks == null) {
				int linesPerPage = (int) (pf.getImageableHeight() / lineHeight);
				int numBreaks = (3 * (middleBarDisplayList.size()) - 1)
						/ linesPerPage;
				pageBreaks = new int[numBreaks];
				for (int b = 0; b < numBreaks; b++) {
					pageBreaks[b] = (b + 1) * linesPerPage;
				}
			}
			for (int pageIndex = 0; pageIndex < (pageBreaks.length + 1); pageIndex++) {
				if (pageIndex > 0) {
					image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
					imageG2D = image.createGraphics();
					imageG2D.setColor(Color.WHITE);
					imageG2D.fillRect(0, 0, w, h);
					imageG2D.setColor(Color.BLACK);
					imageG2D.setFont(font);
				}
				int y = 0;
				int start = (pageIndex == 0) ? 0 : pageBreaks[pageIndex - 1];
				int end = (pageIndex == pageBreaks.length) ? 3 * (middleBarDisplayList
						.size()) : pageBreaks[pageIndex];
				for (int line = (start / 3); line < (end / 3); line++) {
					y += lineHeight;
					imageG2D.drawString(upperBarDisplayList.get(line), 50, y);
					y += lineHeight;
					imageG2D.drawString(middleBarDisplayList.get(line), 50, y);
					y += lineHeight;
					imageG2D.drawString(lowerBarDisplayList.get(line), 50, y);
				}
				if (staffSheetsDir != null) {
					StringBuilder fileName = new StringBuilder();
					fileName.append(staffSheetsDir).append("//Staff Sheet")
							.append((pageIndex + 1)).append(".png");
					File newFile = new File(fileName.toString());
					try {
						ImageIO.write(image, "png", newFile);
					} catch (IOException e) {
						int val = StaffGenUtilities.Messages
								.showErrorMsg("Image file creation error");
						if (val == 0) {
							staffSheetsDir.delete();
						}
					}
				}
			}
		} else {
		}
	}

	/**
	 * Sets the display lists to be printed.
	 */
	private void setDisplayLists() {
		Staff staff = StaffWriterToolbox.getStaffWriter().getStaff();
		this.upperBarDisplayList = staff.getUpperBarDisplayList();
		this.middleBarDisplayList = staff.getMiddleBarDisplayList();
		this.lowerBarDisplayList = staff.getLowerBarDisplayList();
	}
}
