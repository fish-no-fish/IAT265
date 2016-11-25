package main;
/* Text class for heads-up display and Game Over screen
 * A demo program created for IAT-265 Spring 15
 * Author: Eric Yang
 * Date of creation: Mar 4 2015
 * All rights reserved
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Text {
	private Font headFont;
	private Font overFont;
	private int scoreBlue;
	private int scoreOrange;

	public Text(int s1, int s2) {
		headFont = new Font("Arial", Font.BOLD, 20);
		overFont = new Font("Arial", Font.BOLD, 65);
		scoreBlue = s1;
		scoreOrange = s2;
	}

	// heads up display
	public void headsUpDisplay(Graphics2D g2) {
		g2.setColor(Color.WHITE);
		g2.setFont(headFont);
		g2.drawString("Score: " + scoreOrange, 30, 25);
		g2.drawString("Score: " + scoreBlue, PongPanel.WIN_W - 110, 25);

	}

	// game over screen
	public void gameOver(Graphics2D g2) {
		g2.setColor(new Color(200, 0, 0));
		g2.fill(new Rectangle2D.Double(PongPanel.WIN_X, PongPanel.WIN_Y,
				PongPanel.WIN_W, PongPanel.WIN_H));

		g2.setFont(overFont);
		g2.setColor(Color.WHITE);
		g2.drawString("GAME OVER", PongPanel.WIN_W / 9, PongPanel.WIN_H / 2);
	}

	public void increaseScoreBlue() {
		scoreBlue++;
	}

	public void increaseScoreOrange() {
		scoreOrange++;
	}
	
	public int getScoreBlue() {
		return scoreBlue;
	}
	public int getScoreOrange() {
		return scoreOrange;
	}
}