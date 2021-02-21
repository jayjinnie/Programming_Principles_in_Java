
public class Dealer {

	private CardDeck deck;
	
	/** Constructor - 카드 덱을 생성함 */
	public Dealer() {
		deck = new CardDeck();
	}
	
	/** dealTo - 그만 달라고 할 때까지 카드를 p에게 한 장씩 준다 
	 * @param p - 카드를 줄 플레이어 */
	public void dealTo(CardPlayerBehavior p) {
		while(p.wantsACard()) {
			Card c = deck.newCard();
			p.receiveCard(c);
		}
	}

	//** 테스트 메소드 *
	public static void main(String[] args) {
		Dealer d = new Dealer();
		HumanPlayer h = new HumanPlayer(3);
		d.dealTo(h); // HumanPlayer에게 카드를 줌
		Card[] cards = h.showCards(); // h가 받은 카드를 cards 배열에 담기
		
		for(int i = 0; i < cards.length; i++) 
			System.out.println(cards[i].getSuit() + " " + cards[i].getRank());
	}
}
