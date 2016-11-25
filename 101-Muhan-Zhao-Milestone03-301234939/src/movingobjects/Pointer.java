package movingobjects;

import java.awt.Graphics2D;

public class Pointer extends MovingObjects
{
	private double oldX, oldY;
	public Pointer(double posx, double posy) {
		super(posx, posy);
		// TODO Auto-generated constructor stub
		width = 25;
		height = 25;
	}

	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the oldX
	 */
	public double getOldX() {
		return oldX;
	}

	/**
	 * @param oldX the oldX to set
	 */
	public void setOldX(double oldX) {
		this.oldX = oldX;
	}

	/**
	 * @return the oldY
	 */
	public double getOldY() {
		return oldY;
	}

	/**
	 * @param oldY the oldY to set
	 */
	public void setOldY(double oldY) {
		this.oldY = oldY;
	}

}
