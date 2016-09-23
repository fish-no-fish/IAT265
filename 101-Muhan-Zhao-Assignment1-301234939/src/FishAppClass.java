import java.awt.Color;

import javax.swing.*;

public class FishAppClass extends JFrame {

	public FishAppClass(String title)
	{
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FishPanel fishPanel = new FishPanel();
		
		this.add(fishPanel);
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FishAppClass("Fishies");
	}

}
