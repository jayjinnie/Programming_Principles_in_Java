/** BounceController - 상자 안에서 움직이는 공을 제어 */
public class BounceController {
	private MovingBall ball;
	private MovingBall ball2; // 공 객체 (Model)
	private AnimationWriter writer; // 애니메이션 객체 (Output-View)
	
	/** Constructor BounceController - 컨트롤러 초기화
	 * @param a - 첫번째 공 객체 (Model)
	 * @param b - 두번째 공 객체 (Model)
	 * @param w - 애니메이션 객체 (Output-View) */
	public BounceController(MovingBall a, MovingBall b, AnimationWriter w) {
		ball = a;
		ball2 = b;
		writer = w;
	}
	
	/** runAnimation - 내부 시계를 활용하여 애니메이션을 구동 */
	public void runAnimation() {
		int time_unit = 1;        // 애니메이션 스텝의 시간 단위
		int painting_delay = 20;  // 다시 그리기 사이의 지연 시간 간격
		
		while(true) {
			delay(painting_delay); 
			ball.move(time_unit);
			ball2.move(time_unit);
			System.out.println("A -- " + ball.xPosition() + ", " + ball.yPosition());
			System.out.println("B -- " + ball2.xPosition2() + ", " + ball2.yPosition2());
			writer.repaint();
		}
	}
	
	/** delay - how_long millisecond동안 실행 정지 */
	private void delay(int how_long) {
		try {Thread.sleep(how_long);}
		catch (InterruptedException e) {}
	}
}
