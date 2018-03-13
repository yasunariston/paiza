package question;

import java.util.Scanner;

public class B011 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		int n = sc.nextInt();
		sc.close();

		int posi = n%(2*p);
		int page = n/(2*p);
		if(n%(2*p)==0) {
			posi = 2*p;
			page = n/(2*p) - 1;
		}

		int ans = (2*p*page) + (p+1) + (p-posi);
		System.out.println(ans);
	}
}
