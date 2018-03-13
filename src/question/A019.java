package question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A019 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] hands = new int[N];
		for(int i = 0; i < hands.length; i++) hands[i] = sc.nextInt();
		int S = sc.nextInt();
		int[][] cut = new int[S][N];
		for(int i = 0; i < cut.length; i++) {
			for(int j = 0; j < cut[S].length; j++) cut[i][j] = sc.nextInt();
		}
		sc.close();

		int minCount = -1;
		int max = calc(N);
		boolean allClear = false;

		int[] checker1 = new int[N];
		for(int i = 0; i < checker1.length; i++) checker1[i] = i;
		int[] checker2 = new int[N];

		//TODO 繰り返し回数不明
		while(!allClear) {
			List<int[]> card = new ArrayList<int[]>();
			for(int i = 0; i < cut.length; i++) {
				checker1 = shaffle(checker1, cut[i]);
				card.add(checker1);
			}
		}
	}

	public static int[] shaffle(int[] origin, int[] method) {
		int[] ans = new int[origin.length];
		for(int i = 0; i < origin.length; i++) ans[i] = origin[method[i]];
		return ans;
	}

	public static int calc(int num) {
		if(num == 2) return 2;
		else return num * calc(num - 1);
	}
}
