public class DiceController {
	
	private DiceInput input;
	private DiceOutput output;
	private Dice dice;
	private String player_a = new DiceInput().readPlayerA();
	private String player_b = new DiceInput().readPlayerB();
	private String player_c = player_a + "와 " + player_b;
	
	private int a_d1 = new Dice().throwDice();
	private int a_d2 = new Dice().throwDice();
	private int b_d1 = new Dice().throwDice();
	private int b_d2 = new Dice().throwDice();

	/* DiceController - 객체 초기화
	 * @param i - input-view 객체
	 * @param o - output-view 객체
	 * @param d - Model 객체 */
	public DiceController(DiceInput i, DiceOutput o, Dice d) {
		input = i;
		output = o;
		dice = d;
	}
	
	/* processTransactions - 사용자가 플레이어 2명의 이름을 입력하면, 게임의 승자를 판별하여 결과를 출력 */
	public void processTransactions() {
		output.getPlayerA(player_a);
		output.getPlayerB(player_b);
		
		output.getPlayerADice(a_d1, a_d2);
		output.getPlayerBDice(b_d1, b_d2);
		
		String winner;
		
		if ((a_d1 == a_d2) && (b_d1 == b_d2)) //플레이어a도 같은 수, 플레이어b도 같은 수가 나올경우
		{	
			if (a_d1 > b_d1)
			{
				winner = player_a;
			}
			
			else if (a_d1 < b_d1)			
			{
				winner = player_b;
			}
			
			else
			{
				winner = player_c;
			}
		}
		
		else if ((a_d1 == a_d2) && (b_d1 != b_d2)) // 플레이어a는 같은 수가 나오고, 플레이어b는 다른 수가 나올 경우
		{
			winner = player_a;
		}
		
		else if ((a_d1 != a_d2) && (b_d1 == b_d2)) // 플레이어a는 다른 수가 나오고, 플레이어b는 같은 수가 나올 경우
		{
			winner = player_b;
		}
		
		else // 플레이어a도 다른 수, 플레이어b도 다른 수가 나올경우
		{
			// 두 주사위 수의 합이 큰 플레이어가 승리
			int a = a_d1 + a_d2;
			int b = b_d1 + b_d2;
			
			if (a > b)
			{
				winner = player_a;
			}
			
			else if (a < b) 
			{
				winner = player_b;
			}
			
			else // 두 주사위 수의 차가 작은 플레이어가 승리
			{
				a = Math.abs(a_d1 - a_d2);
				b = Math.abs(b_d1 - b_d2);
				
				if (a < b) 
				{
					winner = player_a;
				}
				
				else if (a > b)
				{
					winner = player_b;
				}
				
				else
				{
					winner = player_c;
				}
			}	
		}
		output.getWinner(winner);
	}
}