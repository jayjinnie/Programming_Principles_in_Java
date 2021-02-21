
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
		return k == ((IntegerKey)c).getInt();
		// interface Key에 getInt가 없으므로, IntegerKey로 type 변환이 필요
		// * interface와 class도 type의 일종!
	}
	
	/** getInt - (자신의) 키를 반환 
	 * @return - 키 */
	public int getInt() {
		return k;
	}
}
