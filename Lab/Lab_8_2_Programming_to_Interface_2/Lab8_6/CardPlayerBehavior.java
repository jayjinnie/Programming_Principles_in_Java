
public interface CardPlayerBehavior {

	/** wantsACard - 카드 한 장을 받겠는지 답한다
	 * @return 카드를 받고싶으면 true, 아니면 false */
	public boolean wantsACard();
	
	/** receiveCard - 카드 한 장을 받아서 손에 넣는다 
	 * @param c - 카드 한장
	 * @return 카드 수령 성공이면 true, 실패이면 false */
	public boolean receiveCard(Card c);
}
