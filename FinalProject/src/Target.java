import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Target {
	int x,y;
	int type;
	boolean died;
	
	private final static String IMAGE_NAME = "target";
    protected ImageIcon images;
    private int TOTAL_IMAGES = 10;
    
    private final int DOLPHIN = 0;
	private final int CAT = 1;
	private final int SHEEP = 2;
	private final int PIG = 3;
	private final int BIRD = 4;
	private final int FISH = 5;
	private final int TEACHER = 6;
	
	public Target(int x, int y, int type, boolean died){
		this.x = x;
		this.y = y;
		this.type = type;
		this.died = died;
	}
	
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean isDied() {
		return died;
	}

	public void setDied(boolean died) {
		this.died = died;
	}
	
	
	public ImageIcon getImages() {
		return images;
	}

	public void setImages(ImageIcon images) {
		this.images = images;
	}

	void draw(Graphics g){
		if(died)
			images = new ImageIcon( getClass().getResource(IMAGE_NAME + type + "_died.png"));
		else
			images = new ImageIcon( getClass().getResource(IMAGE_NAME + type + ".png"));
        images.paintIcon(null, g, x, y);
	}
	
	boolean shoot(int x1, int y1){
		if( x1 >= x && y1 >= y && x1 <= ( x+images.getIconWidth() ) && y1 <= ( y+images.getIconHeight() )){
			died = true;
			return true;
		}
		return false;
	}

}
