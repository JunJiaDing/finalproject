package painter;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rect extends Shape{
	
	public Rect(int x1, int y1, int x2, int y2, Color color){
		super(x1,y1,x2,y2,color);
	}

	public Rect(int x1, int y1, int x2, int y2, Color color, boolean filled){
		super(x1,y1,x2,y2,color,filled);
	}
	
	public Rect(int x1, int y1, int x2, int y2, Color color, Color color2, boolean filled){
		super(x1,y1,x2,y2,color,color2, filled);
	}
	
	public Rect(int x1, int y1, int x2, int y2, Color color, Color color2, boolean filled, boolean isGradient) {
		super(x1,y1,x2,y2,color,color2, filled,isGradient);
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		//g.setColor(color);
		if(isGradient==true && color2!=null){
			g2d.setPaint(new GradientPaint(5,30,color,35,100,color2,true));			
		}else{
			g2d.setPaint(color);
		}

		if(filled){
			g2d.fillRect(Math.min(x1,x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2));
		}else{
			g2d.drawRect(Math.min(x1,x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2));			
		}
		
	}

	@Override
	public String toString() {
		return "Rect [x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + ", color=" + color + ", color2=" + color2
				+ ", isGradient=" + isGradient + ", filled=" + filled + "]";
	}

    
	
}
