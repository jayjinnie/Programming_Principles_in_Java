/**Model Class */
public class SlidePuzzleBoard {

	private int size;
	private PuzzlePiece[][] board; // 퍼즐 피스의 2차원 배열
	private int empty_col; // 빈 행
	private int empty_row; // 빈 열
	
	/** Constructor SlidePuzzleBoard - 퍼즐 보드를 생성 
	 * @param s - 퍼즐 보드의 크기 */
	public SlidePuzzleBoard(int s) {
		size = s;
		board = new PuzzlePiece[s][s];
		
		for(int num = 1; num != s * s; num++) {
			// loop invariant: 1, 2, 3,....16 (size=4인 경우)
			PuzzlePiece p = new PuzzlePiece(num);
			// num을 size로 나눈 몫: 열, 나머지: 행
			// row:col:board[row][col] -> 0:1:board[3][2], 0:2:board[3,1],..., 3:3:board[0,0]
			// 순서대로 1,2,3,...15가 기입됨
			int row = num / size; 
			int col = num % size;
			board[size-1-row][size-1-col] = p;
		}
		
		empty_row = 3;
		empty_col = 3;
	}
	//** 모서리 부분은 상하좌우를 다따질 필요가 없음!!! 그리고 모서리가 아닌 부분도 실행시키기..ㅠ
	/** move - 퍼즐 피스 움직이기 메소드 (빈 칸의 상,하,좌,우를 확인)
	 * @param w - 움직일 퍼즐 피스의 번호 
	 * @return - 퍼즐 피스가 움질일 수 있으면 true, 움직일 수 없으면 false */
	public boolean move(int w) {
		final int NOT_FOUND = -1;
		int row = NOT_FOUND;
		int col = NOT_FOUND;
		
		if(found(w, empty_row-1, empty_col)) { // 상
			row = empty_row-1;
			col = empty_col;
		}	
		else if(found(w, empty_row+1, empty_col)) { // 하
			row = empty_row+1;
			col = empty_col;
		}
		else if(found(w, empty_row, empty_col-1)) { // 좌
			row = empty_row;
			col = empty_col-1;
		}
		else if(found(w, empty_row, empty_col+1)) { // 우
			row = empty_row;
			col = empty_col+1;
		}
		
		// 움직일 수 있는 경우, 빈칸과 해당 퍼즐 피스의 위치를 switch
		if(row != NOT_FOUND) {
			board[empty_row][empty_col] = board[row][col]; // 빈칸 -> 위치를 바꿀 퍼즐 피스
			empty_row = row;
			empty_col = col;
			board[empty_row][empty_col] = null; // 위치를 바꿀 퍼즐 피스 -> 빈칸
		}
		return row != NOT_FOUND;
	}
	
	/** found - 퍼즐 피스가 움직일 수 있는지 여부를 반환
	 * @param v - 찾으려는 값
	 * @param row - v의 열
	 * @param col - v의 행
	 * @return - 움직이려는 퍼즐 피스의 값과 위치가 같다면 true, 다르면 false */
	public boolean found(int v, int row, int col) {
		if(board[row][col].valueOf() == -1 || board[row][col].valueOf() == 4)
			return false;
		else 
			return board[row][col].valueOf() == v;
	}
	
	/** 외부에서 필드변수 board에 접근할 수 있게 하는 메소드 */
	public PuzzlePiece[][] contents() {
		return board;
	}
}