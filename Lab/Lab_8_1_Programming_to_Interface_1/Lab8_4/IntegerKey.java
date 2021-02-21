
public class IntegerKey implements Key {
	
	private int k;
	
	/** Constructor - 키 object 생성
	 * @param i - 키 */
	public IntegerKey(int i) {
		k = i;
	}
	
	/** equals - 인수로 제공된 키와 자신이 같은지 비교
	 * @param c - 비교 대상 키
	 * @return - 같으면 true, 다르면 false*/
	public boolean equals(Key c) {
		// 서브타입 여부 검사 - m이 StringKey의 오브젝트일 경우 비교를 통해 getString() 실행
				if (c instanceof IntegerKey)
					return k == ((IntegerKey)c).getInt();
				else 
					return false;
	}
	
	/** getInt - (자신의) 키를 반환 
	 * @return - 키 */
	public int getInt() {
		return k;
	}
}
