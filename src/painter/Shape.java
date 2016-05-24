package painter;
import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
	protected int x1, y1, x2, y2;
	protected Color color;
	protected Color color2;
	protected boolean isGradient;
	protected boolean filled;
	//protected int line;
	public Shape(){
		
	}
	
	public Shape(int x1, int y1, int x2, int y2, Color color){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
	}

	public Shape(int x1, int y1, int x2, int y2, Color color, boolean filled){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
		this.filled = filled;
	}
	
	public Shape(int x1, int y1, int x2, int y2, Color color, Color color2,boolean filled){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
		this.color2 = color2;
		this.filled = filled;
	}
	
	
	public Shape(int x1, int y1, int x2, int y2, Color color, Color color2, boolean filled,
			boolean isGradient) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
		this.color2 = color2;
		this.filled = filled;
		this.isGradient = isGradient;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	
	public Color getColor2() {
		return color2;
	}

	public void setColor2(Color color2) {
		this.color2 = color2;
	}

	public boolean isGradient() {
		return isGradient;
	}

	public void setGradient(boolean isGradient) {
		this.isGradient = isGradient;
	}

	public abstract void draw(Graphics g);
}
