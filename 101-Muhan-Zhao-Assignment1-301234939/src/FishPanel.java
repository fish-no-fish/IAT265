import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class FishPanel extends JPanel implements MouseListener, ActionListener
{
	public final static int WIN_H = 1080;
	public final static int WIN_W = 1920;
	
	private Fish fish;
	private Timer timer;
	private long lastExecutionBubble;
	
	private ArrayList<Bubble> bubblezList;
	
	public FishPanel()
	{
		super();
		timer = new Timer(60,this);
		timer.start();
		
		this.setPreferredSize(new Dimension(WIN_W,WIN_H));
//		TODO awaiting constructor
		fish = new Fish(WIN_W/2, 900);
		Color sky = Color.decode("#1FBED6");
		this.setBackground(sky);
		lastExecutionBubble = 6000;
		
		addMouseListener(this);
		bubblezList = new ArrayList<Bubble>();
	}
	
	private void drawGrids(Graphics g)
	{
//		draws some grids for ease of measurement
		g.setColor(Color.gray);
		int i = 0;
		for (i = 0; i < WIN_W; i+=50)
		{
			g.drawLine(i, 0, i, WIN_H);
		}
		i = 0;
		for (i = 0; i < WIN_H; i+=50)
		{
			g.drawLine(0, i, WIN_W, i);
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
//		DRAWING GRIDS
		drawPond(g);
//		drawGrids(g);
		
//		g.translate(WIN_W/2, WIN_H/2);
		fish.drawFish(g);
//		g.translate(-WIN_W/2, -WIN_H/2);
		
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 0 ;i < bubblezList.size(); i++)
		{
			Bubble curr = (Bubble) bubblezList.get(i);
			curr.drawBubble(g2);
		}
	
	}
	
	private void drawRocks(Graphics g, int x, int y)
	{
		g.setColor(Color.gray);
		g.fillOval(x, y, 50, 25);
	}
	
	private void drawPond(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.GREEN);
		g.fillRect(10, WIN_H*1/2, WIN_W-20, WIN_H/2-10);
		g.setColor(Color.cyan);
		
		Ellipse2D.Double pond = new Ellipse2D.Double(10, WIN_H*1/2, WIN_W-20, WIN_H/4);
//		g.fillOval(10, WIN_H*1/2, WIN_W-20, WIN_H/4);
		g2.fill(pond);
		g.fillRect(10, WIN_H*1/2+(WIN_H/4)/2, WIN_W-20, (WIN_H*3/4)/2-10);
		
//		rocks
		drawRocks(g, 100, WIN_H-100);
		drawRocks(g, 901, 1012);
		drawRocks(g, 1165, 930);
		drawRocks(g, 1467, 978);
		drawRocks(g, 1620, 898);
		drawRocks(g, 1779, 979);
		drawRocks(g, 1004, 904);
		drawRocks(g, 575, 907);
		drawRocks(g, 390, 996);
		drawRocks(g, 288, 921);
	}
	
	private void bubbles()
	{
		for (int i = 0 ;i < bubblezList.size(); i++)
		{
			Bubble curr = (Bubble) bubblezList.get(i);
			if (curr.update())
			{
				bubblezList.remove(i);
			}
		}
//		System.out.println(bubblezList.size());
	}
	
	public void generateBubbles(Point pos)
	{
		Random rand = new Random();
		int amount = rand.nextInt(5)+1;
		
		for (int i = 0; i < amount; i++)
		{
			int offset = rand.nextInt(20)-20;
			
			int fishMouth;

			if (fish.getScale()[0] == 1)
			{
				fishMouth = fish.getDims()[0]/2;
			}
			else
			{
				fishMouth = -1*fish.getDims()[0]/2;
			}
			
			bubblezList.add(new Bubble(new Point(pos.x+offset+fishMouth, pos.y-(i*30))));
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
//		System.out.println(e.getX());
//		System.out.println(e.getY());
//		System.out.println("\n");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub		
		
		if ((System.currentTimeMillis() - lastExecutionBubble) >= 3000)
		{
			generateBubbles(fish.getLocation());
			lastExecutionBubble = System.currentTimeMillis();
		}
		
		fish.moveFish();
		repaint();
		bubbles();
		repaint();
	}
}
