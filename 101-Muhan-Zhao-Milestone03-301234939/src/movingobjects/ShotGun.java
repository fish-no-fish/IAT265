package movingobjects;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ShotGun extends MovingObjects
{

	private SGPump pump;
	private BufferedImage overlay;
	private boolean gunLoaded;
	private boolean gunPumped;
	private boolean chambered;

	public ShotGun(double posx, double posy, SGPump pump) {
		super(posx, posy);
		// TODO Auto-generated constructor stub
		try {
			avatar = ImageIO.read(getClass().getResourceAsStream("/graphics/SGBase.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			overlay = ImageIO.read(getClass().getResourceAsStream("/graphics/SGOverlay.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.pump = pump;
		width = avatar.getWidth();
		height = avatar.getHeight();
		gunLoaded = false;
		gunPumped = false;
		chambered = false;
	}

	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		old = g2.getTransform();
		oldC = g2.getComposite();
		g2.translate(posx, posy);
		
		opacity = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, initialOpacity);
		
		g2.drawImage(avatar, -avatar.getWidth()/2, -avatar.getHeight()/2, avatar.getWidth(), avatar.getHeight(), null);
		g2.setTransform(old);
		pump.draw(g2);
		g2.translate(posx, posy);
		g2.drawImage(overlay, -overlay.getWidth()/2, -overlay.getHeight()/2, overlay.getWidth(), overlay.getHeight(), null);
		
		appear();
		g2.setComposite(oldC);
		g2.setTransform(old);
	}
	
	public void manualReload()
	{
		if (gunLoaded == false)
		{
			System.out.println("manual reloaded");
			gunLoaded = true;	
		}
		
	}
	public boolean isLoaded()
	{
		return false;
	}

	/**
	 * @return the gunPumped
	 */
	public boolean isGunPumped() {
		return gunPumped;
	}

	/**
	 * @param gunPumped the gunPumped to set
	 */
	public void setGunPumped(boolean gunPumped) {
		this.gunPumped = gunPumped;
	}

	/**
	 * @return the chambered
	 */
	public boolean isChambered() {
		return chambered;
	}

	/**
	 * @param chambered the chambered to set
	 */
	public void setChambered(boolean chambered) {
		this.chambered = chambered;
	}

}