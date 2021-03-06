import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Fish 
{
	private Point pos;
	private int myWidth, myHeight;
	private double speedX, speedY, scaleX, scaleY;
	private Color fins;
	private long lastExecutionEye;
	
	public Fish(int x, int y)
	{
		pos = new Point(x,y);
		myWidth = 250;
		myHeight = 100;
		scaleX = 1;
		scaleY = 1;
		fins = Color.red;
		speedX = 10;
		lastExecutionEye = 2000;
		speedY = 5;
	}
	
	public Point getLocation()
	{
		return pos;
	}
	
	public int[] getDims()
	{
		int[] dim = {myWidth, myHeight};
		
		return dim;
	}
	
	public double[] getScale()
	{
		double[] scales = {scaleX, scaleY};
		
		return scales;
	}
	
	private void centerFillOval(int _x, int _y, int w, int h, Graphics g)
	{
//		centers a circle around x, y
		
		g.fillOval(_x-w/2, _y-h/2, w, h);
	}
	
	public void moveFish()
	{		
		pos.x += speedX;
		pos.y += speedY;
		
		
		if (pos.x + myWidth/2 >= FishPanel.WIN_W || pos.x - myWidth/2 <= 0)
		{
			scaleX *= -1;
			speedX = speedX*-1;
//			System.out.println("hit \n");
		}
		if (pos.y >= 950 || pos.y <= 700)
		{
			speedY *= -1;
		}
	}
	
	public void drawFish(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		AffineTransform defaultMove = g2.getTransform();
		g2.translate(pos.x, pos.y-200);
		g2.scale(scaleX, scaleY);
		g.setColor(Color.blue);
		
//		g.fillOval(x-myWidth/2, y-myHeight/2, myWidth, myHeight);
		
//		fins upper
		g2.translate(25, 0);
		g2.setColor(fins);
		int[] fx1 = {-25, 0, 25};
		int[] fy1 = {200-45, 200-95, 200-45};
		g2.fillPolygon(fx1, fy1, 3);
		
//		fins lower left		
		AffineTransform old = g2.getTransform();
		g2.rotate(Math.toRadians(25/2));
		int[] fx2 = {25, 0, -25};
		int[] fy2 = {200+45, 200+95, 200+45};
		g2.fillPolygon(fx2, fy2, 3);
		g2.setTransform(old);
		
		
//		fins lower right
		old = g2.getTransform();
		g2.rotate(Math.toRadians(-25/2));
		int[] fx3 = {-25, 0, 25};
		int[] fy3 = {200+45, 200+95, 200+45};
		g2.fillPolygon(fx3, fy3, 3);
		g2.setTransform(old);
		
//		tail
		g.setColor(fins);
		int[] tx = {-150,-50,-150};
		int[] ty = {200+50,200,200-50};
		g.fillPolygon(tx, ty, 3);
		
		g2.setColor(Color.white);
		g2.setStroke(new BasicStroke(3));
		g2.drawLine(-150, 200, -150+30, 200);
		g2.drawLine(-150, 200-10, -150+30, 200-10);
		g2.drawLine(-150, 200+10, -150+30, 200+10);
		
//		body
//		g.fillOval(x-myWidth/2, y-myHeight/2, 200, 100);
		g2.setColor(Color.gray);
//		centerFillOval(x, y, 200, 100, g);
		Ellipse2D.Double fishBody = new Ellipse2D.Double(-200/2, 200-100/2, 200, 100);
		g2.fill(fishBody);
		
//		decoration
		g.setColor(Color.white);
		int fishBodyBoundaryLeft = -200/2;
		int fishBodyBoundaryUp = 200-100/2;
		int fishBodyBoundaryRight = 200 + fishBodyBoundaryLeft;
		int fishBodyBoundaryDown = 100 + fishBodyBoundaryUp;
		
		for (int i = fishBodyBoundaryLeft; i < fishBodyBoundaryRight; i += 10)
		{
			for (int j = fishBodyBoundaryUp; j < fishBodyBoundaryDown; j += 10)
			{
				
				if (fishBody.contains(i,j))
				{
					centerFillOval(i, j, 4, 4, g);
				}
			}
		}
		
//		eyes
		g.setColor(Color.black);
		
		if ((System.currentTimeMillis() - lastExecutionEye) >= 2000)
		{
			g.fillRect(50-25/2,200-(25/2), 25, 5);
//			System.out.println("Blink");
			lastExecutionEye = System.currentTimeMillis();
		}
		else
		{
			centerFillOval(50,200+-25/2,25,25,g);
		}
//		centerFillOval(50,200-25/2,25,5,g);

		
//		gills
		g2.setColor(Color.white);
		g2.setStroke(new BasicStroke(3));
		g2.drawArc(+10, 200+-50/2, 50/2, 50, 90, 180);
		g2.setTransform(defaultMove);
		
//		debug
//		g2.setColor(Color.blue);
//		g2.fillOval(pos.x, pos.y, 10, 10);
//		g2.fillOval(pos.x+myWidth/2, pos.y, 10, 10);
//		g2.fillOval(pos.x-myWidth/2-50, pos.y, 10, 10);
//		if (pos.x + myWidth/2 >= FishPanel.WIN_W || pos.x - myWidth/2-50 <= FishPanel.WIN_W)
//		g2.setColor(Color.red);
//		g2.fillOval(FishPanel.WIN_W/2, pos.y, 10, 10);
//		g2.fillOval(0, pos.y, 10, 10);
		
	}
}