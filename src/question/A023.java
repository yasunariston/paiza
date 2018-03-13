package question;

import java.util.Scanner;

public class A023 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] calender = new int[N];
		for(int i = 0; i < N; i++) calender[i] = sc.nextInt();
		sc.close();

		System.out.println(calc(calender));
	}

	public static int calc(int[] calender) {
		int maxCount = 0;
		int count = 0;
		boolean check = false;
		for(int i = 0; i < calender.length - 6; i++) {
			int restDay = 0;
			for(int j = 0; j < 7; j++) if(calender[i + j] == 0) restDay++;
			if(restDay >= 2) {
				if(check == true) count++;
				else {
					check = true;
					count = 7;
				}
			}else {
				count = 0;
				check = false;
			}
			if(count > maxCount) maxCount = count;
		}
		return maxCount;
	}
}
