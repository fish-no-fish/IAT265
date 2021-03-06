import javax.swing.JFrame;



//JFrame is a top level container, at the same level as JApplet.
//JFrame provides support and specifies the window operations (what to do whe resize, close, etc)
public class BearAppClass extends JFrame {
	public BearAppClass(String title) {
		super(title);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BearPanel bpnl = new BearPanel();
		
		this.add(bpnl);
		
		this.pack();
		
		this.setVisible(true);
	}
	
	public static void main (String[] args){
		new BearAppClass("BearApp");
	}
}
