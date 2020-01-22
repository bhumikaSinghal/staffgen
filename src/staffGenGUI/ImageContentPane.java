/*
 * @package: staffGenGUI
 * @file: ImageContentPane.java
 *
 * @author: Himanshu Babbar
 *
 * Copyright (C) 2013. All rights reserved.
 */
package staffGenGUI;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JComponent;

/**
 * The Class ImageContentPane.
 */
public class ImageContentPane extends JComponent {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	/** The image. */
	private Image image;

	/**
	 * Instantiates a new image content pane.
	 * 
	 * @param image
	 *            the image
	 */
	public ImageContentPane(Image image) {
		this.image = image;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}
}