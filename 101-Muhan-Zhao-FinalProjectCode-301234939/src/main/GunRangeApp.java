package main;

import javax.swing.JFrame;

/* Main application base app
 * CREATED: 11/10/2016
 * AUTHOR: HENRY ZHAO*/
public class GunRangeApp extends JFrame
{
	/* WHAT IT DOES: Creates the app 
	 * PARAMETERS: 
	 * 	title - what to name the app
	 * RETURN: NONE*/
	public GunRangeApp(String title) {
		super(title);
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		GunRangePanel ip = new GunRangePanel(this);
		this.add(ip);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);	
	}
	
	/* WHAT IT DOES: main execution of base app to create new GunRangeApp*/
	public static void main(String[] args) {
		new GunRangeApp("The Gun Range");
	}
}
