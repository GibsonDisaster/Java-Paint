package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

public class Application extends JPanel implements ActionListener, KeyListener {

	private JFrame frame;
	private JButton exitButton, drawButton;
	private JRadioButton fillToggle;
	private JPanel buttonPanel, settingsPanel;
	private JSlider width, height, angle;
	private int x, y, randEndAngle, randStartAngle;
	private int randShape, randColor;
	private boolean toggled = false;
	
	public Application(String title) {
		initComps(title);
	}
	
	private void initComps(String title) { //A monster of a method
		frame = new JFrame(title);
		exitButton = new JButton("exit");
		exitButton.setFocusable(false);
		drawButton = new JButton("draw");
		drawButton.setFocusable(false);
		fillToggle = new JRadioButton("fill");
		fillToggle.setFocusable(false);
		width = new JSlider();
		height = new JSlider();
		angle = new JSlider();
		x = 300;
		y = 150;
		buttonPanel = new JPanel();
		settingsPanel = new JPanel();
		
		//Width Slider setup
		width.setMaximum(200);
		width.setMinimum(0);
		width.setMajorTickSpacing(50);
		width.setMinorTickSpacing(10);
		width.setPaintTicks(true);
		width.setPaintLabels(true);
		width.setToolTipText("width");
		width.setFocusable(false);
		
		//Height Slider setup
		height.setMaximum(200);
		height.setMinimum(0);
		height.setMajorTickSpacing(50);
		height.setMinorTickSpacing(10);
		height.setPaintTicks(true);
		height.setPaintLabels(true);
		height.setToolTipText("height");
		height.setFocusable(false);
		
		angle.setMaximum(360);
		angle.setMinimum(0);
		angle.setMajorTickSpacing(90);
		angle.setMinorTickSpacing(10);
		angle.setPaintTicks(true);
		angle.setPaintLabels(true);
		angle.setToolTipText("angle");
		angle.setFocusable(false);
		
		settingsPanel.add(width);
		settingsPanel.add(height);
		settingsPanel.add(angle);
		
		buttonPanel.add(exitButton);
		buttonPanel.add(drawButton);
		buttonPanel.add(fillToggle);
		
		this.setSize(new Dimension(640, 480));
		
		fillToggle.addActionListener(this);
		exitButton.addActionListener(this);
		drawButton.addActionListener(this);
		
		//Frame setup
		frame.setLayout(new BorderLayout());
		frame.setPreferredSize(new Dimension(640, 480));
		frame.setMinimumSize(new Dimension(640, 480));
		frame.setMaximumSize(new Dimension(640, 480));
		frame.add(this, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.addKeyListener(this);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		frame.add(settingsPanel, BorderLayout.NORTH);
		frame.setUndecorated(true);
		
		//Make a starter shape, color, and angle (if applicable)
		newDrawing();
		
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		Application app = new Application("Drawer");
	}
	
	public void newDrawing() { //Creates new random values for drawing
		Random rand = new Random();
		
		randShape = rand.nextInt(4); // 0 1 2 3
		randColor = rand.nextInt(6); // 0 1 2 3 4 5
		randEndAngle = rand.nextInt(280) + 20;
		randStartAngle = rand.nextInt(280) + 20;
	}
	
	public void paintComponent(Graphics g) {
		//Select the color from the random number
		switch(randColor) {
			case 0:
				g.setColor(Color.BLACK);
				break;
			case 1:
				g.setColor(Color.BLUE);
				break;
			case 2:
				g.setColor(Color.red);
				break;
			case 3:
				g.setColor(Color.GREEN);
				break;
			case 4:
				g.setColor(Color.ORANGE);
				break;
			case 5:
				g.setColor(Color.YELLOW);
				break;
		}
		//Select the shape from the random shape
		switch(randShape) {
			case 0:
				if (toggled)
					g.fillRect(x, y, width.getValue(), height.getValue());
				else
					g.drawRect(x, y, width.getValue(), height.getValue());
				break;
			case 1:
				if (toggled)
					g.fillOval(x, y, width.getValue(), height.getValue());
				else
					g.drawOval(x, y, width.getValue(), height.getValue());
				break;
			case 2:
				if (toggled)
					g.fillRoundRect(x, y, width.getValue(), height.getValue(), 20, 20);
				else
					g.drawRoundRect(x, y, width.getValue(), height.getValue(), 20, 20);
				break;
			case 3:
				if (toggled)
					g.fillArc(x, y, width.getValue(), height.getValue(), 90, angle.getValue());
				else
					g.drawArc(x, y, width.getValue(), height.getValue(), 90, angle.getValue());
				break;
		}
		
		//Draw a black border around drawing pane
		g.setColor(Color.BLACK);
		g.drawRect(-10, 0, 660, 356);
		
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitButton) {
			System.exit(0);
		}
		
		if (e.getSource() == drawButton) {
			newDrawing();
		}
		
		if (e.getSource() == fillToggle) {
			this.repaint();
			toggled = !toggled;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP)
			y -= 10;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			y += 10;
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			x -= 10;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			x += 10;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {		
	}
}
