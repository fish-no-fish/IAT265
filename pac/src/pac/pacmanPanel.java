package pac;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//implement mouse listener interface
//pacman should respond to mouse press and release for size change using scale
//have an eye when mouse pressed, lose an eye when mouse released
public class pacmanPanel extends JPanel implements ActionListener, MouseListener {

	public final static int GARDEN_X = 50;
	public final static int GARDEN_Y = 50;
	public final static int GARDEN_W = 500;
	public final static int GARDEN_H = 300;
	
	private pacman pac;
	private Timer timer;
	
	public pacmanPanel()
	{
		setPreferredSize(new Dimension(600, 400));
		timer = new Timer(30, this);
		timer.start();
		pac = new pacman(GARDEN_X + GARDEN_W/2, GARDEN_Y+GARDEN_H/2, 50, 50, 2, 1);	
		
		addMouseListener(this);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
//		draw green garden
		g2.setColor(Color.green);
		g2.fillRect(GARDEN_X, GARDEN_Y, GARDEN_W, GARDEN_H);
		
//		draw pacman
		pac.drawPacman(g);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		create a frame
		JFrame frame = new JFrame("pacman in garden");
		pacmanPanel pacPanel = new pacmanPanel();
		
		frame.add(pacPanel);
		
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		pac.move();
		repaint();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("it be workin \n");		
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
		pac.setScale(5);
		pac.eyes = true;
//		System.out.println("it be workin \n");
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		pac.setScale(1);
		pac.eyes = false;
		repaint();
	}


}