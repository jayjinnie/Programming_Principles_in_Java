import java.awt.*;
/** BoxWriter - 상자와 장애물을 그림 */
public class BoxWriter {
	private Box box;
	
	/** Constructor BoxWriter
	 * @param b - 상자 객체 */
	public BoxWriter(Box b) {
		box = b;
	}
	
	/** paintComponent - 상자와 장애물 그리기
	 * @param g - 그래픽스 펜 */
	public void paintComponent(Graphics g) {
		int size = box.sizeOf();
		g.setColor(Color.white);
		g.fillRect(0, 0, size, size);
		g.setColor(Color.black);
		g.drawRect(0, 0, size, size);
		
		int x_start = box.startOfX();
		int y_start = box.startOfY();
		int x_size = box.sizeOfX();
		int y_size = box.sizeOfY();
		g.setColor(Color.pink);
		g.fillRect(x_start, y_start, x_size, y_size);
	}
}
