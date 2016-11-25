/* A Ball Panel that draws a collection of balls moving around within screen
 * A demo program created for IAT-265 Spring 15
 * Author: Eric Yang
 * Date of creation: Jan 20 2015
 * Date of Modification: Feb 4 2015
 * All rights reserved
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;

import javax.swing.JPanel;
import javax.swing.Timer;

public class DancingBallPanel extends JPanel implements ActionListener, MouseMotionListener, MouseListener {
	int count = 30;
	private DancingBall[] balls = new DancingBall[count];
	Timer timer;
	public final static int WIN_WIDTH = 600;
	public final static int WIN_HEIGHT = 600;
	
	Line2D.Double line = new Line2D.Double();
	boolean showSpear;
	
	private int mouseX, mouseY;

	public DancingBallPanel() {
		super(); // call JPanel's default constructor
		this.setPreferredSize(new Dimension(WIN_WIDTH, WIN_HEIGHT));
		Dimension size = this.getPreferredSize();
		Color c;
		for (int i = 0; i < balls.length; i++) {
			c = new Color((int) Util.random(0, 255), (int) Util.random(0, 255), (int) Util.random(0, 255));
			balls[i] = new DancingBall(Util.random(0, WIN_WIDTH), Util.random(0, WIN_HEIGHT), Util.random(12, 36), Util.random(-4,
					4), Util.random(-6, 18), c);

		}
		timer = new Timer(33, null);
		timer.start();

		timer.addActionListener(this);
		this.setBackground(Color.gray);
		
		showSpear = false;
		addMouseMotionListener(this);
		addMouseListener(this);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		for (int i = 0; i < balls.length; i++) {
			for (int j = i + 1; j < balls.length; j++) {
				if(balls[i].deflated != true && balls[j].deflated != true)
				{
					balls[i].detectCollision(balls[j]);
				}
			}
			balls[i].drawBall(g2);
		}
		
		if (showSpear)
		{
			drawSpear(g2, mouseX, mouseY);
		}
	}
	
	private void drawSpear(Graphics2D g2, int x, int y)
	{
		line.setLine(x,y,x,y-150);
		g2.setColor(Color.white);
		g2.setStroke(new BasicStroke(2));
		g2.draw(line);
		
		int[] xCoords = {x,x-10,x+10};
		int[] yCoords = {y-150-40, y-150-15, y-150-15};
		
		g2.fillPolygon(xCoords, yCoords, 4);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < balls.length; i++) {
			balls[i].move();
		}

		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		mouseX = arg0.getX();
		mouseY = arg0.getY();
		
		if (mouseX > 0 && mouseX < WIN_WIDTH && mouseY > 10 && mouseY < WIN_HEIGHT)
		{
			showSpear = true;
		}
		else
		{
			showSpear = false;
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(showSpear)
		{
			for(int i = 0; i < count; i++)
			{
				if (balls[i].isClicked(arg0.getX(), arg0.getY()-150-20))
				{
					balls[i].deflate();
				}
			}
				
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
