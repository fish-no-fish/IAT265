/* A Ladybug class that draws and moves a ladybug
 * A demo program created for IAT-265 Spring 15
 * Author: Eric Yang
 * Date of creation: Jan 20 2015
 * Date of Modification: Jan 22 2015
 * All rights reserved
 */
import java.awt.*;

//update UML, add new field scale for the ladybug class
//codify to set the scale factor as 1.5
//fix inconsistency of boundary detection

import java.awt.geom.*;

public class Ladybug {
	private Ellipse2D.Double body;
	private Ellipse2D.Double dot;
	private Ellipse2D.Double dot1;
	private Ellipse2D.Double dot2;
	private Ellipse2D.Double dot3;
	private Line2D.Double line;
	private Arc2D.Double head;
	private QuadCurve2D.Double upAntenna;
	private QuadCurve2D.Double dnAntenna;
	private double scale;

	private double bugX, bugY;
	
	private double xSpeed, ySpeed;
	private double angle;

	private final int HEAD_WIDTH = 12;
	private final int BODY_WIDTH = 34;
	private final int BUG_HEIGHT = 30;
	private final int DOT_SIZE = 6;

	public Ladybug(double x, double y, double xs, double ys, double sc) {
		bugX = x;
		bugY = y;
		xSpeed = xs;
		ySpeed = ys;
		body = new Ellipse2D.Double();
		dot = new Ellipse2D.Double();
		dot1 = new Ellipse2D.Double();
		dot2 = new Ellipse2D.Double();
		dot3 = new Ellipse2D.Double();
		head = new Arc2D.Double();
		line = new Line2D.Double();
		upAntenna = new QuadCurve2D.Double();
		dnAntenna = new QuadCurve2D.Double();
		angle = Math.toRadians(45);
		scale = sc;
	}

	// Set up body components' locations & sizes: Assume (0, 0) be the center of
	// the body then draw others around it
	public void setBodyAttributes() {
		body.setFrame(-BODY_WIDTH / 2, -BUG_HEIGHT / 2, BODY_WIDTH, BUG_HEIGHT);
		dot.setFrame(4, -10, DOT_SIZE, DOT_SIZE); // (4, -10): top-left corner
													// of the dot
		dot1.setFrame(4, 5, DOT_SIZE, DOT_SIZE);
		dot2.setFrame(-8, -10, DOT_SIZE, DOT_SIZE);
		dot3.setFrame(-8, 5, DOT_SIZE, DOT_SIZE);
		line.setLine(-BODY_WIDTH / 2, 0, BODY_WIDTH / 2, 0);
	}

	// Set up Head components' locations & sizes w.r.t the center of the body
	// (0, 0)
	public void setHeadAttributes() {
		head.setArc(BODY_WIDTH / 2 - 6, -6, HEAD_WIDTH, HEAD_WIDTH, -90, 180, Arc2D.PIE);
		upAntenna.setCurve(BODY_WIDTH / 2, 0, BODY_WIDTH / 2 + 10, 0, BODY_WIDTH / 2 + 8, -10);
		dnAntenna.setCurve(BODY_WIDTH / 2, 0, BODY_WIDTH / 2 + 10, 0, BODY_WIDTH / 2 + 8, 10);
	}

	public void drawBug(Graphics2D g2) {
		g2.translate(bugX, bugY);
		g2.scale(scale, scale);		
		g2.rotate(angle);
		
		setHeadAttributes();
		setBodyAttributes();
		// fill body in orange
		g2.setColor(new Color(160, 0, 0));
		g2.fill(body);

		g2.setColor(Color.BLACK);
		// draw body outline in black
		g2.draw(body);
		// fill the dots and head
		g2.fill(dot);
		g2.fill(dot1);
		g2.fill(dot2);
		g2.fill(dot3);
		g2.fill(head);

		// draw the body line and antenna
		g2.draw(line);
		g2.draw(upAntenna);
		g2.draw(dnAntenna);
	}
	
	public void move()
	{
		bugX += xSpeed;
		bugY += ySpeed;
		
//		boundary detection
//		if(bugX + BODY_WIDTH/2 > BugPanel.GARDEN_X+BugPanel.GARDEN_W || bugX - BODY_WIDTH/2 < BugPanel.GARDEN_X)
//		{
//			xSpeed *= -1;
//		}
		
		if(bugX + (5+head.width/2+BODY_WIDTH/2)*scale >= BugPanel.GARDEN_W+BugPanel.GARDEN_X || bugX - (5+head.width/2+BODY_WIDTH/2)*scale <= BugPanel.GARDEN_X)
		{
			xSpeed *= -1;
		}
		if(bugY + (4+head.height/2+BUG_HEIGHT/2)*scale >= BugPanel.GARDEN_Y+BugPanel.GARDEN_H || bugY - (4+head.height/2+BUG_HEIGHT/2)*scale <= BugPanel.GARDEN_Y)
		{
			ySpeed *= -1;
		}
		
		if (xSpeed > 0 && ySpeed < 0)
		{
			angle = Math.toRadians(45-90);
		}
		else if (xSpeed > 0 && ySpeed > 0)
		{
			angle = Math.toRadians(45);
		}
		else if (xSpeed < 0 && ySpeed < 0)
		{
			angle = Math.toRadians(45+180);
		}
		else if (xSpeed < 0 && ySpeed > 0)
		{
			angle = Math.toRadians(45+90);
		}
		
	}
}
