package BlackJack;
public class Visitor extends CardPlayer implements CardPlayerBehavior {

	private int chip;
	
	/** Constructor - 손에 들고 있는 카드 초기화 */
	public Visitor() {
		hand = new Card[11];
		chip = 0;
	}
	/** receiveACard - 카드 받을지 여부를 반환 (21초과 시 카드를 받을 수 없음) */
	public boolean wantsACard() {
		if (this.getSumCard() < 21)
			return true;
		else 
			return false;
	}
	
	/** showHand - 손에 들고 있는 카드의 상태를 반환 */
	public String showHand() {
		if(this.getSumCard() > 21) 
			return "bust!";
	
		else if (this.getSumCard() == 21)
			return "black jack!!";
			
		else if(this.getHavingCardsNum() == 0)
			return "����ִ� ī�尡 �����ϴ�."; 
		
		else 
			return super.showHand() +"  �հ� :  "+ this.getSumCard();
	}
	
	/** setChip - 손님의 칩 개수 세기
	 * @param n - 손님이 이기면 1, 블랙잭으로 이기면 2, 손님이 지면 -1 */
	public void setChip(int n) { chip += n; }

	/** getChip - 손님의 칩 개수를 반환 */
	public int getChip() { return chip; }
}
