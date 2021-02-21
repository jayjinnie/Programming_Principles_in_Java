
public class Lab2_4 {

	public static void main(String[] args) {
		int principal = Integer.parseInt(args[0]);
		int month = Integer.parseInt(args[1]);
		double interest = Double.parseDouble(args[2]);
		
		System.out.println("투자 원금 = " + principal + "원");
		System.out.println("월 수익률 = " + interest + "%");
		
		int total = (int)(principal * Math.pow((1 + interest / 100), month));
				
		System.out.println(month + "개월 후 총액 = " + total + "원");
	}

}
