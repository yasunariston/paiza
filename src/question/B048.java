package question;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B048 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int iSize = sc.nextInt();
		int iCallNum = sc.nextInt() - 1;

		//ビンゴカードの作成
		int[][] bingo = new int[iSize][iSize];
		for(int i = 0; i < iSize; i++) {
			for(int j = 0; j < iSize; j++) {
				bingo[i][j] = sc.nextInt();
			}
		}
		//呼ばれた数字リスト
		int[] called = new int[iCallNum];
		for(int i = 0; i < called.length; i++) called[i] = sc.nextInt();
		sc.close();

		//ビンゴの穴あけ
		Map<Integer, Boolean> selected = new HashMap<Integer, Boolean>();
		for(int i = 0; i < iSize; i++) {
			for(int j = 0; j < iSize; j++) {
				for(int k = 0; k < called.length; k++) {
					if(bingo[i][j] == called[k]) {
						selected.put(bingo[i][j], true);
						break;
					}else {
						selected.put(bingo[i][j], false);
					}
				}
			}
		}

		//ビンゴの判定
		int maxBingo = 0;
		for(int i = 0; i < iSize; i++) {
			for(int j = 0; j < iSize; j++) {
				int oneBingo = 0;
				if(!selected.get(bingo[i][j])) {
					oneBingo = ideal(bingo[i][j], bingo, selected, iSize);
					if(oneBingo > maxBingo) maxBingo = oneBingo;
				}
			}
		}

		System.out.println(maxBingo);
	}

	//ビンゴ数を返す
	public static int ideal(int number, int[][] bingo ,Map<Integer, Boolean> m, int iSize) {
		int line = 0;
		m.put(number, true);
		//横縦列の判定
		for(int i = 0; i < iSize; i++) {
			int count1 = 0;
			int count2 = 0;
			for(int j = 0; j < iSize; j++) {
				if(m.get(bingo[i][j])) count1++;
				if(m.get(bingo[j][i])) count2++;
			}
			if(iSize == count1) line++;
			if(iSize == count2) line++;
		}

		//斜めの判定
		int count1 = 0;
		int count2 = 0;
		for(int i = 0; i < iSize; i++) {
			if(m.get(bingo[i][i]) == true) count1++;
			if(m.get(bingo[i][iSize - i - 1]) == true) count2++;
		}
		if(iSize == count1) line++;
		if(iSize == count2) line++;

		m.put(number, false);
		return line;
	}

}
