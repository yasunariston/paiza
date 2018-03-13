package question;

import java.util.Scanner;

public class D083 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		if(a+b<16) System.out.println("HIT");
		else System.out.println("STAND");
	}

}
