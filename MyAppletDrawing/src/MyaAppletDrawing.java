import java.applet.Applet;
import java.awt.*;

public class MyaAppletDrawing extends Applet {
	
	Color faceColor;
	
	public void init()
	{
		faceColor = Color.yellow;
	}
	
	public void paint(Graphics g)
	{
		Dimension size = getSize();
		int d = Math.min(size.width, size.height);
		int ed = d/20;
		int x = (size.width-d)/2;
		int y = (size.height -d)/2;
		
		g.setColor(faceColor);
		g.fillOval(x,y,d,d);

		g.setColor(Color.black);
		g.drawOval(x,y,d,d);
		
//		drawing a hat
		g.fillRoundRect(x+(d*1/10)/2, y, d*9/10, d/5, 100, 100);
		
//		g.fillOval(x+d/3-(ed/2), y+d/3-(ed/2), ed, ed);
//		g.fillOval(x + (2*(d/3))-(ed/2), y+d/3-(ed/2), ed, ed);
		
//		System.out.println(d);
		int newVar = d/10;
//		glass frame
		g.setColor(Color.gray);
		g.fillRect(x+d*1/8, y+d/3-(ed/2)+ed/2, d*3/4, ed/2);
//		new eyes
		g.setColor(Color.black);
		g.fillRect(x+d/3-(ed/2)-newVar, y+d/3-(ed/2), ed+newVar, ed*2);
		g.fillRect(x + (2*(d/3))-(ed/2), y+d/3-(ed/2), ed+newVar, ed*2);
		
//		g.drawArc(x+d/4,  y+2*(d/5), d/2, d/3,0,-180);
//		new mouth
		g.drawArc(x+d/4, y+3*(d/5), d/2, d/3, 0, 180);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
