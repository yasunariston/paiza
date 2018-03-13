package question;

import java.util.Scanner;

public class B043 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//街の大きさ
		int iHeightOfTown = sc.nextInt();
		int iWeightOfTown = sc.nextInt();

		//ねずみ小僧初期位置
		int iNezumiLine = sc.nextInt() - 1;
		int iNezumiRow  = sc.nextInt() - 1;

		//街の様子
		String [][] mapOfTown = new String[iHeightOfTown][iWeightOfTown];
		for(int i = 0; i < mapOfTown.length; i++) {
			String[] strLineOfTown = sc.next().trim().split("");
			mapOfTown[i] = strLineOfTown;
		}
		sc.close();

		//ねずみ向きフラグ
		boolean bNezumiTurnRight = false;
		boolean bNezumiTurnLeft  = false;

		boolean bNezumiToNorth = true;
		boolean bNezumiToEast  = false;
		boolean bNezumiToWest  = false;
		boolean bNezumiToSouth = false;

		//ねずみ行動
		while(
			(iNezumiLine <= iHeightOfTown-1 && iNezumiLine >= 0) &&
			(iNezumiRow  <= iWeightOfTown-1 && iNezumiRow  >= 0)
			) {
			//家の交換 && 回転フラグ
			if(mapOfTown[iNezumiLine][iNezumiRow].equals(".")) {
				bNezumiTurnRight = true;
				mapOfTown[iNezumiLine][iNezumiRow] = "*";
			}else if(mapOfTown[iNezumiLine][iNezumiRow].equals("*")) {
				bNezumiTurnLeft = true;
				mapOfTown[iNezumiLine][iNezumiRow] = ".";
			}

			//方角決定
			if(bNezumiTurnLeft) {
				bNezumiTurnLeft = false;
				if(bNezumiToNorth) {
					bNezumiToNorth = false;
					bNezumiToWest  = true;
				}else if(bNezumiToEast) {
					bNezumiToEast  = false;
					bNezumiToNorth = true;
				}else if(bNezumiToSouth) {
					bNezumiToSouth = false;
					bNezumiToEast  = true;
				}else if(bNezumiToWest) {
					bNezumiToWest  = false;
					bNezumiToSouth = true;
				}
			}else if(bNezumiTurnRight){
				bNezumiTurnRight = false;
				if(bNezumiToNorth) {
					bNezumiToNorth = false;
					bNezumiToEast  = true;
				}else if(bNezumiToEast) {
					bNezumiToEast = false;
					bNezumiToSouth  = true;
				}else if(bNezumiToSouth) {
					bNezumiToSouth = false;
					bNezumiToWest  = true;
				}else if(bNezumiToWest) {
					bNezumiToWest = false;
					bNezumiToNorth  = true;
				}
			}

			//移動
			if(bNezumiToNorth) 		iNezumiLine--;
			else if(bNezumiToEast) 	iNezumiRow++;
			else if(bNezumiToSouth) 	iNezumiLine++;
			else if(bNezumiToWest) 	iNezumiRow--;
		}

		//結果の出力
		for(int i = 0; i < mapOfTown.length; i++) {
			for(int j = 0; j < mapOfTown[i].length; j++) {
				System.out.print(mapOfTown[i][j]);
			}System.out.println("");
		}
	}

}