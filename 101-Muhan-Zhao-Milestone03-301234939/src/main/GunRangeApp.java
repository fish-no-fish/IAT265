package main;

import javax.swing.JFrame;

public class GunRangeApp extends JFrame
{
	public GunRangeApp(String title) {
		super(title);
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		GunRangePanel ip = new GunRangePanel(this);
		this.add(ip);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);	
	}
	
	public static void main(String[] args) {
		new GunRangeApp("The Gun Range");
	}
}