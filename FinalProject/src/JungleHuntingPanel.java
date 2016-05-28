import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JungleHuntingPanel extends JPanel implements MouseListener, MouseMotionListener{
	
	private int difficult;
	private Target targets[];
	private int target_num=10;
	private int target_speed=0;
	private int target_type;
	
	private final int EASY = 0;
	private final int NORMAL = 1;
	private final int HARD = 2;
	
	private final int DOLPHIN = 0;
	private final int CAT = 1;
	private final int SHEEP = 2;
	private final int PIG = 3;
	private final int BIRD = 4;
	private final int FISH = 5;
	
	private ImageIcon background = new ImageIcon( getClass().getResource("BACK.png") );
	private ImageIcon mouse_picture = new ImageIcon( getClass().getResource("heart.png"));
	private int mouse_x;
	private int mouse_y;
	
	private long start;
	private long now;
	private int score;
	
	public JungleHuntingPanel(int difficult){
		super();
		repaint();
		start = System.currentTimeMillis();
		this.difficult = difficult;
		
		switch(difficult){
		    case EASY:
		    	break;
		    case NORMAL:
		    	break;
		    case HARD:
		    	break;	
		}
		
		targets = new Target[target_num];

		addMouseListener(this);
        addMouseMotionListener(this);
	}
	
	public void paintComponent(Graphics g){
        super.paintComponent(g);
            
        background.paintIcon(this, g, 0, 0);
        mouse_picture.paintIcon(this, g, mouse_x, mouse_y);
        
        for(int i=0;i<target_num;i++){
        	if(targets[i]!=null){
        		targets[i].draw(g);
        	}
        }
    }


	@Override
	public void mouseDragged(MouseEvent e) {
		mouse_x = e.getX()-398;
		mouse_y = e.getY()-302;
		
		repaint();
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		mouse_x = e.getX()-398;
		mouse_y = e.getY()-302;
		
		repaint();
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
