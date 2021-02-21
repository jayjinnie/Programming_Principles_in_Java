import java.awt.*;
import javax.swing.*;
/** Output View */
public class PuzzleWriter extends JPanel {

	SlidePuzzleBoard board;
	private int size; // 보드의 크기
	private int piece_size = 30; // 퍼즐 조각의 크기 (단위: pixel)
	private int panel_width; // 패널의 너비
	private int panel_height; // 패널의 크기
	
	/** Constructor PuzzleWriter - Output View 생성
	 * @param b - 퍼즐 보드 클래스
	 * @param s - 보드의 크기 */
	public PuzzleWriter(SlidePuzzleBoard b, int s) {
		board = b;
		size = s;
		panel_width = piece_size * s + piece_size * 2;
		panel_height = piece_size * s + piece_size * 2;
		
		JFrame f = new JFrame();
		f.getContentPane().add(this);
		f.setTitle("Slide Puzzle");
		f.setSize(panel_width, panel_height + 22);
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	/** paintComponent - 페인트 메소드
	 * @param g - 그래픽스 펜 */
	public void paintComponent(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(0, 0, panel_width, panel_height);
		PuzzlePiece[][] b = board.contents();
		for(int i = 0; i != size; i++) // i: y좌표
			for(int j = 0; j != size; j++) // j: x좌표
				paintPiece(g, b[i][j], i, j);
	}
	
	/** paintPiece - 퍼즐 피스(퍼즐 한조각) 그리기
	 * @param g - 그래픽스 펜
	 * @param p - 퍼즐 클래스
	 * @param i - y좌표 위치
	 * @param j - x좌표 위치 */
	private void paintPiece(Graphics g, PuzzlePiece p, int i, int j) {
		int x_pos = piece_size + (piece_size * j);
		int y_pos = piece_size + (piece_size * i);
		
		if (p != null) {
			g.setColor(Color.white);
			g.fillRect(x_pos, y_pos, piece_size, piece_size);
			
			g.setColor(Color.black);
			g.drawRect(x_pos, y_pos, piece_size, piece_size);
			
			g.drawString(p.valueOf() + "", x_pos + 10, y_pos + 20);
		}
		
		else {
			g.setColor(Color.black);
			g.fillRect(x_pos, y_pos, piece_size, piece_size);
		}
	}
	
	/** displayBoard - paintComponent 메소드를 계속해서 실행 */
	public void displayBoard() {
		this.repaint();
	}
	
	/** printError - Error를 프린트 */
	public void printError(String s) {
		JOptionPane.showMessageDialog(null, "오류: " + s);
	}
}