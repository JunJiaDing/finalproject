import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class ManuPanel extends JPanel implements ActionListener{
	private JTextArea title;
	private JButton easy;
	private JButton normal;
	private JButton hard;
	private JButton exit;
	
	GridBagConstraints gbc;
	
	private final int EASY = 0;
	private final int NORMAL = 1;
	private final int HARD = 2;
	
	protected ImageIcon background = new ImageIcon( getClass().getResource("BACK.png") );

	public ManuPanel(){
		super();
		repaint();
		this.setLayout(new GridBagLayout() );
		
		gbc = new GridBagConstraints();

		title = new JTextArea("Jungle Hunting");
		title.setFont(new Font(null,Font.BOLD,64));
		title.setEditable(false);;
		title.setOpaque(false);  
		setGridBagConstraints(0,0,1,1);
	    add(title,gbc);
	    
        easy = new JButton("  Easy  ");
        easy.addActionListener(this);
        easy.setFont(new Font(null,Font.BOLD,32));
        setGridBagConstraints(0,1,1,1);
        add(easy,gbc);
        
        normal = new JButton("Normal");
        normal.addActionListener(this);
        normal.setFont(new Font(null,Font.BOLD,32));
        setGridBagConstraints(0,2,1,1);
        add(normal,gbc);
        
        hard = new JButton("  Hard  ");
        hard.addActionListener(this);
        hard.setFont(new Font(null,Font.BOLD,32));
        setGridBagConstraints(0,3,1,1);
        add(hard,gbc);
        
        exit = new JButton("  Exit   ");
        exit.addActionListener(this);
        exit.setFont(new Font(null,Font.BOLD,32));
        setGridBagConstraints(0,4,1,1);
        add(exit,gbc);
        
	}

	
	
	public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        background.paintIcon(this, g, 0, 0);

    }
	
	 void setGridBagConstraints(int gridx, int gridy, int gridheight, int gridwidth){
	        gbc.gridx = gridx;
	        gbc.gridy = gridy;
	        gbc.gridheight = gridheight;
	        gbc.gridwidth = gridwidth;
	    }



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit){
			System.exit(0);
		}
		
	}

}
