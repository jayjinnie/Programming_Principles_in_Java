/** Box - 공이 돌아다니는 상자 */
public class Box {
	
	private int BOX_SIZE;
	
	private int X_OFFSET = 40;
	private int Y_OFFSET = 95;
	private int X_START, Y_START;
	private int X_SIZE, Y_SIZE;
	
	/** Constructor Box - 상자 생성
	 * @param size - 상자의 크기 */
	public Box(int size) {
		BOX_SIZE = size;
	}
	
	/** sizeOf - 상자의 크기를 리턴 */
	public int sizeOf() {
		return BOX_SIZE;
	}
	
	/** startOfX - 장애물을 그릴 x 위치를 리턴 */
	public int startOfX() {
		X_START = (sizeOf() / 5);
		return X_START;
 	}
	
	/** startOfY - 장애물을 그릴 y 위치를 리턴 */
	public int startOfY() {
		Y_START = (sizeOf() / 2);
		return Y_START;
 	}
	
	/** sizeOfX - 장애물의 가로 크기를 리턴 */
	public int sizeOfX() {
		X_SIZE = sizeOf() - (X_OFFSET * 2);
		return X_SIZE;
	}
	
	/** sizeOfY - 장애물의 세로 크기를 리턴 */
	public int sizeOfY() {
		Y_SIZE = sizeOf() - (Y_OFFSET * 2);
		return Y_SIZE;
	}
	
	/** inVerticalBlock - 공이 장애물의 위/아래 벽에 도달했는지의 여부를 확인 
	 * @param x_pos - 공의 x 좌표
	 * @param y_pos - 공의 y좌표
	 * @return - 공이 장애물에 부딪히면 true, 부딪히지 않으면 false */
	public boolean inVerticalBlock(int x_pos, int y_pos) {
		if ((x_pos >= X_START) && (x_pos <= (X_START + X_SIZE))) {
			if ((y_pos == Y_START) || (y_pos == (Y_START + Y_SIZE))) {
				return true;
			}
			else 
				return false;
		}
		else return false;
	}
	
	/** inHorizontalContact - 공이 x축 방향으로 좌/우 벽에 도달했는지의 여부를 리턴
	 * @param x_position - 공의 x좌표
	 * @return - 공의 x좌표가 좌/우 벽의 x좌표와 같거나 벗어났으면 true, 그렇지 않으면 false*/
	public boolean inHorizontalContact(int x_position) {
		return (x_position <= 0) || (x_position >= BOX_SIZE);
	}
	
	/** inVerticalContact - 공이 y축 방향으로 위/아래 벽에 도달했는지의 여부를 리턴
	 * @param y_position - 공의 y좌표
	 * @return - 공의 y좌표가 위/아래 벽의 y좌표와 같거나 벗어났으면 true, 그렇지 않으면 false*/
	public boolean inVerticalContact(int y_position) {
		return (y_position <= 0) || (y_position >= BOX_SIZE);
	}
	
	/** crash - 두 개의 공이 충돌했는지의 여부를 리턴
	 * @param b1_x_position - 첫번째 공의 x좌표
	 * @param b1_y_position - 첫번째 공의 y좌표
	 * @param b2_x_position - 두번째 공의 x좌표
	 * @param b2_y_position - 두번째 공의 y좌표
	 * @return - 두 공이 충돌하면 true, 충돌하지 않으면 false 
	            (두 공 중심간의 거리가 0이면 true, 0이 아니면 false) */
	public boolean crash(int b1_x, int b1_y, int b2_x, int b2_y) {
		return Math.sqrt(Math.pow(Math.abs(b1_x - b2_x), 2) + Math.pow(Math.abs(b1_y - b2_y), 2)) == 0;
	}
}
