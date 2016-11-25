package decorator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import static main.DecoratorPanel.*;

public class EarsDecorator extends FaceDecorator{

	public EarsDecorator(Face baseFace) {
		super(baseFace);
		// TODO Auto-generated constructor stub
	}
	
	public void showFace(Graphics2D g2)
	{
		addEars(g2);
		super.showFace(g2);
	}
	
	private void addEars(Graphics2D g2)
	{
		g2.setColor(Color.yellow);
		Ellipse2D.Double earL, earR;
		earL = new Ellipse2D.Double(PAN_W/2-150-50, PAN_H/2-50, 100, 100);
		earR = new Ellipse2D.Double(PAN_W/2+50+50, PAN_H/2-50, 100, 100);
		g2.fill(earL);
		g2.fill(earR);
		g2.setColor(Color.black);
		g2.draw(earL);
		g2.draw(earR);
	}
}
