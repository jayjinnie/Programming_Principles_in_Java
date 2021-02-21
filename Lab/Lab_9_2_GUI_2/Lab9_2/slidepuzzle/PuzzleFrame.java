package slidepuzzle;

import java.awt.*;
import javax.swing.*;

public class PuzzleFrame extends JFrame {
	
	private SlidePuzzleBoard board;
	private int size = 4;
	private int button_size = 60;
	private PuzzleButton[][] button;
	
	/** Constructor PuzzleFrame */
	public PuzzleFrame(int board_size, SlidePuzzleBoard b) {
		size = board_size;
		board = b;
		button = new PuzzleButton[size][size];
		
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(size, size));
		
		// 버튼 16개 끼워넣기
		for (int i = 0; i < size; i++) 
			for (int j = 0; j < size; j++) {
				button[i][j] = new PuzzleButton(board, this);
				cp.add(button[i][j]);
			}
		update();
		
		setTitle("Slide Puzzle");
		setSize(size * button_size + 10, size * button_size + 10);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	/** update - 퍼즐 보드의 상태를 갱신 */
	public void update() {
		PuzzlePiece[][] r = board.contents();
		
		// 퍼즐 조각에 숫자를 부여
		for(int i = 0; i != size; i = i + 1) 
			for(int j = 0; j != size; j = j + 1) {
				
				if(r[i][j] != null) {
					button[i][j].setBackground(Color.white);
					button[i][j].setText("" + r[i][j].valueOf());
				}
				else {
					button[i][j].setBackground(Color.black);
					button[i][j].setText("");
				}
			}
	}
}
