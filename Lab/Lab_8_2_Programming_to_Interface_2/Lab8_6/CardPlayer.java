
public abstract class CardPlayer implements CardPlayerBehavior {

	private Card[] hand; // 손에 들고 있는 카드 묶음
	private int card_count; // 손에 들고 있는 카드 장 수 
	
	/** Constructor - 들고 있는 카드 초기화, 들 수 있는 카드 수 정하기 
	 * @param max_cards - 손에 들 수 있는 카드의 최대 장 수 */
	public CardPlayer(int max_cards) {
		hand = new Card[max_cards]; 
		card_count = 0;
	}
	
	/** wantsACard - 카드 한 장을 받겠는지 답한다
	 * @return 카드를 받고싶으면 true, 아니면 false 
	 * HumanPlayer와 ComputerPlayer에서 역할이 다르므로 abstract method */
	public abstract boolean wantsACard();
	
	/** receiveCard - 카드 한 장을 받아서 손에 넣는다 
	 * @param c - 카드 한장
	 * @return 카드 수령 성공이면 true, 실패이면 false */
	public boolean receiveCard(Card c) {
		
		if (card_count < hand.length) {
			hand[card_count] = c;
			card_count += 1;
			return true;
		}
		else 
			return false;
	}
	
	/** showCards - 들고 있는 카드를 보여주기
	 * hand 배열이 private 변수이므로 cards 배열을 새로 선언하여 옮겨주기 */
	public Card[] showCards() {
		Card[] cards = new Card[card_count];
		
		for(int i = 0; i < card_count; i++)
			cards[i] = hand[i];
		return cards;
	}
}
