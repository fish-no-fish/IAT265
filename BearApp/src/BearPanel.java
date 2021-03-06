

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;




public class BearPanel extends JPanel implements MouseListener {
	public static final int WIN_WIDTH = 600;
	public static final int WIN_HEIGHT = 600;
	private Bear bear, bear2, bear3, bear4;

	public BearPanel() {
		super();
		this.setPreferredSize(new Dimension(WIN_WIDTH , WIN_HEIGHT));

		bear = new Bear(100,100);
		bear2 = new Bear(400, 100);
		bear3 = new Bear(100, 400);
		bear4 = new Bear(400, 400);

		this.setBackground(Color.white);

		addMouseListener(this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		bear.drawBear(g);
		bear2.drawBear(g);
		bear3.drawBear(g);
		bear4.drawBear(g);

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
		int x = e.getX();
		int y = e.getY();
		int currentScale = bear.getScale();
		if (bear.checkPointHit(x, y)) {
			bear.setScale(currentScale + 1);
			bear.setColor(new Color(139, 99, 55));
		}
		int currentScale2 = bear2.getScale();
		if (bear2.checkPointHit(x, y)) {
			bear2.setScale(currentScale + 1);
			bear2.setColor(new Color(139, 99, 55));
		}
		int currentScale3 = bear3.getScale();
		if (bear3.checkPointHit(x, y)) {
			bear3.setScale(currentScale + 1);
			bear3.setColor(new Color(139, 99, 55));
		}
		int currentScale4 = bear4.getScale();
		if (bear4.checkPointHit(x, y)) {
			bear4.setScale(currentScale + 1);
			bear4.setColor(new Color(139, 99, 55));
		}
		
		repaint();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		int currentScale = bear.getScale();
		if (bear.checkPointHit(x, y)) {
			bear.setScale(currentScale - 1);
			bear.setColor(bear.getDefaultColor());
		}
		int currentScale2 = bear2.getScale();
		if (bear2.checkPointHit(x, y)) {
			bear2.setScale(currentScale - 1);
			bear2.setColor(bear2.getDefaultColor());
		}
		int currentScale3 = bear3.getScale();
		if (bear3.checkPointHit(x, y)) {
			bear3.setScale(currentScale - 1);
			bear3.setColor(bear3.getDefaultColor());
		}
		int currentScale4 = bear4.getScale();
		if (bear4.checkPointHit(x, y)) {
			bear4.setScale(currentScale - 1);
			bear4.setColor(bear4.getDefaultColor());
		}
		
		repaint();


	}


}
