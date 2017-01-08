package movingobjects;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import sound.Sound;

import static java.lang.Math.*;

/* MOVINGOBJECTS class. The base class for all objects that move in this application. Provides basic
 * 	object interactions and object movement
 * CREATED: 11/10/2016
 * AUTHOR: HENRY ZHAO*/
public abstract class MovingObjects {
	protected double posx; //x position
	protected double posy; //y position
	protected double width; //width of object
	protected double height; //height of object
	protected BufferedImage avatar; //base image to be displayed by the object
	protected double angle; //angle to rotate the base image
	
	protected float initialOpacity; //initial opacity value when the object first appears
	protected AlphaComposite opacity; //opacity object to be used via composite based on initialOpacity
	protected AffineTransform old; //default old transformation to restore to
	protected Composite oldC; //default old composite to restore to
	protected double oldX, oldY; //The positions stored on the first mouse click during drag
	
	/* WHAT IT DOES: Default constructor for all movingobjects objects. Sets default positions and initial opacity
	 * PARAMETERS:
	 * 	posx - position x
	 * 	posy - position y 
	 * RETURN: NONE*/
	public MovingObjects(double posx, double posy)
	{
		this.posx = posx;
		this.posy = posy;
		initialOpacity = 0;
	}
	
	/* WHAT IT DOES: Handles and detects collisions between objects 
	 * PARAMETERS: 
	 * 	target - the other MovingObjects object that the calling object is colliding with
	 * RETURN: Boolean - whether there was a collision*/
	public boolean handleCollision(MovingObjects target)
	{
		if (Math.abs(posx - target.posx) <= width/2 + target.width/2 && Math.abs(posy - target.posy) <= height/2 + target.height/2)
		{
			return true;
		}
		return false;
	}
	
	/* WHAT IT DOES: Handles fading in of images, where opacity is used 
	 * PARAMETERS: NONE
	 * RETURN: NONE*/
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
	
	/* WHAT IT DOES: Abstract draw method for various objects 
	 * PARAMETERS: 
	 * 	g2 - Graphics2D brush
	 * RETURN: NONE*/
	public abstract void draw(Graphics2D g2);
	
	/* WHAT IT DOES: Calculates distance from one object to another from their center point 
	 * PARAMETERS: 
	 * 	target - target object to measure with
	 * RETURN: Double - the distance*/
	public double dist(MovingObjects target)
	{
		return sqrt((abs(posx-target.posx)*abs(posx-target.posx))+
				(abs(posy-target.posy)*abs(posy-target.posy)));
	}
	
	/* WHAT IT DOES: Calculates distance from one object to a box, usually a hitbox 
	 * PARAMETERS: 
	 * 	box - target box to measure with
	 * RETURN: Double - the distance*/
	public double distOfBox(Rectangle2D.Double box)
	{
		return sqrt((abs(posx-box.getX())*abs(posx-box.getX()))+
				(abs(posy-box.getY())*abs(posy-box.getY())));
	}
	
	/* WHAT IT DOES: Setter method for position values 
	 * PARAMETERS: 
	 * 	x - desired x coordinate
	 * 	y - desired y coordinate
	 * RETURN: NONE*/
	public void setPos(double x, double y)
	{
		posx = x;
		posy = y;
	}
	
	/* WHAT IT DOES: Getter method for varialbe width 
	 * PARAMETERS: NONE
	 * RETURN: Returns the object's width*/
	public double getW()
	{
		return width;
	}
	
	/* WHAT IT DOES:Getter method for object's Height 
	 * PARAMETERS: NONE
	 * RETURN: Object's height*/
	public double getH()
	{
		return height;
	}
	
	/* WHAT IT DOES: Getter method for position x 
	 * PARAMETERS: NONE
	 * RETURN: Object's x position*/
	public double getX()
	{
		return posx;
	}
	
	/* WHAT IT DOES: Getter method for position y 
	 * PARAMETERS: NONE
	 * RETURN: Object's y position*/
	public double getY()
	{
		return posy;
	}
	
	/* WHAT IT DOES: Setter method for variable angle 
	 * PARAMETERS: 
	 * 	theta - the desired angle
	 * RETURN: NONE*/
	public void setAngle(double theta)
	{
		angle = theta;
	}

	/* WHAT IT DOES: Getter method for object's OldY position 
	 * PARAMETERS: NONE
	 * RETURN: Object's OldY value*/
	public double getOldY() {
		return oldY;
	}

	/* WHAT IT DOES: Setter method for object's OldY
	 * PARAMETERS: 
	 * 	oldY - the desired oldY coordinate
	 * RETURN: NONE*/
	public void setOldY(double oldY) {
		this.oldY = oldY;
	}

	/* WHAT IT DOES: Getter method for objec'ts oldX 
	 * PARAMETERS: NONE
	 * RETURN: Objects oldX*/
	public double getOldX() {
		return oldX;
	}

	/* WHAT IT DOES: Setter method for object's oldX 
	 * PARAMETERS: 
	 * 	oldX - desired oldX value
	 * RETURN: NONE*/
	public void setOldX(double oldX) {
		this.oldX = oldX;
	}
}
