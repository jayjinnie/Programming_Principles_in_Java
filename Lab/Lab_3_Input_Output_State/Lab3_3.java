import java.awt.*;
import javax.swing.*;

public class Lab3_3 extends JPanel {
	
	private int SIZE = 100, X = 3, Y = 2;
	private int WIDTH = X * SIZE, HEIGHT = Y * SIZE;
	private int width = WIDTH, height = HEIGHT, x = 0, y = 0;
	
	public Lab3_3() {
		JFrame f = new JFrame();
		f.getContentPane().add(this);
		f.setTitle("Egg");
		f.setSize(WIDTH, HEIGHT + 22);
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.pink);
		g.fillRect(0,  0,  WIDTH,  HEIGHT);
		g.setColor(Color.yellow);
		g.fillOval(x, y, width, height);
		
		x = x + X  * 5;
		y = y + Y * 5;
		
		width = width - X * 10;
		height = height - Y * 10;
	}
	
	public static void main(String[] args) {
		new Lab3_3();
	}
}