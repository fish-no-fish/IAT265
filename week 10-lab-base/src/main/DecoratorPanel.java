package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import decorator.EarsDecorator;
import decorator.EyesDecorator;
import decorator.Face;
import decorator.MouthDecorator;
import decorator.NoseDecorator;
import decorator.SimpleFace;


public class DecoratorPanel extends JPanel implements ActionListener {
	public final static int PAN_W = 800;
	public final static int PAN_H = 600;

	Face face;
	
	public DecoratorPanel() {
		this.setBackground(Color.white);
		setPreferredSize(new Dimension(PAN_W, PAN_H));
		setLayout(new FlowLayout());

		JButton simpleFace = new JButton("Simple Face");
		add(simpleFace);
		simpleFace.addActionListener(this);

		JButton eyesDecor = new JButton("Add Eyes");
		add(eyesDecor);
		eyesDecor.addActionListener(this);

		JButton mouthDecor = new JButton("Add Mouth");
		add(mouthDecor);
		mouthDecor.addActionListener(this);

		JButton noseDecor = new JButton("Add Nose");
		add(noseDecor);
		noseDecor.addActionListener(this);
		
		JButton earsDecor = new JButton("Add Ears");
		add(earsDecor);
		earsDecor.addActionListener(this);

		JButton fullDecor = new JButton("Full Face");
		add(fullDecor);
		fullDecor.addActionListener(this);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		if (face != null)
		{
			face.showFace(g2);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Simple Face") {
			face = new SimpleFace();	
		}
		if (e.getActionCommand() == "Add Eyes") {
			Face baseFace = new SimpleFace();
			face = new EyesDecorator(baseFace);
		}
		if (e.getActionCommand() == "Add Mouth") {
			Face baseFace = new SimpleFace();
			face = new MouthDecorator(baseFace);
		}
		if (e.getActionCommand() == "Add Nose") {
			Face baseFace = new SimpleFace();
			face = new NoseDecorator(baseFace);
		}
		if (e.getActionCommand() == "Add Ears") {
			Face baseFace = new SimpleFace();
			face = new EarsDecorator(baseFace);
		}
		if (e.getActionCommand() == "Full Face") {
			face = new EarsDecorator(
					new NoseDecorator(
					new MouthDecorator(
							new EyesDecorator(
									new SimpleFace()
									)
							)
					)
					);
			
		}

		repaint();
	}
}
