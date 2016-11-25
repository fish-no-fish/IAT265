package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import sound.Sound;
import util.Util;

public class PongPanel extends JPanel implements ActionListener, MouseMotionListener {

	public final static int WIN_W = 500;
	public final static int WIN_H = 400;
	public final static int WIN_X = 0;
	public final static int WIN_Y = 0;

	public static BufferedImage background;

	private JFrame frame;

	private Timer timer;
	private int score_blue;
	private int score_orange;
	private Text txt;

	private BouncingBall ball;

	private boolean upBlue, downBlue;
	private boolean upOrange, downOrange;

	private Bat blueBat, orangeBat;

	private JButton playButton;
	private boolean replay = false;
	
	private int mouseY;
	
	public PongPanel(JFrame frame) {
		super();
		setPreferredSize(new Dimension(WIN_W, WIN_H));
		background = loadImage("/assets/background.png");
		
		
		this.frame = frame;
		timer = new Timer(30, this);
		timer.start();

		upBlue = false;
		downBlue = false;

		ball = new BouncingBall();
		blueBat = new Bat(WIN_W - 25, Color.blue, "bat.png");
		orangeBat = new Bat(25, Color.orange, "bat1.png");

		score_blue = 0;
		score_orange = 0;
		txt = new Text(score_blue, score_orange);

		playButton = new JButton("Replay");
		add(playButton, BorderLayout.NORTH);
		playButton.setVisible(false);
		playButton.addActionListener(this);

		
		mouseY = WIN_H/3*2;
		addMouseMotionListener(this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g.drawImage(background, WIN_X, WIN_Y, WIN_W, WIN_H, this);
		ball.drawMe(g2);
		blueBat.drawMe(g2, mouseY);
		orangeBat.drawMe(g2);
		
		txt.headsUpDisplay(g2);

		if (txt.getScoreBlue() == 3 || txt.getScoreOrange() == 3) {
			txt.gameOver(g2);
			timer.stop();
			playButton.setVisible(true);
			replay = true;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {


		String scoreWinner = ball.walls();

		if (scoreWinner == "orange") {
			txt.increaseScoreOrange();
		}
		if (scoreWinner == "blue") {
			txt.increaseScoreBlue();
		}

		if (Util.random(0, 100) > 50){
			
			if (orangeBat.getBound().getY()-ball.getPosY() > 0){
				orangeBat.move(-8);
			}
			if (orangeBat.getBound().getY()-ball.getPosY() < 0){
				orangeBat.move(8);
			}
		}
		
		if (blueBat.hitBall(ball)){
			ball.reverseChangeX(blueBat);
			Sound.play("/assets/bounce1.wav");
//			song.rewind();
//			song.play();
			
		}
		if (orangeBat.hitBall(ball)){
			ball.reverseChangeX(orangeBat);
			Sound.play("/assets/bounce1.wav");
//			song.rewind();
//			song.play();
		}

		ball.move();
		repaint();

		if (replay) {
			frame.dispose();
			frame = new PongApp("Pong Game");
		}

	}

	public BufferedImage loadImage(String fileName) {
		BufferedImage bfImg = null;
		try {
			bfImg = ImageIO.read(getClass().getResourceAsStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bfImg;

	}



	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseY = e.getY();
		
	}
}
