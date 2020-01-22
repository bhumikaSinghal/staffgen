/*
 * @package: staffGenGUI
 * @file: ImageTextPane.java
 *
 * @author: Himanshu Babbar
 *
 * Copyright (C) 2013. All rights reserved.
 */
package staffGenGUI;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTextPane;

/**
 * The Class ImageTextPane.
 */
public class ImageTextPane extends JTextPane {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	/** The image. */
	private Image image;

	/**
	 * Instantiates a new image text pane.
	 * 
	 * @param image
	 *            the image
	 */
	public ImageTextPane(Image image) {
		this.image = image;
		setOpaque(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		super.paintComponent(g);
	}
}