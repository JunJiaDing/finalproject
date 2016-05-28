import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Target {
	int x,y;
	int type;
	boolean died;
	
	private final static String IMAGE_NAME = "target";
    protected ImageIcon images;
    private int TOTAL_IMAGES = 10;
	
	public Target(int x, int y, int type, boolean died){
		this.x = x;
		this.y = y;
		this.type = type*2;
		this.died = died;
	}
	
	void draw(Graphics g){
		if(died)
			type++;
        images = new ImageIcon( getClass().getResource(IMAGE_NAME + type + ".png"));
        images.paintIcon(null, g, x, y);
        
	}
}
