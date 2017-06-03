package other;

import java.awt.Color;

public class Shape {
	
	private int x, y, width, height;
	private String shape;
	private Color c;
	
	public Shape(int x, int y, int w, int h,Color c, String shape) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		this.shape = shape;
		this.c = c;
	}

	//Getters and Setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}
	
	public Color getColor() {
		return this.c;
	}
}
