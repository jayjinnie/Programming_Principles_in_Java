package counter;

import java.awt.event.*;
import javax.swing.*;

public class ExitButton extends JButton implements ActionListener {
	
	private Counter count;
	private CounterFrame view;
	
	public ExitButton(String label, Counter m, CounterFrame v) {
		super(label);
		count = m;
		view = v;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
		view.update();
	}
}
