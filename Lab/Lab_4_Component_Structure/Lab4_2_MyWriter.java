import java.awt.*;
import javax.swing.*;

/* MyWriter - 문장을 디스플레이할 그래픽스 윈도우를 만듦 */
public class MyWriter extends JPanel {

	private int width, height;
	private String sentence = "";
	private int x_position, y_position;
	
	/* MyWriter - constructor 메소드, 가로 w픽셀, 세로 h픽셀 크기의 창을 생성함
	 * @param w - 창의 너비
	 * @param h - 창의 높이 */
	public MyWriter(int w, int h) {
		width = w;
		height = h;
		x_position = width / 5;
		y_position = height / 2;
		JFrame my_frame = new JFrame();
		my_frame.getContentPane().add(this);
		my_frame.setTitle("MyWriter");
		my_frame.setSize(width + 16, height + 39);
		my_frame.setVisible(true);
		my_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	/* paintComponent - 화가 메소드
	 * @param g - 문자열을 그리는 그래픽스 펜 */
	public void paintComponent(Graphics g) {
		makeBorder(g);
		g.setColor(Color.red);
		g.drawString(sentence, x_position, y_position);
	}
	
	/* makeBorder - 창 프레임에 테두리를 그림
	 * @param pen - 테두리를 만드는 그래픽스 펜 */
	private void makeBorder(Graphics pen) {
		pen.setColor(Color.pink);
		pen.fillRect(0, 0, width, height);
		int size = 20;
		pen.setColor(Color.white);
		pen.fillRect(size, size, width - (2 * size), height - (2 * size));
	}
	
	/* writeSentence - 창에 문자열을 인쇄
	 * @param s - 인쇄할 문자열 */
	public void writeSentence(String s) {
		sentence = s;
		this.repaint();
	}
	
	/* positionSentence - 위치를 이동하여 창에 문자열을 인쇄
	 * @param x - 인쇄할 위치의 x 좌표
	 * @param y - 인쇄할 위치의 y 좌표 */
	public void positionSentence(int x, int y) {
		x_position = x;
		y_position = y;
		this.writeSentence(sentence);
	}
}