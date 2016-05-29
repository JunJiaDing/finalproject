import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JungleHuntingPanel extends JPanel implements MouseListener, MouseMotionListener{
	
	private int difficult;
	private Target targets[];
	private int target_total;
	private int target_type;
	private int target_count;
	private int target_num;
	private int target_x;
	private int target_y;
	private int target_add_frequency;
	
	private final int EASY = 1;
	private final int NORMAL = 2;
	private final int HARD = 3;
	
	private final int DOLPHIN = 0;
	private final int CAT = 1;
	private final int SHEEP = 2;
	private final int PIG = 3;
	private final int BIRD = 4;
	private final int FISH = 5;
	private final int TEACHER = 6;
	
	private ImageIcon background = new ImageIcon( getClass().getResource("BACK.png") );
	private ImageIcon mouse_picture = new ImageIcon( getClass().getResource("heart.png"));
	private int mouse_x;
	private int mouse_y;
	
	private long start;
	private long now;
	private long time;
	private int score;
	Random rand = new Random();
	
	Thread addThread;
	Thread diedThread;
	Thread disappearThread;
	
	private String timeText;
	private String scoreText;
	
	public JungleHuntingPanel(int difficult){
		super();
		repaint();
		setCursor(this.getToolkit().createCustomCursor(new ImageIcon("").getImage(),new Point(16, 16),""));
		start = System.currentTimeMillis();
		this.difficult = difficult;
		score = 0;
		target_num = 0;
		target_count = 0;
		
		
		switch(difficult){
		    case EASY:
		    	target_total = 10;
		    	target_add_frequency = 800;
		    	break;
		    case NORMAL:
		    	target_total = 20;
		    	target_add_frequency = 500;
		    	break;
		    case HARD:
		    	target_total = 50;
		    	target_add_frequency = 300;
		    	break;	
		}
		
		targets = new Target[target_total];

		addMouseListener(this);
        addMouseMotionListener(this);
        
        addStart();
	}
	
	
	public void addStart() {

		addThread = new Thread() {
			public void run() {
				while (true) {
					addTarget();
					repaint();
					try {
						Thread.sleep(target_add_frequency);
					} catch (InterruptedException e) {}
				}
			}
		};
		addThread.start();
		
	}
	
	public void targetDisappear(int n) {
		
		disappearThread = new Thread() {
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {}
				if( targets[n]!=null){
					targets[n] = null;
					target_num--;
					repaint();
				}
			}
		};
	
		
		disappearThread.start();
	}
	
	public void  targetDied(int n){
		diedThread = new Thread() {
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {}
				targets[n] = null;
				target_num--;
				repaint();
			}
		};
	
		
		diedThread.start();
	}
	
	public void paintComponent(Graphics g){
        super.paintComponent(g);
        now = System.currentTimeMillis();
        time = (now - start)/1000;
        scoreText ="score:  " + score;
        if(time>=600)
        	timeText = "time:  " + time/600 + (time/60)%10 + ":" + (time%60)/10 + time%10;
        else 
        	timeText = "time:  " + "  " + time/60 + ":" + (time%60)/10 + time%10;
        background.paintIcon(this, g, 0, 0);
        
        g.setFont(new Font(null, Font.BOLD, 50));
        g.drawString(scoreText, 10, 40);
        g.drawString(timeText, 630, 40);
        
        for(int i=0;i<target_total;i++){
        	if(targets[i]!=null){
        		targets[i].draw(g);
        	}
        }
        
        mouse_picture.paintIcon(this, g, mouse_x, mouse_y);
    }
	
	void addTarget(){
		
		if(target_num<target_total){
			target_type = rand.nextInt(7);
			target_x = rand.nextInt(750);
			target_y = rand.nextInt(300)+50;
			while(true){
				if(targets[target_count]==null){
					targets[target_count] = new Target(target_x,target_y,target_type,false);
					target_num ++;
					targetDisappear(target_count);
					break;
				}
				target_count = (target_count+1)%target_total;
			}
		}
	}

	public void shootTarget(int x, int y){
		for(int i=0;i<target_total;i++){        	
			if(targets[i]!=null ){
				if(! targets[i].isDied() ){
					if(targets[i].shoot(x,y)){
						if( targets[i].getType()==TEACHER){
							gameover();
						}
						targetDied(i);
						score = score*difficult +100;
					}
				}
  			}	
        }
	}
	
	public void gameover(){

		addThread.stop();
		diedThread.stop();
		disappearThread.stop();
		JOptionPane.showMessageDialog(null, "You shooted the teacher!", "Game over", JOptionPane.WARNING_MESSAGE);
		
		removeAll();
		repaint();
		this.setLayout(new BorderLayout() );
		ManuPanel manuPanel = new ManuPanel();
		add(manuPanel,BorderLayout.CENTER);
		manuPanel.revalidate();
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
		shootTarget(e.getX(), e.getY());

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
