package painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class VTriangle extends Shape{
	
	protected int type=1;
	
	protected final int UP_LEFT = 1;
	protected final int UP_RIGHT = 2;
	protected final int DOWN_LEFT = 3;
	protected final int DOWN_RIGHT = 4;


	public VTriangle(){
		super();
	}
	
	public VTriangle(int x1, int y1, int x2, int y2, Color color, int type){
		super(x1,y1,x2,y2,color);
		this.type = type;
	}

	public VTriangle(int x1, int y1, int x2, int y2, Color color, boolean filled, int type){
		super(x1,y1,x2,y2,color,filled);
		this.type = type;
	}

	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Polygon poly = null;
		//g.setColor(color);
		g2d.setPaint(color);
		int tx1 = Math.min(x1,x2);
		int ty1 = Math.min(y1,y2);
		int tx4 = Math.max(x1,x2);
		int ty4 = Math.max(y1,y2);
		int tx2 = tx4;
		int ty2 = ty1;
		int tx3 = tx1;
		int ty3 = ty4;
		
		
		switch(type){
		case UP_LEFT:
			poly = new Polygon(
	                new int[]{tx1, tx3, tx4},
	                new int[]{ty1, ty3, ty4},
	                3);
			break;
		case UP_RIGHT:
			poly = new Polygon(
	                new int[]{tx2, tx3, tx4},
	                new int[]{ty2, ty3, ty4},
	                3);
			break;
			
		case DOWN_LEFT:
			poly = new Polygon(
	                new int[]{tx1, tx2,tx3},
	                new int[]{ty1, ty2,ty3},
	                3);
			break;
			
		case DOWN_RIGHT:
			poly = new Polygon(
	                new int[]{tx1, tx2,tx4},
	                new int[]{ty1, ty2,ty4},
	                3);
			break;
		}	
		if(filled){
			g2d.fill(poly);
		}else{
			g2d.draw(poly);			
		}
		
	}

	@Override
	public String toString() {
		return "VTriangle [type=" + type + ", UP_LEFT=" + UP_LEFT + ", UP_RIGHT=" + UP_RIGHT + ", DOWN_LEFT="
				+ DOWN_LEFT + ", DOWN_RIGHT=" + DOWN_RIGHT + "]";
	}

	
}
