package decorator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import static main.DecoratorPanel.*;

public class SimpleFace implements Face{

	@Override
	public void showFace(Graphics2D g2) {
		// TODO Auto-generated method stub
//		draw a yellow circle with black boundary
		Ellipse2D.Double faceShape = new Ellipse2D.Double(
				PAN_W/2-150,
				PAN_H/2-150,
				300,
				300);
		g2.setColor(Color.yellow);
		g2.fill(faceShape);
		g2.setColor(Color.black);
		g2.draw(faceShape);
	}

}
