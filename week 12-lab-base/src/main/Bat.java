package main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import util.ImageLoader;

public class Bat {
	private int posX, posY;
 	private Color c;
 	private BufferedImage batImg;
 	private Rectangle bound;

	//declare field for bat image and name it: batImg
	
	//declare field clip bound and name it: bound
	
	public Bat(int posX, Color c, String fileName) {
		this.posX = posX;
		posY = PongPanel.WIN_H / 2;
		
		try {
			batImg = ImageIO.read(getClass().getResourceAsStream("/assets/"+fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bound = new Rectangle();
 		//load the bat image from assets folder

		//get the Graphics object from the image
		//set the clip bound using its position and its width, height by calling their getter methods
  
		//return the clip bound and use it to initialize the bound field
		 
		setBatLocation();
	}

	public void move(double ys) {
		posY += ys;
		
		if (posY - bound.getHeight() / 2 < 0) {
			posY = (int) bound.getHeight() / 2;
		}
		if (posY + bound.getHeight() / 2 > PongPanel.WIN_H) {
			posY = (int) (PongPanel.WIN_H - bound.getHeight() / 2);
		}
	}

	public void drawMe(Graphics2D g2) {
		g2.drawImage(batImg, posX - batImg.getWidth(null) / 2,
				posY - batImg.getHeight(null) / 2, null);
		g2.setColor(c);
		setBatLocation();

	}

	public void drawMe(Graphics2D g2, int y) {
		g2.drawImage(batImg, posX - batImg.getWidth(null) / 2, y, null);
		g2.setColor(c);
		setBatLocation(y);

	}

	private void setBatLocation() {
		bound.setFrame(posX - batImg.getWidth(null) / 2,
				posY - batImg.getHeight(null) / 2, batImg.getWidth(null),
				batImg.getHeight(null));
	}

	private void setBatLocation(int y) {
		bound.setFrame(posX - batImg.getWidth(null) / 2, y,
				batImg.getWidth(null), batImg.getHeight(null));
	}

	public boolean hitBall(BouncingBall b) {

		return bound.intersects(b.getBound());

	}

	public Rectangle getBound(){
		return bound;
	}
}