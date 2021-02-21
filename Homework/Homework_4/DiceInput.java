import javax.swing.JOptionPane;
 
public class DiceInput {
	
	private String player_a;
	private String player_b;
	
	/* readPlayerA - 입력창을 통해 첫번째 플레이어 이름을 입력받기
	 * @return 첫번째 플레이어의 이름*/
	public String readPlayerA() {
		player_a =JOptionPane.showInputDialog("첫번째 플레이어의 이름을 입력하세요.");
		return player_a;
	}
	
	/* readPlayerB - 입력창을 통해 두번째 플레이어 이름을 입력받기
	 * @return 두번째 플레이어의 이름*/
	public String readPlayerB() {
		player_b =JOptionPane.showInputDialog("두번째 플레이어의 이름을 입력하세요.");
		return player_b;
	}
}