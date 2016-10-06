/* A Ladybug App that create a JFrame window
 * A demo program created for IAT-265 Spring 15
 * Author: Eric Yang
 * Date of creation: Jan 20 2015
 * Date of Modification: Jan 22 2015
 * All rights reserved
 */

public class BugApp extends javax.swing.JFrame {
	public BugApp(String title) {
		super(title);
		this.setSize(600, 450);
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.add(new BugPanel());
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new BugApp("LadybugApp");
	}
}