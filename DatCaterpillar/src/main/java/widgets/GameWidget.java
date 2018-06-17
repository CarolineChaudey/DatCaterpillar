/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package widgets;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import ej.microui.display.GraphicsContext;
import ej.microui.display.Image;
import ej.microui.event.Event;
import ej.microui.event.generator.Pointer;
import ej.style.Style;
import ej.style.container.Rectangle;
import ej.widget.StyledWidget;
import models.Caterpillar;
import models.Member;
import models.Orientation;

/**
 *
 */
public class GameWidget extends StyledWidget {

	private Image caterMemberDown;
	private Image caterMemberUp;
	private Image caterMemberLeft;
	private Image caterMemberRight;
	private Image gerard;
	private Image memberImg;

	private final Caterpillar caterpillar = new Caterpillar();
	private Member member;

	private Orientation currentOrientation;

	private GraphicsContext myG;
	int firstX = 0;
	int firstY = 0;
	private final Timer timer = new Timer();
	private final String BASE_IMAGE = "/images/";

	/**
	 *
	 */
	public GameWidget() {
		super();

		try {
			this.caterMemberDown = Image.createImage(this.BASE_IMAGE + "catPieceDown.png");
			this.caterMemberUp = Image.createImage(this.BASE_IMAGE + "catPieceUp.png");
			this.caterMemberLeft = Image.createImage(this.BASE_IMAGE + "catPieceLeft.png");
			this.caterMemberRight = Image.createImage(this.BASE_IMAGE + "catPieceRight.png");
			this.gerard = this.caterMemberDown;
			this.memberImg = Image.createImage(this.BASE_IMAGE + "point.png");

			this.timer.scheduleAtFixedRate(new TimerTask() {
				@Override
				public void run() {
					moveForward();
					repaint();
					if (touchBorder()) {
						this.cancel();
					}
				}
			}, 500, 500);

		} catch (IOException e) {
			System.out.println("Image not found.");
		}

	}

	private void moveForward() {
		switch (this.caterpillar.orientation) {
		case LEFT:
			this.caterpillar.positionX -= 10;
			this.gerard = this.caterMemberLeft;
			break;
		case RIGHT:
			this.caterpillar.positionX += 10;
			this.gerard = this.caterMemberRight;
			break;
		case UP:
			this.caterpillar.positionY -= 10;
			this.gerard = this.caterMemberUp;
			break;
		case DOWN:
			this.caterpillar.positionY += 10;
			this.gerard = this.caterMemberDown;
			break;
		default:
			break;
		}
	}

	private boolean touchBorder() {
		System.out.println("x: " + this.caterpillar.positionX + " y: " + this.caterpillar.positionY);
		if ((this.caterpillar.positionX < 0) || (this.caterpillar.positionY < 0)
				|| ((this.caterpillar.positionX + this.gerard.getWidth()) > getWidth())
				|| (this.caterpillar.positionY + this.gerard.getHeight()) > getHeight()) {
			return true;
		}
		return false;
	}

	@Override
	public void renderContent(GraphicsContext g, Style style, Rectangle bounds) {
		if (this.member == null) {
			createMember(g);
		}
		// draw the guy to fetch
		g.drawImage(this.member.getImage(), this.member.getPositionX(), this.member.getPositionY(),
				GraphicsContext.TOP | GraphicsContext.LEFT);
		// draw gerard, head of the caterpillar
		g.drawImage(this.gerard, this.caterpillar.positionX, this.caterpillar.positionY,
				GraphicsContext.TOP | GraphicsContext.LEFT);
	}

	private void createMember(GraphicsContext g) {
		Random rand = new Random();

		int maxX = getWidth() - this.memberImg.getWidth();
		int maxY = getHeight() - this.memberImg.getHeight();
		System.out.println("maxX= " + getWidth());
		System.out.println("maxY= " + getHeight());

		int memberX = rand.nextInt(maxX);
		int memberY = rand.nextInt(maxY);
		System.out.println("memebrX= " + memberX);
		System.out.println("memberY= " + memberY);

		this.member = new Member(this.memberImg, memberX, memberY);
	}

	@Override
	public Rectangle validateContent(Style style, Rectangle bounds) {
		// TODO Auto-generated method stub
		return bounds;
	}

	@Override
	public boolean handleEvent(int event) {
		if (Event.getType(event) == Event.POINTER) {
			Pointer pointer = (Pointer) Event.getGenerator(event);
			// this.animated = false;

			if (Pointer.isPressed(event)) {

				this.firstX = pointer.getAbsoluteX();
				this.firstY = pointer.getAbsoluteY();

			}

			if (Pointer.isReleased(event)) {
				int ratioX = pointer.getAbsoluteX() - this.firstX;
				int ratioY = pointer.getAbsoluteY() - this.firstY;
				// System.out.println(absolute(ratioX) + " " + absolute(ratioY));
				if (absolute(ratioX) < absolute(ratioY)) {
					if (ratioY < 0) {
						this.caterpillar.orientation = Orientation.UP;
					} else if (ratioY > 0) {
						this.caterpillar.orientation = Orientation.DOWN;
					}
				} else if (absolute(ratioX) > absolute(ratioY)) {
					if (ratioX < 0) {
						this.caterpillar.orientation = Orientation.LEFT;
					} else if (ratioX > 0) {
						this.caterpillar.orientation = Orientation.RIGHT;
					}
				}

			}

		}

		return super.handleEvent(event);
	}

	private int absolute(int val) {
		if (val < 0) {
			val *= -1;
		}
		return val;
	}

	/**
	 * Gets the timer.
	 *
	 * @return the timer.
	 */
	public Timer getTimer() {
		return this.timer;
	}

}
