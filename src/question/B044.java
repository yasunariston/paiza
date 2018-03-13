package question;

import java.util.Scanner;

public class B044 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//ステージ情報
		int iStageHeight = sc.nextInt();
		int iStageWeight = sc.nextInt();

		String[][] strStageData = new String[iStageHeight][iStageWeight];
		for(int i = 0; i < strStageData.length; i++) {
			strStageData[i] = sc.next().trim().split("");
		}
		sc.close();

		//ステージ探索
		for(int i = 0; i < strStageData.length; i++) {
			for(int j = 0; j < strStageData[i].length; j++) {

				//爆弾の動作
				if(strStageData[i][j].matches("[1-9]{1}")) {
					int iBombPower = Integer.parseInt(strStageData[i][j]);

					boolean canBombLeft  = true;
					boolean canBombRight = true;
					boolean canBombOver  = true;
					boolean canBombUnder = true;

					//爆風の設定
					for(int iBombAttack = 1; iBombAttack <= iBombPower; iBombAttack++) {

						//左
						if(canBombLeft) {
							if(strStageData[i][j-iBombAttack].matches("[., X]{1}")) {
								strStageData[i][j-iBombAttack] = "b";
							}else if(strStageData[i][j-iBombAttack].equals("#")) {
								canBombLeft = false;
							}
						}

						if(canBombRight) {
							if(strStageData[i][j+iBombAttack].matches("[., X]{1}")) {
								strStageData[i][j+iBombAttack] = "b";
							}else if(strStageData[i][j+iBombAttack].equals("#")) {
								canBombRight = false;
							}
						}

						if(canBombOver) {
							if(strStageData[i-iBombAttack][j].matches("[., X]{1}")) {
								strStageData[i-iBombAttack][j] = "b";
							}else if(strStageData[i-iBombAttack][j].equals("#")) {
								canBombOver = false;
							}
						}

						if(canBombUnder) {
							if(strStageData[i+iBombAttack][j].matches("[., X]{1}")) {
								strStageData[i+iBombAttack][j] = "b";
							}else if(strStageData[i+iBombAttack][j].equals("#")) {
								canBombUnder = false;
							}

						}
					}
				}
			}
		}

		//敵の探索
		boolean bAllDamaged = true	;
		for(int i = 0; i < strStageData.length; i++) {
			for(int j = 0; j < strStageData[i].length; j++) {
				if(strStageData[i][j].equals("X")) {
					bAllDamaged = false;
					break;
				}
			}
		}

		if(bAllDamaged)	System.out.println("YES");
		else 			System.out.println("NO");
	}
}
