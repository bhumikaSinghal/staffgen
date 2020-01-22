/*
 * @package: staffGenGUI
 * @file: ImagePanel.java
 *
 * @author: Himanshu Babbar
 *
 * Copyright (C) 2013. All rights reserved.
 */
package staffGenGUI;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

/**
 * The Class ImagePanel.
 */
public class ImagePanel extends JPanel {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	/** The image. */
	private Image image;

	/**
	 * Instantiates a new image panel.
	 * 
	 * @param image
	 *            the image
	 */
	public ImagePanel(Image image) {
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