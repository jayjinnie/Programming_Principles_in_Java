
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
		
		System.out.println(p.sameName(q)); // -> false 프린트
		
		Person x = q;
		System.out.println(x.getName()); // -> "소리" 프린트
		// PersonFrom x = p; -> p(Person)는 PersonFrom의 부모 오브젝트이므로 PersonFrom x에 대입 불가
		// System.out.println(x.getCity()); -> p는 Person 오브젝트이므로 GetCity()메소드가 없어 Error발생
		// System.out.println(x.getCity()); -> q는 Person 오브젝트이므로 GetCity()메소드가 없어 Error발생
		// System.out.println(q.same(p)); -> q는 Person 오브젝트이므로 same()메소드가 없어 Error발생
	}
}
