package movingobjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GunM4Trigger extends MovingObjects
{
	private boolean firing;
	
	public GunM4Trigger(double posx, double posy) {
		super(posx, posy);
		// TODO Auto-generated constructor stub
		try {
			avatar = ImageIO.read(getClass().getResourceAsStream("/graphics/fireTrigger.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		width = 47*0.4;
		height = 120*0.4;
		firing = false;
	}

	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		AffineTransform old = g2.getTransform();
		update();
		g2.translate((int)(posx), (int) (posy)-15);
		g2.rotate(angle);
		g2.drawImage(avatar, (int) -width/2, (int)-height/2+15, (int) width, (int) height, null);
//		g2.setColor(Color.red);
//		g2.fillOval(-5,-5,10,10);
		g2.setTransform(old);
	}
	
	private void update()
	{
		if (firing == true)
		{
			if (angle >= Math.toRadians(-35))
			{
//				double i = Math.toDegrees(angle);
//				setAngle(i++);
				angle-=0.5;
			}
			else
			{
				firing = false;
				angle = 0;
			}
		}
	}
	
	public boolean isFiring()
	{
		return firing;
	}
	
	public void fire()
	{
		firing = true;
	}
}