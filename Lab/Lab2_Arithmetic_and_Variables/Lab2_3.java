
public class Lab2_3 {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		
		System.out.println("정수 = " + n);
		
		n = Math.abs(n);
		
		int d1 = n % 10;
		int d10 = (n / 10) % 10;
		int d100 = (n / 100) % 10;
		int d1000 = (n / 1000) % 10;
		int d10000 = (n / 10000) % 10;
		
		int sum_of_digits = d1 + d10 + d100 + d1000 + d10000;
		System.out.println("숫자의 합 = " + sum_of_digits);
		
		System.out.println("9로 나누어지나? " + (sum_of_digits % 9 == 0));
	}

}
