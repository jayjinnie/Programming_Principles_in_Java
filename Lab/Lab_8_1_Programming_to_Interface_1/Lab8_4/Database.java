public class Database {

	private Record[] base; // 레코드 저장소
	private int NOT_FOUND = -1;
	
	/** Constructor Database - Database 초기화
	 * @param initial_size - 데이터베이스 규모 */
	public Database(int initial_size) {
		if(initial_size > 0) 
			base = new Record[initial_size];
		else 
			base = new Record[1];
	}
	
	/** findLocation - 데이터베이스에서 키가 k인 레코드의 인덱스를 검색 
	 * @param k - 검색할 레코드의 키
	 * @return - 레코드를 찾으면 해당 레코드의 인덱스를 반환, 찾지 못하면 NOT_FOUND 반환 */
	private int findLocation(Key k) {
		for(int i = 0; i < base.length; i++)
			if(base[i] != null && base[i].getKey().equals(k))
				return i;
		return NOT_FOUND;
	}
	
	/** findEmpty - 데이터베이스에서 빈 자리 검색
	 * @return 0 빈 자리를 찾으면 빈 자리 인덱스를 반환, 찾지 못하면 NOT_FOUND 반환 */
	private int findEmpty() {
		for(int i = 0; i < base.length; i++)
			if(base[i] == null)
				return i;
		return NOT_FOUND;
	}
	
	/** insert - 레코드 r을 데이터베이스에 추가
	 * @param r - 데이터베이스에 추가할 레코드
	 * @return - 성공적으로 추가하면 true, 실패하면 false 반환 */
	public boolean insert(Record r) {
		// 중복된 키가 있을 경우 false
		if(findLocation(r.getKey()) != NOT_FOUND)
			return false; 
		
		int index = findEmpty();
		if(index != NOT_FOUND) // empty slot을 찾은 경우
			base[index] = r;
		else { // 데이터베이스가 꽉 차서 r을 추가할 공간이 더 필요한 경우
			Record[] temp = new Record[base.length * 2];
			for(int i = 0; i < base.length; i++) 
				temp[i] = base[i];
			temp[base.length] = r;
			base = temp;
		}
		return false;
	}
	
	/** find - 키가 k인 레코드를 데이터베이스에서 검색
	 * @param k - 검색할 레코드의 키
	 * @return - 찾으면 해당 레코드의 주소를 반환, 찾지 못하면 null 반환 */
	public Record find(Key k) {
		int index = findLocation(k);
		if(index == NOT_FOUND)
			return null;
		else 
			return base[index];
	}
	
	/** delete - 키가 k인 레코드를 데이터베이스에서 삭제 
	 * @param k - 삭제할 레코드의 키
	 * @return - 성공적으로 삭제하면 true, 실패하면 false 반환 */
	public boolean delete(Key k) {
		int index = findLocation(k);
		if(index == NOT_FOUND)
			return false;
		else {
			base[index] = null;
			return true;
		}
	}
	
	public static void main(String[] args) {
		Database db = new Database(4);
		
		BankAccount a1 = new BankAccount(50000, new IntegerKey(55));
		Key k1 = new StringKey("열려라");
		
		BankAccount a2 = new BankAccount(10000, k1);
		boolean transaction1 = db.insert(a1);
		boolean transaction2 = db.insert(a2);
		
		Record p = db.find(k1);
		BankAccount q = (BankAccount)p; // 타입 캐스트
		System.out.println(q.getBalance());
		
		Key k2 = q.getKey();
		if (k2 instanceof IntegerKey)
			System.out.println(((IntegerKey)k2).getInt());
		else if (k2 instanceof StringKey)
			System.out.println(((StringKey)k2).getString());
		else 
			System.out.println("모르는 Key 출현 오류");
	}
}