/* A Ball class that draws, moves, test collision of a ball
 * A demo program created for IAT-265 Spring 15
 * Author: Eric Yang
 * Date of creation: Jan 20 2015
 * Date of Modification: Feb 4 2015
 * All rights reserved
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class DancingBall {
	Ellipse2D.Double ball;
	private double xPos;
	private double yPos;
	private double xSpeed;
	private double ySpeed;
//	private double ballW;
//	private double ballH;
	
//	half of width/height
	private double radius;
	
	private Color ballColor;
	private double maxSpeed = 4;
	
	private double wave, waveSpeed, waveAmplify;
	
	public boolean deflated;
	
	public DancingBall(double x, double y, double sx, double sy, double rs, Color c) {
		ball = new Ellipse2D.Double();
		xPos = x;
		yPos = y;
		radius = rs;
		xSpeed = sx;
		ySpeed = sy;
		ballColor = c;
		
		wave = 0;
		waveSpeed = Util.random(0.05, 0.2);
		waveAmplify = Util.random(1.1, 3.30);
		ball.setFrame(-radius, -radius, 2*radius, 2*radius);
		deflated = false;
	}

	public void drawBall(Graphics2D g2) {
		g2.setColor(ballColor);
		AffineTransform transform = g2.getTransform();
		g2.translate(xPos, yPos);
		g2.fill(ball);
		g2.setTransform(transform);
	}

	public void move(){
		xPos += xSpeed;
		wave += waveSpeed;
		yPos += Math.sin(wave) * waveAmplify;
		yPos += ySpeed;
		detectWall();
	}
	
	private void detectWall(){
		if(!deflated)
		{
			if(xPos + radius > DancingBallPanel.WIN_WIDTH ){
				xPos = DancingBallPanel.WIN_WIDTH-radius;
				xSpeed = -xSpeed;
			}
			if(xPos-radius < 0){
				xPos = radius;
				xSpeed = -xSpeed;
			}
			if(yPos + radius > DancingBallPanel.WIN_HEIGHT ){
				yPos = DancingBallPanel.WIN_HEIGHT-radius;
				ySpeed = -ySpeed;
			}
			if(yPos - radius < 0){
				yPos = radius;
				ySpeed = -ySpeed;
			}			
		}
	}
	
	void detectCollision(DancingBall otherBall) {
		if (Util.dist(xPos, yPos, otherBall.xPos, otherBall.yPos) < radius + otherBall.radius) {

		   double angle = Math.atan2(yPos-otherBall.yPos, xPos-otherBall.xPos);

		   //Make the current ball moves away along angle
		   xSpeed = maxSpeed * Math.cos(angle);
		   ySpeed = maxSpeed * Math.sin(angle);

		   //Send the otherBall away in the opposite direction: angle-PI
		   otherBall.xSpeed = maxSpeed * Math.cos(angle - Math.PI);
		   otherBall.ySpeed = maxSpeed * Math.sin(angle - Math.PI); 	
		}
	}
	
	
//	if spear hit ball
	public boolean isClicked(int x, int y)
	{
		if(Util.dist(xPos, yPos, x, y) < radius + 10 && !deflated)
		{
			return true;
		}
		return false;
	}
	
	
//	deflating the ball
	public void deflate()
	{
		ball.setFrame(-radius,  -radius,  radius * 2,  radius/2);
		xSpeed = 0;
		ySpeed = 2;
		waveAmplify = 0;
		deflated = true;
	}

}
