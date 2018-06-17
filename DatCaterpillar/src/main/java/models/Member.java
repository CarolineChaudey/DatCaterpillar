/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package models;

import ej.microui.display.Image;

/**
 *
 */
@SuppressWarnings("javadoc")
public class Member {
	protected int positionX = 0;
	protected int positionY = 0;
	protected Image image;

	/**
	 *
	 */
	public Member(Image img) {
		super();
		this.image = img;
	}

	/**
	 * @param img
	 * @param x
	 * @param y
	 */
	public Member(Image img, int x, int y) {
		super();
		this.image = img;
		this.positionX = x;
		this.positionY = y;
	}

	/**
	 * Gets the positionX.
	 *
	 * @return the positionX.
	 */
	public int getPositionX() {
		return this.positionX;
	}

	/**
	 * Gets the positionY.
	 *
	 * @return the positionY.
	 */
	public int getPositionY() {
		return this.positionY;
	}

	/**
	 * Gets the image.
	 *
	 * @return the image.
	 */
	public Image getImage() {
		return this.image;
	}

}
