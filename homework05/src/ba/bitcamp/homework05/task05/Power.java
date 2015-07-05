package ba.bitcamp.homework05.task05;

public class Power {
	
	public static double getPow (double a, double b){
		if ( b == 0){
			return 1;
		}
		if ( b % 1 != 0){
			return Math.pow(a, b);
		}
		if (b > 0){
			return a * getPow (a , b - 1);
		}else 
			return 1 / getPow (a, b * -1);
		}

	public static void main(String[] args) {
		System.out.println(getPow(2,5));
		System.out.println(getPow(-2, 4));
		System.out.println(getPow(-2,-2));

	}

}