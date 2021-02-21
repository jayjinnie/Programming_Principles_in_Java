
public class PersonFrom extends Person {
	
	private String city;
	
	public PersonFrom(String n, String c) {
		super(n); // 상속했던 super class로부터 가져오라고 명시: super()
		city = c;
	}
	
	public String getCity() {
		return city;
	}
	
	public boolean same(PersonFrom p) {
		return sameName(p) && city.equals(p.getCity());
	}
	
	
	public static void main(String[] args) {
		Person p = new Person("마음");
		Person q = new PersonFrom("소리", "서울");
		
		// System.out.println(p.getCity()); -> Person Class에 getCity()메소드가 업으므로 Error
		System.out.println(q.getName()); // -> "마음" 프린트
		System.out.println(p.sameName(p)); // -> true 프린트
		System.out.println(q.sameName(p)); // -> false 프린트
		// System.out.println(q.same(p)); -> same의 parameter p(Person Object)에는 same 메소드가 없으므로 Error
	}
}
