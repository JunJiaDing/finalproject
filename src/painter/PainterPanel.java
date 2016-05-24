package painter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainterPanel extends JPanel implements ActionListener, ItemListener{

	private DrawPanel drawPanel;
	private JPanel bottomPanel;
	
	private JPanel shapePanel;
	private JButton randgen;
	private JButton randgenVtri;
	private JButton rect;
	private JButton oval;
	
	private JButton colorBtn;
	private JButton color2Btn;
	
	private Color color;
	private Color color2;

	private JPanel actionPanel;
	private JButton clear;
	private JButton undo;
	private JButton redo;
	
	private final int RECT = 1;
	private final int OVAL = 2;
	private final int DIAMOND = 3;

	private JPanel checkPanel;
	private JCheckBox gradient;
    private JCheckBox filled;
    
    private JTextField text;
    private JButton btn;
    
	public PainterPanel(){
		super();
		this.setLayout(new BorderLayout());
		drawPanel = new DrawPanel();
		add(drawPanel, BorderLayout.CENTER);
	    
		bottomPanel = new JPanel();
		
		actionPanel = new JPanel();
		clear = new JButton("Clear");
		clear.addActionListener(this);
		actionPanel.add(clear);
		undo = new JButton("Undo");
		undo.addActionListener(this);
		actionPanel.add(undo);
		redo = new JButton("Redo");
		redo.addActionListener(this);
		actionPanel.add(redo);
		bottomPanel.add(actionPanel);
		
		shapePanel = new JPanel(new GridLayout(2,2));
		randgen = new JButton("Randgen");
		randgen.addActionListener(this);
		shapePanel.add(randgen);
		randgenVtri = new JButton("Randgen Vtri");
		randgenVtri.addActionListener(this);
		shapePanel.add(randgenVtri);
		
		rect = new JButton("Rect");
		rect.addActionListener(this);
		shapePanel.add(rect);
	    oval = new JButton("Oval");
	    oval.addActionListener(this);
	    shapePanel.add(oval);
	    bottomPanel.add(shapePanel);
	    
	    Icon colorIcon = new ImageIcon( getClass().getResource( "color.png" ) );
	    colorBtn = new JButton("C1", colorIcon);
	    colorBtn.addActionListener(this);
	    color2Btn = new JButton("C2", colorIcon);
	    color2Btn.addActionListener(this);

	    bottomPanel.add(colorBtn);
	    bottomPanel.add(color2Btn);
	    
	    checkPanel = new JPanel(new GridLayout(2,1));
        filled = new JCheckBox("Filled");
        filled.addItemListener(this);
        checkPanel.add(filled);
        gradient = new JCheckBox("Gradient");
        gradient.addItemListener(this);
        checkPanel.add(gradient);
        
        bottomPanel.add(checkPanel);
        
        text = new JTextField("",4);
        btn = new JButton("enter");
        btn.addActionListener(this);
        bottomPanel.add(text);
        bottomPanel.add(btn);
        
	    add(bottomPanel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==randgen){
			drawPanel.randgen(10);
		}else if(e.getSource()==randgenVtri){
			drawPanel.randgenVtri(8);
	    }else if(e.getSource()==rect){
			//drawPanel.addShape(RECT);
	    	drawPanel.setShape(RECT);
		}else if(e.getSource()==oval){
			//drawPanel.addShape(OVAL);
			drawPanel.setShape(OVAL);
		}else if(e.getSource()==colorBtn){
			color = JColorChooser.showDialog(PainterPanel.this, "Choose a color", color);
			drawPanel.setColor(color);
			colorBtn.setBackground(color);
		}else if(e.getSource()==color2Btn){
			color2 = JColorChooser.showDialog(PainterPanel.this, "Choose a color", color2);
			drawPanel.setColor2(color2);
			color2Btn.setBackground(color2);
		}else if(e.getSource()==clear){
			drawPanel.clear();
		}
		
	}
	
	public void itemStateChanged(ItemEvent e) 
    {
        // TODO Auto-generated method stub
        if (gradient.isSelected())
        {
            drawPanel.setGradient(true);
        } else
        {
            drawPanel.setGradient(false);
        }
        
        if (filled.isSelected()){
            drawPanel.setFilled(true);
            System.out.println("checkbox -- filled set true");
        } else
        {
            drawPanel.setFilled(false);
            System.out.println("checkbox -- filled set false");
        }
    }
}
