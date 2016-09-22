import java.awt.Color;
import java.awt.Graphics;



public class Bear {


	

		// instance variables

		private int xPos;
		private int yPos;
		private int scale = 2;
		private int bearW = scale * 30;
		private int bearH = scale * 70;
		private Color bearColor = new Color(183, 114, 30);
		private Color outlineColor = new Color(0, 0, 0);
		private Color defaultColor=bearColor;

		public Bear() {
			// TODO Auto-generated constructor stub
			xPos = BearPanel.WIN_WIDTH / 2;
			yPos = BearPanel.WIN_HEIGHT / 2;
		}

		public void drawBear(Graphics g) {
			// legs
			g.setColor(bearColor);
			g.fillOval(xPos - scale * 35, yPos + scale * 20, scale * 70, scale * 70);
			g.setColor(outlineColor);
			g.drawOval(xPos - scale * 35, yPos + scale * 20, scale * 70, scale * 70);

			// body
			g.setColor(bearColor);
			g.fillOval(xPos - scale * 20, yPos - scale * 20, scale * 40, scale * 80);
			g.setColor(outlineColor);
			g.drawOval(xPos - scale * 20, yPos - scale * 20, scale * 40, scale * 80);

			// left arm
			g.setColor(bearColor);
			g.fillOval(xPos - scale * 28, yPos, scale * 16, scale * 40);
			g.setColor(outlineColor);
			g.drawOval(xPos - scale * 28, yPos, scale * 16, scale * 40);

			// right arm
			g.setColor(bearColor);
			g.fillOval(xPos + scale * 12, yPos, scale * 16, scale * 40);
			g.setColor(outlineColor);
			g.drawOval(xPos + scale * 12, yPos, scale * 16, scale * 40);

			// left ear
			g.setColor(bearColor);
			g.fillOval(xPos - scale * 28, yPos - scale * 40, scale * 16, scale * 16);
			g.setColor(outlineColor);
			g.drawOval(xPos - scale * 28, yPos - scale * 40, scale * 16, scale * 16);

			// right ear
			g.setColor(bearColor);
			g.fillOval(xPos + scale * 12, yPos - scale * 40, scale * 16, scale * 16);
			g.setColor(outlineColor);
			g.drawOval(xPos + scale * 12, yPos - scale * 40, scale * 16, scale * 16);

			// head
			g.setColor(bearColor);
			g.fillOval(xPos - scale * 20, yPos - scale * 40, scale * 40, scale * 40);
			g.setColor(outlineColor);
			g.drawOval(xPos - scale * 20, yPos - scale * 40, scale * 40, scale * 40);

			// face
			g.setColor(bearColor);
			g.fillOval(xPos - scale * 8, yPos - scale * 20, scale * 16, scale * 16);
			g.setColor(outlineColor);
			g.drawOval(xPos - scale * 8, yPos - scale * 20, scale * 16, scale * 16);

			// left eye
			g.setColor(new Color(247, 202, 147));
			g.fillOval(xPos - scale * 16, yPos - scale * 30, scale * 16, scale * 16);
			g.setColor(outlineColor);
			g.drawOval(xPos - scale * 16, yPos - scale * 30, scale * 16, scale * 16);

			// right eye
			g.setColor(new Color(247, 202, 147));
			g.fillOval(xPos, yPos - scale * 30, scale * 16, scale * 16);
			g.setColor(outlineColor);
			g.drawOval(xPos, yPos - scale * 30, scale * 16, scale * 16);

			// left iris
			g.setColor(new Color(180, 180, 255));
			g.fillOval(xPos - scale * 11, yPos - scale * 25, scale * 6, scale * 6);
			g.setColor(outlineColor);
			g.drawOval(xPos - scale * 11, yPos - scale * 25, scale * 6, scale * 6);

			// right iris
			g.setColor(new Color(180, 180, 255));
			g.fillOval(xPos + scale * 5, yPos - scale * 25, scale * 6, scale * 6);
			g.setColor(outlineColor);
			g.drawOval(xPos + scale * 5, yPos - scale * 25, scale * 6, scale * 6);

			// left pupil
			g.setColor(bearColor);
			g.fillOval(xPos - scale * 9, yPos - scale * 23, scale * 2, scale * 2);
			g.setColor(outlineColor);
			g.drawOval(xPos - scale * 9, yPos - scale * 23, scale * 2, scale * 2);

			// right pupil
			g.setColor(bearColor);
			g.fillOval(xPos + scale * 7, yPos - scale * 23, scale * 2, scale * 2);
			g.setColor(outlineColor);
			g.drawOval(xPos + scale * 7, yPos - scale * 23, scale * 2, scale * 2);

			// lips
			g.setColor(Color.BLACK);
			g.fillOval(xPos - scale * 4, yPos - scale * 12, scale * 8, scale * 3);
			g.setColor(outlineColor);
			g.drawOval(xPos - scale * 4, yPos - scale * 12, scale * 8, scale * 3);
		}

		public int getScale() {
			return scale;
		}
		
		public void setScale(int s){
			scale = s;
		}
		
		public void setColor (Color c){
			bearColor = c;
		}

		public boolean checkPointHit(int x, int y) {
			boolean hit = false;
			if (x > xPos - bearW && 
					x < xPos + bearW && 
					y > yPos - bearH + 30 && 
					y < yPos + bearH + 40) {
				hit = true;
			}
			return hit;
		}
		
		
		public Color getDefaultColor(){
			return defaultColor;
		
		}

	}

