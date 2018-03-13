package question;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B045 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int plus_q  = sc.nextInt();
		int minus_q = sc.nextInt();
		sc.close();

		Set<String> set = new HashSet<String>();
		boolean plus_check  = false;
		boolean minus_check = false;
		String question;

		if(plus_q !=0) {
			while(!plus_check) {
				int r1 = (int) Math.floor(Math.random () * 100);
				int r2 = (int) Math.floor(Math.random () * 100);
				int q = r1 + r2;
				if(q <= 99) {
					question = r1 + " + " + r2 + " = ";
					set.add(question);
				}
				if(set.size() == plus_q) plus_check = true;
			}
		}

		if(minus_q != 0) {
			while(!minus_check) {
				int r1 = (int) Math.floor(Math.random () * 100);
				int r2 = (int) Math.floor(Math.random () * 100);
				question = Math.max(r1, r2) + " - " + Math.min(r1, r2) + " = ";
				set.add(question);
				if(set.size() == minus_q + plus_q) minus_check = true;
			}
		}

		for(String value: set) System.out.println(value);
	}
}
