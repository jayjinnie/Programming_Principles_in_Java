
public class StringKey implements Key {
	private String s;
	
	/** Constructor - 문자 키 생성
	 * @param j - 문자 키 */
	public StringKey(String j) {
		s = j;
	}
	
	/** equals - 인수로 제공된 키와 자신이 같은지 비교
	 * @param m - 비교 대상 키
	 * @return - 같으면 true, 다르면 false*/
	public boolean equals(Key m) {
		// 서브타입 여부 검사 - m이 StringKey의 오브젝트일 경우 비교를 통해 getString() 실행
		if (m instanceof StringKey)
			return s.equals(((StringKey)m).getString());
		else 
			return false;
	}
	
	/** getString - (자신의) 키를 반환 
	 * @return - 키 */
	public String getString() {
		return s;
	}
}
