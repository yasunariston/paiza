package question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PraA_janken {
	public static void main(String[] args) {
		//入力対応
		Scanner sc = new Scanner(System.in);
		int timesOfAttempt 	= sc.nextInt();
		int numberOfFinger 	= sc.nextInt();
		String[] rivalHands	= sc.next().trim().split("");
		sc.close();

		//相手が出す手の回数カウント
		int rival_G = 0;
		int rival_C = 0;
		int rival_P = 0;
		for(String value: rivalHands) {
			if(value.equals("G")) 		rival_G++;
			else if(value.equals("C"))	rival_C++;
			else if(value.equals("P"))	rival_P++;
		}

		//指の本数と試合数から、自分が出すことの可能な手の組み合わせを全通り格納
		List<int[]> myHandPattern = new ArrayList<int[]>();
		for(int g = 0; g <= timesOfAttempt; g++) {
			for(int c = 0; c <= timesOfAttempt - g; c++) {
				int p = timesOfAttempt - (g + c);
				if(c*2 + p*5 == numberOfFinger) {
					int[] my_hands = {g, c, p};
					myHandPattern.add(my_hands);
					break;
				}
			}
		}

		//勝敗判定
		int maxWinningCount = 0;
		for(int i = 0; i < myHandPattern.size(); i++) {
			int winningCount = 0;
			winningCount += Math.min(rival_G, myHandPattern.get(i)[2]);
			winningCount += Math.min(rival_C, myHandPattern.get(i)[0]);
			winningCount += Math.min(rival_P, myHandPattern.get(i)[1]);
			if(winningCount > maxWinningCount) maxWinningCount = winningCount;
		}

		//最高勝数の出力
		System.out.println(maxWinningCount);
	}
}