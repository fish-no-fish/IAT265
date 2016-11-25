import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.awt.*;
import java.awt.geom.*;

import javax.swing.JPanel;
import javax.swing.Timer;

public class FishPanel extends JPanel implements MouseListener, ActionListener 
{
	
	public final static int WIN_H = 972;
	public final static int WIN_W = 1728;
	
	private ArrayList<Fish> enemyFishes;
	private int numShark, numReg;
	private Timer timer;
	private double spawnTimer;
	private double[] spawnPos = new double[3];
	
	private ArrayList<Ellipse2D.Double> rocksList;
	
	private	Rectangle2D.Double pond = new Rectangle2D.Double();
	
	private Ellipse2D.Double rock1 = new Ellipse2D.Double();
	private Ellipse2D.Double rock2 = new Ellipse2D.Double();
	private Ellipse2D.Double rock3 = new Ellipse2D.Double();
	private Ellipse2D.Double rock4 = new Ellipse2D.Double();
	private Ellipse2D.Double rock5 = new Ellipse2D.Double();
	

	private CubicCurve2D.Double seaweed1 = new CubicCurve2D.Double();
	private CubicCurve2D.Double seaweed2 = new CubicCurve2D.Double();
	private CubicCurve2D.Double seaweed3 = new CubicCurve2D.Double();
		
	public FishPanel()
	{
		super();
		timer = new Timer(60,this);
		timer.start();
		
		this.setPreferredSize(new Dimension(WIN_W, WIN_H));
		this.setBackground(Color.white);
		rocksList = new ArrayList<Ellipse2D.Double>();
		enemyFishes = new ArrayList<Fish>();
		numShark = numReg = 0;
		spawnTimer = 0;
		
		addMouseListener(this);
	}
	
	private void generateEnemies()
	{
		if(Util.random(0,10) <= 2 && numShark < 2)
			{
				randomSpawn();
				enemyFishes.add(new Shark(spawnPos[0], spawnPos[1], 1, spawnPos[2]));
				numShark++;
			}
			else
			{
				randomSpawn();
				enemyFishes.add( 
						new Herbivores(
								spawnPos[0], 
								spawnPos[1], 
								Util.random(0.3, 0.75), 
								new Color(
										(int) Util.random(1,255),
										(int) Util.random(0,255),
										(int) Util.random(0,255)
										),
								new Color(
										(int) Util.random(0,255),
										(int) Util.random(0,255),
										(int) Util.random(0,255)
										),
								spawnPos[2]));
				numReg++;
			}
	
	}
	
	private void spawnEnemies()
	{
		if (System.currentTimeMillis() - spawnTimer >= 2000)
		{
			spawnTimer = System.currentTimeMillis();
			if(enemyFishes.size() < 10)
			{
				generateEnemies();				
			}
		}
	}
	
	private double[] randomSpawn()
	{
		if (Util.random(0,1) < 0.5)
		{
			spawnPos[0] = -300;
			spawnPos[1] = Util.random(200, WIN_H-200);
			spawnPos[2] = 1;
			return spawnPos;
		}
		else
		{
			spawnPos[0] = WIN_W+300;
			spawnPos[1] = Util.random(200, WIN_H-200);
			spawnPos[2] = -1;
			return spawnPos;
		}
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		AffineTransform old = g2.getTransform();
		super.paintComponent(g);
		drawPond(g2);
		drawRocks();
		for (int i = 0; i < enemyFishes.size(); i++)
		{
//			System.out.println("Reached");
			if (enemyFishes.get(i) != null)
			{
				enemyFishes.get(i).drawFish(g);				
			}			
		}
		g2.setTransform(old);
		g2.setColor(Color.gray);
		for (int i = 0; i < rocksList.size(); i++)
		{
			g2.fill(rocksList.get(i));
		}		
		drawSeaweeds(g2);		
	}
	
	private void drawSeaweeds(Graphics2D g2)
	{
		g2.setColor(Color.green);
		Point test = new Point(WIN_W/2+500, WIN_H);
		seaweed1.setCurve(test.x, test.y-20, test.x-100, test.y-100-20, test.x+100, test.y-200-20, test.x, test.y-300-20);
		seaweed2.setCurve(test.x-50, test.y-20, test.x-100-50, test.y-50-20, test.x+100-50, test.y-150-20, test.x-50, test.y-250-20);
		seaweed3.setCurve(test.x+50, test.y-20, test.x-100+50, test.y-100+50-20, test.x+100+50, test.y-200+100-20, test.x+50, test.y-300+150-20);
		g2.setStroke(new BasicStroke(20, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
		g2.draw(seaweed1);
		g2.draw(seaweed2);
		g2.draw(seaweed3);
	}
	
	private void drawPond(Graphics2D g2)
	{
		
		pond.setFrame(0, 0, WIN_W, WIN_H);
		Color pondColor = Color.decode("#1FBED6");
		g2.setColor(pondColor);
		g2.fill(pond);		
	}
	
	private void drawRocks()
	{
//		System.out.println("Here");
		rock1.setFrame(132, 944-100, 50, 25);
		rock2.setFrame(385, 947-100, 50, 25);
		rock3.setFrame(694, 893-100, 50, 25);
		rock4.setFrame(1035, 963-100, 50, 25);
		rock5.setFrame(1620, 964-100, 50, 25);
		rocksList.add(rock1);		
		rocksList.add(rock2);
		rocksList.add(rock3);
		rocksList.add(rock4);
		rocksList.add(rock5);
	}
	
	private void fishUpdate()
	{
		for (int i = 0; i < enemyFishes.size(); i++)
		{	
			System.out.println(i);
			enemyFishes.get(i).update();
//			
//				for (int j = i+1; j < enemyFishes.size(); j++)
//				{
//					if (enemyFishes.get(j) != null && enemyFishes.get(j) != enemyFishes.get(i))
//					{
//						if (enemyFishes.get(i).handleCollision(enemyFishes.get(j)))
//						{
//							enemyFishes.get(i).changeDirection();
//							enemyFishes.get(j).changeDirection();
//							
//							enemyFishes.get(i).setLocation(enemyFishes.get(i).getDirection()*3+enemyFishes.get(i).getLocation()[0] 
//									,enemyFishes.get(i).getLocation()[1]);
//							enemyFishes.get(j).setLocation(enemyFishes.get(j).getDirection()*3+enemyFishes.get(j).getLocation()[0] 
//									,enemyFishes.get(j).getLocation()[1]);
//						}
//					}
//				}
			
			if (enemyFishes.get(i).alive == false)
			{
				if (enemyFishes.get(i) instanceof Herbivores)
				{
					numReg--;
				}
				else
				{
					numShark--;
				}
				enemyFishes.remove(i);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		spawnEnemies();
		fishUpdate();
		repaint();
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

}