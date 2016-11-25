package main;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import util.ImageLoader;

import java.awt.Image;

public class BouncingBall {
	private int changeX, changeY; // attributes
	private final int MOVE_LEN = 5;
	private final int radius;
	public int posX, posY;
	private BufferedImage ballImg;
	private Rectangle bound;
	private int rot;
	//declare field for ball image with name ballImg
	//declare the clip bound as a Rectangle with name bound
	
	
	public BouncingBall() {
		posX = 100;
		posY = 100;
		changeX = MOVE_LEN;
		changeY = MOVE_LEN;
		try {
			ballImg = ImageIO.read(getClass().getResourceAsStream("/assets/ball.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		radius = ballImg.getWidth()/2;
		
		//return the ballImg's width and use HALF of it to initialize radius
 		
		//get the graphics object from ballImg
		Graphics g = ballImg.getGraphics();
		 
		//set it's clip bound using position and radius
		g.setClip(posX-radius, posY-radius, ballImg.getWidth(), ballImg.getHeight());
		//return the clip bound and use it to initialise bound
		bound = g.getClipBounds();
		rot = 0;
				
		setBoundLocation();
		
	}

	public void move() {
		posX += changeX;
		posY += changeY;
	}

	public void drawMe(Graphics2D g2) {
		
		AffineTransform old = g2.getTransform();
		rot++;
		g2.translate(posX, posY);
		g2.rotate(rot);
		g2.drawImage(ballImg, -radius, -radius, null);
		g2.setTransform(old);
		
		setBoundLocation();
		
	}

	private void setBoundLocation() {
		bound.setFrame(posX-radius, posY-radius, ballImg.getWidth(null), ballImg.getHeight(null));
	}
	
	public String walls() {
		if (posX - radius < 0) {
			posX = radius;
			changeX *= -1;
			return "blue";
		}
		if (posX + radius > PongPanel.WIN_W) {
			posX = PongPanel.WIN_W - radius;
			changeX *= -1;
			return "orange";
		}

		if (posY - radius < 0) {
			posY = radius;
			changeY *= -1;
		}
		if (posY + radius > PongPanel.WIN_H) {
			posY = PongPanel.WIN_H - radius;
			changeY *= -1;
		}
		return "";
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public void reverseChangeX(Bat b) {
	
		changeX *= -1;
	}

	public Rectangle getBound() {
		return bound;
	}
}
