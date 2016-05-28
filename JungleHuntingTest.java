import java.awt.BorderLayout;

import javax.swing.JFrame;


public class JungleHuntingTest {

	public static void main(String[] args) {
		JFrame app = new JFrame("Jungle Hunting");
	    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    app.setResizable(false);
	    app.setLayout(new BorderLayout());
	    //app.add(new Panel(), BorderLayout.CENTER);
	    app.setLocationRelativeTo(null);//出現在螢幕的正中間
	    app.setSize(900, 700);
	    app.setVisible(true);

	}

}
