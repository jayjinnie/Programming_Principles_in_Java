/* 시동 클래스
 * 입력 포맷
 *	첫번째 플레이어 이름
 *	두번째 플레이어 이름
 * 출력
 *	플레이어들의 이름
 *	플레이어들의 주사위 결과
 *	게임의 승자 */
public class DiceGame {

	public static void main(String[] args) {
		DiceInput input = new DiceInput();
		Dice dice = new Dice();
		DiceOutput output = new DiceOutput();
		DiceController controller = new DiceController(input, output, dice);
		controller.processTransactions();
	}
}