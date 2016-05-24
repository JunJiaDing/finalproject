package painter;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JPanel;

public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener{

	private Shape shapes[];
	private Shape currentShape;
	private int numShapes;
	private int x1, y1, x2, y2;
	private Color color;
	private Color color2;
	private boolean isGradient;
	private boolean filled;
	
	
	private final int MAX = 100;
	
	private int shapeType=1;
	private final int SHAPES = 3;
	private final int RECT = 1;
	private final int OVAL = 2;
	private final int VTRIANGLE = 3;
	
	private int vtriType;
	
	public DrawPanel(){
		super();
		shapes = new Shape[MAX];
		addMouseListener(this);
		addMouseMotionListener(this);
		repaint();
	}
	
	public void setColor(Color color){
		this.color = color;
		System.out.println(color);
	}
	
	public void setColor2(Color color2){
		this.color2 = color2;
		System.out.println(color2);
	}
	
	public void clear(){
		numShapes = 0;
		repaint();
	}
	
	public void setShape(int shapeType){
		this.shapeType = shapeType;
	}
	
	public void setGradient(boolean isGradient) {
		this.isGradient = isGradient;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
		
	}

	public void addShape(int shapeType){
		Random rand = new Random();
		x1 = rand.nextInt(500);
		y1 = rand.nextInt(500);
		x2 = rand.nextInt(500);
		y2 = rand.nextInt(500);
		filled = rand.nextBoolean();
		vtriType = rand.nextInt(4)+1;
		switch(shapeType){
		case RECT:
			shapes[numShapes++] = new Rect(x1,y1,x2,y2,color,color2, filled);		
			break;
		case OVAL:
			shapes[numShapes++] = new Oval(x1,y1,x2,y2,color,color2, filled);	
			break;
		case VTRIANGLE:
			shapes[numShapes++] = new VTriangle(x1,y1,x2,y2,color,filled,vtriType);	
			break;	
		}
		repaint();

	}
	
	public void randgen(int num){
		Random rand = new Random();
		
		for(int i=0;i<num;i++){
			x1 = rand.nextInt(500);
			y1 = rand.nextInt(500);
			x2 = rand.nextInt(500);
			y2 = rand.nextInt(500);
			color = new Color(rand.nextInt(255), rand.nextInt(255),rand.nextInt(255));
			filled = rand.nextBoolean();
			shapeType = rand.nextInt(SHAPES)+1;
			switch(shapeType){
			case RECT:
				shapes[numShapes++] = new Rect(x1,y1,x2,y2,color,filled);		
				break;
			case OVAL:
				shapes[numShapes++] = new Oval(x1,y1,x2,y2,color,filled);	
				break;
			}
			
		}		
		repaint();
	}
	
	public void randgenVtri(int num){
		Random rand = new Random();
		
		for(int i=0;i<num;i++){
			x1 = rand.nextInt(500);
			y1 = rand.nextInt(500);
			x2 = rand.nextInt(500);
			y2 = rand.nextInt(500);
			color = new Color(rand.nextInt(255), rand.nextInt(255),rand.nextInt(255));
			filled = rand.nextBoolean();
			vtriType = rand.nextInt(4)+1;
			shapes[numShapes++] = new VTriangle(x1,y1,x2,y2,color,filled,vtriType);					
		}		
		repaint();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(int i=0;i<numShapes;i++){
			shapes[i].draw(g);
			System.out.println("paintComponent: "+shapes[i]);
		}
		if(currentShape!=null)
			currentShape.draw(g);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		currentShape.x2 = e.getX();
		currentShape.y2 = e.getY();
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
		x2 = x1;
		y2 = y1;
		switch(shapeType){
		case RECT:
			System.out.println("x1= "+x1+" y1="+y1);
			currentShape = new Rect(x1,y1,x2,y2,color,color2,filled,isGradient);	
			System.out.println("after CurrentShape: Rect "+currentShape);
			break;
		case OVAL:
			currentShape = new Oval(x1,y1,x2,y2,color,color2,filled,isGradient);	
			System.out.println("CurrentShape: Oval "+currentShape);
			break;
		}
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		switch(shapeType){
		case RECT:
			shapes[numShapes++] = new Rect(x1,y1,x2,y2,color,color2,filled,isGradient);		
			break;
		case OVAL:
			shapes[numShapes++] = new Oval(x1,y1,x2,y2,color,color2,filled,isGradient);	
			break;
		}
		currentShape = null;
		repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
