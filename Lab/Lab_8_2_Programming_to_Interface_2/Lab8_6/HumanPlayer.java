import javax.swing.JOptionPane;

public class HumanPlayer extends CardPlayer {
	
	/** Constructor - CardPlayer를 상속받기 */
	public HumanPlayer(int max_cards) {
		super(max_cards);
	}
	
	/** wantsACard - 카드 한 장을 받겠는지 답한다
	 * @return "Y"가 입력될 경우 true, 아니면 false */
	public boolean wantsACard() {
		String response = JOptionPane.showInputDialog("카드를 한장 더 드릴까요? (Y/N)");
		return response.equals("Y");
	}
}
