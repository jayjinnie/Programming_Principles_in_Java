/** Model Class */
public class PuzzlePiece {

	private int face_value;
	
	/** Constructor PuzzlePiece - 퍼즐 피스(퍼즐 한 조각) 만들기
	 * @param value - 만들고 싶은 퍼즐 피스 정수 (1~15 사이의 정수)*/
	public PuzzlePiece(int value) {
		if(value >= 1 && value <= 15)
			face_value = value;
		
		else 
			System.out.println("Error");
	}
	
	/** valueOf - 퍼즐 피스의 값을 반환 */
	public int valueOf() {
		return face_value;
	}
}