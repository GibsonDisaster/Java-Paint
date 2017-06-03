package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.MouseInputListener;

import other.Shape;

public class Paint extends JPanel implements ActionListener, MouseListener, MouseInputListener {

	private static final long serialVersionUID = -4216819362826797037L;
	private JFrame frame;
	private JPanel toolPanel;
	private JButton clear, redButton, orangeButton, yellowButton, greenButton, blueButton, pinkButton, blackButton, rect, oval;
	private JSlider width, height;
	private int i;
	private ArrayList<Shape> shapes;
	private Color currentColor;
	private String currentShape;
	
	public Paint() {
		initComps();
		shapes = new ArrayList<Shape>();
		currentColor = Color.red;
		currentShape = "rect";
	}
	
	private void initComps() {
		//JButton Inits
		clear = new JButton("clear");
		clear.addActionListener(this);
		clear.setFocusable(false);
		
		redButton = new JButton("red");
		redButton.addActionListener(this);
		redButton.setFocusable(false);
		
		blackButton = new JButton("black");
		blackButton.addActionListener(this);
		blackButton.setFocusable(false);
		
		rect = new JButton("rect");
		rect.addActionListener(this);
		rect.setFocusable(false);
		
		oval = new JButton("oval");
		oval.addActionListener(this);
		oval.setFocusable(false);
		
		orangeButton = new JButton("orange");
		orangeButton.addActionListener(this);
		orangeButton.setFocusable(false);
		
		yellowButton = new JButton("yellow");
		yellowButton.addActionListener(this);
		yellowButton.setFocusable(false);
		
		greenButton = new JButton("green");
		greenButton.addActionListener(this);
		greenButton.setFocusable(false);
		
		blueButton = new JButton("blue");
		blueButton.addActionListener(this);
		blueButton.setFocusable(false);
		
		pinkButton = new JButton("pink");
		pinkButton.addActionListener(this);
		pinkButton.setFocusable(false);
		
		//Slider Inits
		width = new JSlider();
		width.setMaximum(200);
		width.setMinimum(0);
		width.setMajorTickSpacing(50);
		width.setMinorTickSpacing(10);
		width.setPaintTicks(true);
		width.setPaintLabels(true);
		width.setToolTipText("width");
		width.setFocusable(false);
		
		height = new JSlider();
		height.setMaximum(200);
		height.setMinimum(0);
		height.setMajorTickSpacing(50);
		height.setMinorTickSpacing(10);
		height.setPaintTicks(true);
		height.setPaintLabels(true);
		height.setToolTipText("height");
		height.setFocusable(false);
		
		//toolPanel Inits
		toolPanel = new JPanel();
		toolPanel.add(clear);
		toolPanel.add(rect);
		toolPanel.add(oval);
		toolPanel.add(blackButton);
		toolPanel.add(redButton);
		toolPanel.add(orangeButton);
		toolPanel.add(yellowButton);
		toolPanel.add(greenButton);
		toolPanel.add(blueButton);
		toolPanel.add(pinkButton);
		toolPanel.add(width);
		toolPanel.add(height);
		
		//this Inits
		this.setSize(new Dimension(1280, 681));
		
		//Frame Inits
		frame = new JFrame("Paint");
		frame.setSize(new Dimension(1280, 720));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		frame.add(toolPanel, BorderLayout.SOUTH);
		frame.add(this, BorderLayout.CENTER);
		frame.addMouseListener(this);
		frame.addMouseMotionListener(this);
		
		frame.setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		for (Shape s : shapes) {
			g.setColor(s.getColor());
			switch(s.getShape()) {
				case "rect":
					g.fillRect(s.getX(), s.getY(), s.getWidth(), s.getHeight());
					break;
				case "oval":
					g.fillOval(s.getX(), s.getY(), s.getWidth(), s.getHeight());
					break;
			}
		}
	}
	
	public static void main(String[] args) {
		new Paint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clear) {
			shapes.clear();
			this.repaint();
		}
		if (e.getSource() == redButton)
			currentColor = Color.red;
		if (e.getSource() == blackButton)
			currentColor = Color.black;
		if (e.getSource() == orangeButton)
			currentColor = Color.ORANGE;
		if (e.getSource() == yellowButton)
			currentColor = Color.YELLOW;
		if (e.getSource() == greenButton)
			currentColor = Color.GREEN;
		if (e.getSource() == blueButton)
			currentColor = Color.BLUE;
		if (e.getSource() == pinkButton)
			currentColor = Color.pink;
		if (e.getSource() == rect)
			currentShape = "rect";
		if (e.getSource() == oval)
			currentShape = "oval";
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		shapes.add(new Shape(e.getX() - 40, e.getY() - 40, width.getValue(), height.getValue(), currentColor, currentShape));
		this.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		shapes.add(new Shape(e.getX() - 40, e.getY() - 40, width.getValue(), height.getValue(), currentColor, currentShape));
		this.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		shapes.add(new Shape(e.getX() - 40, e.getY() - 40, width.getValue(), height.getValue(), currentColor, currentShape));
		this.repaint();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
}
