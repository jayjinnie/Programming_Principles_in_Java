
public class ComputerPlayer extends CardPlayer {

	/** Constructor - CardPlayer를 상속받기 */
	public ComputerPlayer(int max_cards) {
		super(max_cards);
	}
	
	/** wantsACard - 카드 한 장을 받겠는지 답한다
	 * @return 컴퓨터의 전략에 따라 true, false가 결정됨 */
	public boolean wantsACard() {
		// 컴퓨터 플레이어의 전략 
		return true;
	}
}
