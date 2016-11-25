package decorator;

import java.awt.*;
import java.awt.geom.Arc2D;
import static main.DecoratorPanel.*;

public class MouthDecorator extends FaceDecorator{

	public MouthDecorator(Face baseFace) {
		super(baseFace);
		// TODO Auto-generated constructor stub
	}
	
	public void showFace(Graphics2D g2)
	{
		super.showFace(g2);
		addMouth(g2);
	}
	
	private void addMouth(Graphics2D g2)
	{
		Arc2D.Double mouth = new Arc2D.Double(
				PAN_W/2-125, PAN_H/2-350,
				250, 450, -60, -60, Arc2D.OPEN);
		g2.draw(mouth);
	}

}
