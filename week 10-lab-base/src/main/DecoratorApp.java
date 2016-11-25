package main;
import javax.swing.JFrame;

public class DecoratorApp extends JFrame{
	
	public DecoratorApp(String title) {
		super(title);
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setLocation(200, 100);
		DecoratorPanel ip = new DecoratorPanel();
		this.add(ip);
		this.pack();
		this.setVisible(true);	
	}
	
	public static void main(String[] args) {
		new DecoratorApp("Decorator App");
	}

}
