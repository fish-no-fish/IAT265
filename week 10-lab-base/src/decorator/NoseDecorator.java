package decorator;

import java.awt.Graphics2D;
import static main.DecoratorPanel.*;

public class NoseDecorator extends FaceDecorator{

	public NoseDecorator(Face baseFace) {
		super(baseFace);
		// TODO Auto-generated constructor stub
	}
	
	public void showFace(Graphics2D g2)
	{
		super.showFace(g2);
		addNose(g2);
	}
	
	private void addNose(Graphics2D g2)
	{
		g2.fillPolygon(
				new int[]{
						PAN_W/2-10, PAN_W/2+10, PAN_W/2},
				new int[]{
						PAN_H/2+15, PAN_H/2+15, PAN_H/2-20}, 
				3);
		
	}
}
