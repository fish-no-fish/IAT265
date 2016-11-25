package decorator;

import java.awt.Graphics2D;

public class FaceDecorator implements Face{

	protected Face baseFace;
	
	public FaceDecorator(Face baseFace)
	{
		this.baseFace = baseFace;
	}
	
	@Override
	public void showFace(Graphics2D g2) {
		// TODO Auto-generated method stub
		baseFace.showFace(g2);
	}
	
}
