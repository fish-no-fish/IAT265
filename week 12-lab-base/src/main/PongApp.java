package main;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/* A App that creates a JFrame window
 * A demo program created for IAT-265 Spring 15
 * Author: Eric Yang
 * Date of creation: Feb 2 2015
 * Date of Modification: Feb 23 2015
 * All rights reserved
 */

public class PongApp extends JFrame {
	public PongApp(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(200, 200);
		PongPanel bp = new PongPanel(this);
		this.add(bp);
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new PongApp("Pong Game");
				
			}
		});
	}
}