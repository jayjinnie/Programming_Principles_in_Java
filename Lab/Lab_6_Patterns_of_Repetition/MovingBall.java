/** MovingBall - 2차원 상자에서 움직이는 공 */
public class MovingBall {
	private int x_pos, y_pos;
	private int x_pos2, y_pos2;
	private int radius;
	private int x_velocity;
	private int y_velocity;
	private int x_velocity2;
	private int y_velocity2;
	private Box container;
	
	/** Constructor MovingBall - 첫번째 공 객체 만들기
	 * @param x_initial - 첫번째 공의 중심의 x좌표
	 * @param y_initial - 첫번째 공의 중심의 y좌표
	 * @param x_velo - 첫번째 공 x좌표의 속도
	 * @param y_velo - 첫번째 공 y좌표의 속도
	 * @param r - 첫번째 공의 반지름
	 * @param box - 첫번째 공이 돌아다니는 상자 */
	public MovingBall(int x_initial, int y_initial, int x_velo, int y_velo, int r, Box box) {
		x_pos = x_initial;
		y_pos = y_initial;
		x_velocity = x_velo;
		y_velocity = y_velo;
		radius = r;
		container = box;
	}
	
	/** Constructor MovingBall - 두번째 공 객체 만들기
	 * @param a - 첫번째 공과 두번째 공의 Constructor 메소드를 구분
	 * @param x_initial2 - 두번째 공의 중심의 x좌표
	 * @param y_initial2 - 두번째 공의 중심의 y좌표
	 * @param x_velo2 - 두번째 공 x좌표의 속도
	 * @param y_velo2 - 두번째 공 y좌표의 속도
	 * @param r - 두번째 공의 반지름
	 * @param box - 두번째 공이 돌아다니는 상자 */
	public MovingBall(int a, int x_initial2, int y_initial2, int x_velo2, int y_velo2, int r, Box box) {
		x_pos2 = x_initial2;
		y_pos2 = y_initial2;
		x_velocity2 = x_velo2;
		y_velocity2 = y_velo2;
		radius = r;
		container = box;
	}
	
	/** xPosition - 첫번째 공의 x축 위치를 리턴 */
	public int xPosition() {
		return x_pos;
	}
	
	/** yPosition - 첫번째 공의 y축 위치를 리턴 */
	public int yPosition() {
		return y_pos;
	}
	
	/** xPosition2 - 두번째 공의 x축 위치를 리턴 */
	public int xPosition2() {
		return x_pos2;
	}
	
	/** yPosition2 - 두번째 공의 y축 위치를 리턴 */
	public int yPosition2() {
		return y_pos2;
	}
	
	/** radiusOf - 공의 반지름을 리턴 */
	public int radiusOf() {
		return radius;
	}
	 /** move - time_unit만큼 공을 이동시키고, 벽에 부딭히면 공의 방향을 바꿈
	  * @param - time_units - 프레임 사이의 시간 */
	public void move(int time_units) {
		// 첫번째 공
		x_pos = x_pos + x_velocity * time_units;
		if(container.inHorizontalContact(x_pos)) {
			x_velocity = - x_velocity;
		}
		
		y_pos = y_pos + y_velocity * time_units;
		if(container.inVerticalContact(y_pos)) {
			y_velocity = - y_velocity;
		}
		if(container.inVerticalBlock(Math.abs(x_pos - radius), Math.abs(y_pos - radius))) {
			y_velocity = - y_velocity;
		}
		
		// 두번째 공
		x_pos2 = x_pos2 + x_velocity2 * time_units;
		if(container.inHorizontalContact(x_pos2)) {
			x_velocity2 = - x_velocity2;
		}
		
		y_pos2 = y_pos2 + y_velocity2 * time_units;
		if(container.inVerticalContact(y_pos2)) {
			y_velocity2 = - y_velocity2;
		}
		if(container.inVerticalBlock(Math.abs(x_pos2 - radius), Math.abs(y_pos2 - radius))) {
			y_velocity2 = - y_velocity2;
		}
		
		// 첫번째 공과 두번째 공이 충돌할 경우 
		if(container.crash(x_pos, y_pos, x_pos2, y_pos2)) { 
			x_velocity = - x_velocity;
			y_velocity = - y_velocity;
			x_velocity2 = - x_velocity2;
			y_velocity2 = - y_velocity2;
		}
	}
}