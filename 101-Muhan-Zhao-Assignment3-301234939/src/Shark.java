import java.awt.*;
import java.awt.geom.AffineTransform;

public class Shark extends Fish{
	
	public Shark(double x, double y, double scale, double dir)
	{
		super(x, y, scale, Color.black, Color.black, dir);
		offset = 0;
		myWidth = 220;
		myHeight = 100;
	}
	
	public void drawFish(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		AffineTransform old = g2.getTransform();
		g2.translate(posx, posy);
		g2.scale(scalex, scaley);
		g2.setColor(bodyColor);
		
		g2.translate(10, 0);
		g2.fillOval(-100,-75/2, 200, 75);
		g2.translate(-10, 0);
		
//		upper and lower tailfins
		g2.translate(-60, 0);
		int[]tx1 = {0, -50, -35};
		int[]ty1 = {0, -50, 0};
		g2.fillPolygon(tx1, ty1, 3);
		g2.scale(1, -1);
		g2.fillPolygon(tx1, ty1, 3);
		g2.scale(1, -1);
		g2.translate(60, 0);

//		upper fin
		g2.translate(30,-30);
		int[]ux1 = {0, -50, -35};
		int[]uy1 = {0, -50, 0};
		g2.fillPolygon(ux1, uy1, 3);
		g2.translate(-30,30);
		
		g2.scale(1,-1);
		g2.translate(10,-10);
		g2.fillPolygon(ux1, uy1, 3);
		g2.translate(-10,10);
		g2.scale(1,-1);
		
//		eyes
		g2.setColor(Color.red);
		g2.fillOval(60,-10,10,10);
		//
//		g2.setColor(Color.red);
//		g2.fillOval(0,0,10,10);
	}
}
