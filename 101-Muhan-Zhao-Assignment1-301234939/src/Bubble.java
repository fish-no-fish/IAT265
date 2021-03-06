import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class Bubble {

	private Point pos;
	private int ySpeed;
	
	public Bubble(Point fish)
	{
		pos = fish;
		ySpeed = 5;
	}
	
	public Point getLocation()
	{
		return pos;
	}
	
	public void drawBubble(Graphics2D g2)
	{
		g2.setColor(Color.white);
		g2.fillOval(pos.x, pos.y, 20, 20);
	}
	
	private void move()
	{
		pos.y -= ySpeed;
	}
	
	public boolean handleDisappear()
	{
		if(pos.y < FishPanel.WIN_H/2)
		{
			return true;
		}
		return false;
	}
	
	public boolean update()
	{
		move();
		return handleDisappear();
	}

}
