package counter;

import java.awt.*;
import javax.swing.*;

public class CounterFrame extends JFrame {
	
	private Counter count;
	private JLabel label = new JLabel("count = 0");
	private JPanel drawing;
	
	public CounterFrame(Counter c, JPanel panel) {
		count = c;
		drawing = panel;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		JPanel p1 = new JPanel(new FlowLayout()); // 맨 위 패널 
		JPanel p2 = new JPanel(new FlowLayout()); // 맨 아래 패널
		
		p1.add(label);
		p2.add(new CountButton("OK", count, this));
		p2.add(new ExitButton("EXIT", count, this));
		
		cp.add(p1, BorderLayout.NORTH);
		cp.add(drawing, BorderLayout.CENTER);
		cp.add(p2, BorderLayout.SOUTH);
		
		setTitle("Counter");
		setSize(220, 280);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void update() {
		label.setText("count = " + count.countOf());
		drawing.repaint();
	}
}
