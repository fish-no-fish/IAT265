package movingobjects;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import static java.lang.Math.*;

public abstract class MovingObjects {
	protected double posx;
	protected double posy;
	protected double velx;
	protected double vely;
	protected double width;
	protected double height;
	protected BufferedImage avatar;
	protected double angle;
	

	protected float initialOpacity;
	protected AlphaComposite opacity;
	protected AffineTransform old;
	protected Composite oldC;
	protected double oldX, oldY;
	
	public MovingObjects(double posx, double posy)
	{
		this.posx = posx;
		this.posy = posy;
		initialOpacity = 0;
	}

	public boolean handleCollision(MovingObjects target)
	{
		if (Math.abs(posx - target.posx) <= width/2 + target.width/2 && Math.abs(posy - target.posy) <= height/2 + target.height/2)
		{
			return true;
		}
		return false;
	}
	
	public void appear()
	{
		if (initialOpacity != 1)
		{
			initialOpacity += 0.05;
		}
		if (initialOpacity > 1)
		{
			initialOpacity = 1;
		}
	}
	
	public abstract void draw(Graphics2D g2);
	
	public double dist(MovingObjects target)
	{
		return sqrt((abs(posx-target.posx)*abs(posx-target.posx))+
				(abs(posy-target.posy)*abs(posy-target.posy)));
	}
	
	public void setPos(double x, double y)
	{
		posx = x;
		posy = y;
	}
	
	public double getW()
	{
		return width;
	}
	public double getH()
	{
		return height;
	}
	
	public double getX()
	{
		return posx;
	}
	
	public double getY()
	{
		return posy;
	}
	public void setAngle(double theta)
	{
		angle = Math.toRadians(theta);
	}

	/**
	 * @return the oldY
	 */
	public double getOldY() {
		return oldY;
	}

	/**
	 * @param oldY the oldY to set
	 */
	public void setOldY(double oldY) {
		this.oldY = oldY;
	}

	/**
	 * @return the oldX
	 */
	public double getOldX() {
		return oldX;
	}

	/**
	 * @param oldX the oldX to set
	 */
	public void setOldX(double oldX) {
		this.oldX = oldX;
	}
}
