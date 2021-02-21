import java.awt.*;
import javax.swing.*;

public class DiceOutput extends JPanel {
	private int WIDTH = 600;
	private int HEIGHT = 400;
	// 첫번째 플레이어와 두번째 플레이어 이름 초기화
	private String player_a = "";
	private String player_b = "";
	// 플레이어들의 이름을 표시하는 문장 초기화
	private String player_a_name = "";
	private String player_b_name = "";
	// 각 플레이어들의 주사위 수를 표시하는 문장 초기화
	private String player_a_dice = "";
	private String player_b_dice = "";
	// 이긴 플레이어를 표시하는 문장 초기화
	private String winner = "";
	
	/* DiceOutput - 출력기 초기화 */
	public DiceOutput() {
		JFrame frame = new JFrame();
		frame.getContentPane().add(this);
		frame.setTitle("주사위 게임!");
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void paintComponent (Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect(0, 0, WIDTH, HEIGHT + 22);
		
		int text_top = 30;
		int text_bottom = 30;
		g.setColor(Color.white); // 주사위 게임 규칙
		g.drawString("~주사위 게임 규칙 설명~", text_top, text_bottom);
		g.drawString("첫번째 플레이어와 두번째 플레이어가 각각 주사위를 2개씩 던집니다.", text_top, text_bottom + 20);
		g.drawString("주사위 두개가 같은 수가 나오는 플레이어가 승리합니다.", text_top, text_bottom + 40);
		g.drawString("만약, 둘 다 주사위 두 개가 같은 수가 나온다면, 주사위 수가 큰 플레이어가 승리합니다.", text_top, text_bottom + 60);
		g.drawString("주사위 네 개의 수가 모두 같다면, 비깁니다.", text_top, text_bottom + 80);
		g.drawString("둘 다 주사위 두 개가 다른 수가 나온다면, 두 주사위 수의 합이 큰 플레이어가 승리합니다.", text_top, text_bottom + 100);
		g.drawString("만약, 두 주사위 수의 합이 같다면, 두 주사위 수의 차가 작은 플레이어가 승리합니다.", text_top, text_bottom + 120);
		g.drawString("두 주사위 수의 차가 같다면, 비깁니다.", text_top, text_bottom + 140);
		
		g.setColor(Color.pink);
		g.drawString(player_a, text_top, text_bottom + 180);
		g.drawString(player_b, text_top, text_bottom + 200);
		
		g.setColor(Color.green);
		g.drawString(player_a_dice, text_top, text_bottom + 240);
		g.drawString(player_b_dice, text_top, text_bottom + 260);
		
		g.setColor(Color.orange);
		g.drawString(winner, text_top, text_bottom + 300);
		}
	
	/* getPlayerA - 첫번째 플레이어 이름을 표시하기 
	 * @param a_name - 첫번째 플레이어의 이름 */
	public void getPlayerA(String name) {
		player_a = "첫번째 플레이어의 이름은 " + name + "님입니다.";
		player_a_name = name;
		this.repaint();
	}
	
	/* getPlayerB - 두번째 플레이어 이름을 표시하기 
	 * @param b_name - 두번째 플레이어의 이름 */
	public void getPlayerB(String name) {
		player_b = "두번째 플레이어의 이름은 " + name + "님입니다.";
		player_b_name = name;
		this.repaint();
	}
	
	/* getPlayerADice - 첫번째 플레이어의 주사위 수를 표시하기 
	 * @param a_d1 - 첫번째 플레이어의 첫번째 주사위의 수
	 * @param a_d2 - 첫번째 플레이어의 두번째 주사위의 수 */
	public void getPlayerADice(int a_d1, int a_d2) {
		player_a_dice = player_a_name + " 님의 주사위 결과 | 첫 번째 주사위: " + a_d1 + ",  두번째 주사위: " + a_d2;
		this.repaint();
	}
	
	/* getPlayerBDice - 두번째 플레이어의 주사위 수를 표시하기 
	 * @param b_d1 - 두번째 플레이어의 첫번째 주사위의 수
	 * @param b_d2 - 두번째 플레이어의 두번째 주사위의 수 */
    public void getPlayerBDice(int b_d1, int b_d2) {
    	player_b_dice = player_b_name + " 님의 주사위 결과 | 첫 번째 주사위: " + b_d1 + ",  두번째 주사위: " + b_d2;
    	this.repaint();
    }
	
    /* getWinner - 승자 플레이어의 이름을 표시하기 
     * @param win - 승자 플레이어의 이름 */
	public void getWinner(String name) {
		winner = "이번 게임의 승자는 " + name + " 닙입니다!";
		this.repaint();
	}
}