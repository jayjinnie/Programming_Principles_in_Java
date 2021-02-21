import java.awt.*;
/** BounceTheBall - 애니메이션 객체를 생성하고 공을 움직임 */
public class BounceTheBall {

	public static void main(String[] args) {
		int box_size = 200;
		int balls_radius = 6;
		
		Box box = new Box(box_size);
		MovingBall red_ball = new MovingBall((int)(box_size / 3.0), (int)(box_size / 5.0), +3, +6, balls_radius, box);
		MovingBall blue_ball = new MovingBall(2, (int)(box_size / 5.0), (int)(box_size / 3.0), +2, +5, balls_radius, box);
		
		BoxWriter box_writer = new BoxWriter(box);
		BallWriter ball_writer = new BallWriter(red_ball, blue_ball, Color.red, Color.blue);
		AnimationWriter writer = new AnimationWriter(box_writer, ball_writer, box_size);
		
		// 컨트롤러 객체를 생성하여 애니메이션을 시작
		new BounceController(red_ball, blue_ball, writer).runAnimation();
	}

}
