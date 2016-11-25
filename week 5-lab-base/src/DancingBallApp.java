/* A App that creates a JFrame window
 * A demo program created for IAT-265 Spring 15
 * Author: Eric Yang
 * Date of creation: Jan 20 2015
 * All rights reserved
 */
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class DancingBallApp extends JFrame {

	public DancingBallApp(String title) {
		super(title);
		//this.setSize(600, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DancingBallPanel bpnl = new DancingBallPanel();
		this.add(bpnl);
		this.pack(); 	// collaborate with JPanel's setPreferredSize(int w, int h)
						// to guarantee BallPanel has the desired width/height
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new DancingBallApp("BallApp");
	}
}
