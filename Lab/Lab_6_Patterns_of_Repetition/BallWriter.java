import java.awt.*;
/** BallWriter - 움직이는 공을 그림 */
public class BallWriter {
	private MovingBall ball;
	private MovingBall ball2;
	private Color balls_color;
	private Color balls_color2;
	
	/** Constructor BallWriter
	 * @param x - 공1 객체
	 * @param y - 공2 객체
	 * @param c1 - 공1의 색깔
	 * @param c2 - 공2의 색깔 */
	public BallWriter(MovingBall x, MovingBall y, Color c1, Color c2) {
		ball = x;
		ball2 = y;
		balls_color = c1;
		balls_color2 = c2;
	}
	
	/** paintComponent - 공 그리기
	 * @param g - 그래픽스 펜 */
	public void paintComponent(Graphics g) {
		g.setColor(balls_color);
		int radius = ball.radiusOf();
		g.fillOval(ball.xPosition() - radius, ball.yPosition() - radius, 
				  radius * 2, radius * 2);
	
		g.setColor(balls_color2);
		int radius2 = ball2.radiusOf();
		g.fillOval(ball2.xPosition2() - radius2, ball2.yPosition2() - radius2, 
				  radius2 * 2, radius2 * 2);
	}
}
