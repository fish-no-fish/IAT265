import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.*;

public class Fish extends MovingObject
{
	private double scalex, scaley, rotation;
	private double speed;
	
	private double depth;
	private double oscillation;
	
	private double struggle;
	
	private Color hitboxColor, bodyColor, dots;
	
	public Rectangle2D.Double hitbox;
	
	public Ellipse2D.Double body, eye, dot;
	
	public Fish(double x, double y, double scale, Color color, Color color2)
	{
		super(x,y);
		scalex = scale;
		scaley = scale;
		speed = 10;

		myWidth = 200 * scalex;
		myHeight = 100 * scaley;
		
		offset = 25 * scalex;
		
		body = new Ellipse2D.Double();
		eye = new Ellipse2D.Double();
		dot = new Ellipse2D.Double();
		hitbox = new Rectangle2D.Double();
		
		depth = posy;
		oscillation = 50;
		
		hitboxColor = new Color(0,0,0,127);
		bodyColor = color;
		dots = color2;
		rotation = 0;
	}
	
	public Fish(Fish target)
	{
		super(target.posx, target.posy);
		scalex = target.scalex;
		scaley = target.scalex;
		speed = target.speed;
		myWidth = target.myWidth;
		myHeight = target.myHeight;
		offset = target.offset;
		body = target.body;
		eye = target.eye;
		dot = target.dot;
		hitbox = target.hitbox;
		depth = target.depth;
		bodyColor = target.bodyColor;
		dots = target.dots;
		rotation = target.rotation;
	}
	
	public double getOffset()
	{
		return offset;
	}
	
	public double getStruggle()
	{
		return rotation;
	}
	public void setStruggle(double x)
	{
		struggle = x;
	}
	
	public void setRotate(double x)
	{
		rotation = x;
	}
	
	public double[] getLocation()
	{
		double[] pos = new double[2];
		pos[0] = posx;
		pos[1] = posy;
		return pos;
	}
	
	public double getDirection()
	{
//		System.out.println(Math.signum(speed));
		return Math.signum(speed);
	}
	
//	public boolean handleCollision(Fish target)
//	{
////		if (getDirection() != target.getDirection())
////		{
//		if ((System.currentTimeMillis()-lastCollision) >= 500)
//		{
//			if (Math.abs(posx - target.posx) <= myWidth/2+offset + target.myWidth/2+target.offset && Math.abs(posy - target.posy) <= myHeight/2 + target.myHeight/2)
//			{
//				lastCollision = System.currentTimeMillis();
//				return true;
//			}
//		}
////		}
//		
//		return false;
//	}
	
	public void changeDirection()
	{
		speed *= -1;
		scalex *= -1;
	}
	
	public void setMovement(int de, int os)
	{
		depth = de;
		oscillation = os;
	}
	
	public void setLocation(double x, double y)
	{
		posx = x;
		posy = y;
	}
	
	public void setSize(double x)
	{
		scalex = x;
		scaley = x;
	}
	
	private void setBodyAtt()
	{
//		body
		body.setFrame(-200/2+offset, -100/2, 200, 100);
//		eyes
		eye.setFrame((200/2*.6)-25/2+offset, -25/2, 25, 25);	
		
//		hitbox
		hitbox.setFrame(-200/2-50+offset, -100/2, 200+50, 100);
	}
	
	
	
	public void moveFish()
	{
		posx += speed;
		posy = depth - oscillation * Math.sin(posx/50);
		if(speed != 10*getDirection())
		{
			speed+=getDirection()*-0.5;
		}
		
		if (detectBoundary())
		{
			changeDirection();
		}
	}
	
	public void scatterFish(int x, int y)
	{
		if (getDirection() > 0 && x >= posx && (x-150) <= posx)
		{
			changeDirection();
			speed = 20*getDirection();
		}
		else if (getDirection() < 0 && x<=posx && (x+150) >= posx)
		{
			changeDirection();
			speed = 20*getDirection();
		}
//		System.out.println(posx);
	}
	
	private boolean detectBoundary()
	{
		if (posx+(200/2+25+10)*scalex >= FishPanel.WIN_W || posx <= 0+30+myWidth/2)
		{
			if (getDirection() > 0)
			{
				posx = FishPanel.WIN_W - 30-myWidth/2;				
			}
			else
			{
				posx = 0+30+myWidth/2;
			}
			return true;
		}
		return false;
	}
	
	
	public void drawFish(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		AffineTransform original = g2.getTransform();
		g2.translate(posx, posy);
		g2.scale(scalex, scaley);
			
		g2.rotate(rotation);
		

		g2.translate(myWidth/2+offset, 0);
		g2.rotate(struggle);
		g2.translate(-myWidth/2-offset, 0);
		
		g2.setColor(dots);
		
//		fins upper
		int[]fx1 = {-35+(int) offset, -35/2+(int) offset, 35/2+(int) offset, 35+(int) offset};
		int[]fy1 = {-45, -85, -85, -45};
		g2.fillPolygon(fx1, fy1, 4);
		
//		int[]fx1 = {-25+(int) offset,0+(int) offset,25+(int) offset};
//		int[]fy1 = {-45, -95, -45};
//		g2.fillPolygon(fx1, fy1, 3);

//		fins lower left
		AffineTransform old = g2.getTransform();
		g2.rotate(Math.toRadians(25));
		g2.translate(+10,0);
		g2.scale(-1,-1);
		g2.fillPolygon(fx1, fy1, 4);
		g2.setTransform(old);
		
//		fins lower right
		old = g2.getTransform();
		g2.rotate(Math.toRadians(-25));
		g2.translate(75, 15);
		g2.scale(-1,-1);
		g2.fillPolygon(fx1, fy1, 4);
		g2.setTransform(old);
		
		
//		tail
		int[] tx = {-150+(int) offset, -50+(int) offset, -150+(int) offset};
		int[] ty = {50,0,-50};
		g2.fillPolygon(tx, ty, 3);
		
		setBodyAtt();
		g2.setColor(bodyColor);
		g2.fill(body);
		
		g2.setColor(dots);
		
		for (double i = -200/2+5+offset; i < 200/2-5+offset; i+= 10)
		{
			for (double j = -100/2+5; j < 100/2-5; j+= 10)
			{
				if (body.contains(i,j))
				{
					g2.fillOval((int)i-2,(int)j-2,4,4);
				}
			}
		}
		
		g2.setColor(Color.black);
		g2.fill(eye);
//		
//		g2.setColor(hitboxColor);
//		g2.fill(hitbox);		
		
//		g2.setColor(Color.red);
//		g2.fillRect(0, -1080, 1, 1080);

		g2.setTransform(original);
	}
}