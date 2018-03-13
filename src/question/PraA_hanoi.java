package question;

import java.util.Scanner;

public class PraA_hanoi {
	public static void main(String[] args) {
		//入力値の整理
		Scanner sc = new Scanner(System.in);
		int numberOfDisc  = sc.nextInt();
		int timesOfMoving = sc.nextInt();
		sc.close();

		//タワー毎の配列作成
		int[] towerOfHanoi1 = new int[numberOfDisc];
		int[] towerOfHanoi2 = new int[numberOfDisc];
		int[] towerOfHanoi3 = new int[numberOfDisc];

		//スタックポインタの作成
		int hanoi1_pointer = numberOfDisc - 1;
		int hanoi2_pointer = -1;
		int hanoi3_pointer = -1;

		//タワー1へのディスク配置
		for(int i = 0; i < numberOfDisc; i++) towerOfHanoi1[i] = numberOfDisc - i;

		//ディスク移動の実装

	}

}
