package movingobjects;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet extends MovingObjects{

	private int distanceRatio;
	private int type;
	
	public Bullet(double posx, double posy, int type) {
		super(posx, posy);
		// TODO Auto-generated constructor stub
		this.type = type;
		if (type == 1)
		{
			try {
				avatar = ImageIO.read(getClass().getResourceAsStream("/graphics/556.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			width = 50*0.4;
			height = 200*0.4;
		}
		else if (type == 2)
		{
			try {
				avatar = ImageIO.read(getClass().getResourceAsStream("/graphics/shotGunShell.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			width = avatar.getWidth()*.2;
			height = avatar.getHeight()*.2;
		}
		angle = 0;
	}
	
	public void handleProximity(MovingObjects target)
	{
		if (target != null)
		{
			int side;
			if (target.getX() - posx <= 0)
			{
				side = -1;
			}
			else
			{
				side = 1;
			}
			if (dist(target) < 500)
			{
				angle = side*90 * (1-(((Magazine) target).distMag(this))/500);			
			}
		}
	}

	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		old = g2.getTransform();
		oldC = g2.getComposite();
		g2.translate(posx, posy);
//		if (type == 2)
//		{
//			g2.rotate(Math.toRadians(180));
//		}
		g2.rotate(Math.toRadians(angle));
		opacity = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, initialOpacity);
		g2.setComposite(opacity);
		g2.fillRect((int) -width/2, (int) -height/2, (int) width, (int) height);
		g2.drawImage(avatar, (int) -width/2, (int) -height/2, (int) width, (int) height, null);
		appear();
		g2.setComposite(oldC);
		g2.setTransform(old);
	}
	
	

	@Override
	public void setPos(double x, double y) {
		// TODO Auto-generated method stub
		posx = x;
		posy = y;
	}
	
	

}