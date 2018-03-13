package question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B012 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		List<String> cre = new ArrayList<String>();
		for(int i=0; i<n; i++) cre.add(sc.nextLine());
		sc.close();

		for(int i=0; i<cre.size(); i++) {
			int ans = 0;
			int sum_even = 0; int sum_odd = 0;
			int even=0; int odd=0;
			for(int j=0; j<15; j++) {
				if(j%2 == 0) {
					even = Integer.parseInt("" + cre.get(i).charAt(j)) * 2;
					if(even >= 10) even -= 9;
					sum_even += even;
				}else {
					odd = Integer.parseInt("" + cre.get(i).charAt(j));
					sum_odd += odd;
				}
			}
			ans = 10 - ((sum_even + sum_odd) % 10);
			if(ans == 10) ans = 0;
			System.out.println(ans);
		}
	}
}
