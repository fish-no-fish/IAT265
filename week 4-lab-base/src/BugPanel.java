/* A Ladybug Panel that draws a ladybug in a garden with a happy face
 * A demo program created for IAT-265 Spring 15
 * Author: Eric Yang
 * Date of creation: Jan 20 2015
 * Date of Modification: Jan 22 2015
 * All rights reserved
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class BugPanel extends JPanel implements ActionListener
{
	public final static int GARDEN_W = 480;
	public final static int GARDEN_H = 300;
	public final static int GARDEN_X = 50; 
	public final static int GARDEN_Y = 50;
	private Ladybug ladybug;
	private Rectangle2D.Double garden;
	
	private Timer timer;

	
	public BugPanel() {
		super();
		this.setBackground(java.awt.Color.white);
		garden = new Rectangle2D.Double();
		double speedX = 2.0, speedY = 1.5;
		ladybug = new Ladybug(GARDEN_X+200, GARDEN_Y + GARDEN_H / 2, speedX, speedY, 4);
		garden.setFrame(GARDEN_X, GARDEN_Y, GARDEN_W, GARDEN_H);
		
		timer = new Timer(30,this);
		timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			    RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(new Color(0, 200, 0));
		g2.fill(garden);
		drawHappyFace(g2);
		ladybug.drawBug(g2);
	}

	public void drawHappyFace(Graphics2D g) {
		// Dimension size = getSize();
		int d = Math.min(GARDEN_W, GARDEN_H); // diameter
		int ed = d / 20; // eye diameter
		int x = GARDEN_X + 100; // (TANK_WIDTH - d+25); //2;
		int y = GARDEN_Y; // (TANK_WIDTH - d-25); //2;

		// draw head (color already set to foreground)
		g.setColor(Color.yellow);
		g.fillOval(x, y, d, d);
		g.setColor(Color.black);
		g.drawOval(x, y, d, d);

		// draw eyes
		g.fillOval(x + d / 3 - (ed / 2), y + d / 3 - (ed / 2), ed, ed);
		g.fillOval(x + (2 * (d / 3)) - (ed / 2), y + d / 3 - (ed / 2), ed, ed);

		// draw mouth
		g.drawArc(x + d / 4, y + 2 * (d / 5), d / 2, d / 3, 0, -180);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ladybug.move();
		repaint();
	}
}