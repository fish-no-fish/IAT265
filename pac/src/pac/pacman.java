package pac;

import java.awt.*;

public class pacman 
{
	private int pacX, pacY;
	private int bodyW, bodyH;
	private int speedX;
	private int scale;
	public boolean eyes = false;
	
	public pacman(int x, int y, int w, int h, int s, int _scale)
	{
		pacX = x;
		pacY = y;
		bodyW = w;
		bodyH = h;
		speedX = s;
		scale = _scale;
	}

	public void drawPacman(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		
//		translating origin
		g2.translate(pacX, pacY);
		
		g2.setColor(Color.yellow);
		

		if (speedX < 0)
		{
//			reverse pacman
			g2.scale(-1, 1);
		}
		
		g2.scale(scale, scale);
		g2.fillArc(-bodyW/2, -bodyH/2, bodyW, bodyH, 30, 300);
		if(eyes)
		{
			drawEyes(g2);			
		}
	}
	
	public void drawEyes(Graphics2D g3)
	{
		
		g3.setColor(Color.black);
		
		g3.fillOval(-5, -15, 10, 10);
		
		g3.setColor(Color.yellow);
		
		
	}
	
	public void setScale(int x)
	{
		scale = x;
	}
	
	public void move()
	{
		pacX += speedX;
		
//		boundary detection
		if(pacX - bodyW/2 < pacmanPanel.GARDEN_X || pacX + bodyW/2 > pacmanPanel.GARDEN_X + pacmanPanel.GARDEN_W)
		{
			speedX *= -1;
		}
	}
	
}
