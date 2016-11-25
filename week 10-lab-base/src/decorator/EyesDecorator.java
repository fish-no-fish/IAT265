package decorator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import static main.DecoratorPanel.*;

public class EyesDecorator extends FaceDecorator{

	public EyesDecorator(Face baseFace) {
		super(baseFace);
		// TODO Auto-generated constructor stub
	}
	
	public void showFace(Graphics2D g2)
	{
		super.showFace(g2);
		addEyes(g2);
	}
	
	private void addEyes(Graphics2D g2)
	{
		Ellipse2D.Double leftEye, rightEye;
		leftEye = new Ellipse2D.Double(
				PAN_W/2-75,
				PAN_H/2-70,
				30,
				30);
		rightEye = new Ellipse2D.Double(PAN_W/2+45,
				PAN_H/2-70, 30, 30);
		
		g2.setColor(Color.black);
		g2.fill(leftEye);
		g2.fill(rightEye);
		
		g2.draw(leftEye);
		g2.draw(rightEye);
		
		
	}

}
