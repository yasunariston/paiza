package question;

import java.util.Scanner;

public class B008 {

	public static void main(String[] args) {

		boolean check = true;
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int ans = 0;
		if(N == 0 || M == 0) check = false;

		if(check) {
			int[][] ivent_list = new int[M][N];
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					ivent_list[i][j] = sc.nextInt();
				}
			}

			for(int i=0; i<M; i++) {
				int gain = 0;
				for(int j=0; j<N; j++) {
					gain += ivent_list[i][j];
				}
				if(gain > 0) {
					ans += gain;
				}
			}
		}
		sc.close();
		System.out.println(ans);
	}

}
