package question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A017 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//フィールド作成
		int iFieldHeight = sc.nextInt();
		int iFieldWidth  = sc.nextInt();
		int iFieldBlocks = sc.nextInt();
		//ブロックリストの作成
		List<Block> blockList = new ArrayList<Block>();
		for(int i = 0; i < iFieldBlocks; i++) {
			blockList.add(new Block(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		sc.close();

		//フィールド作成
		String[][] field = new String[iFieldHeight][iFieldWidth];
		for(int i = 0; i < iFieldHeight; i++) {
			for(int j = 0; j < iFieldWidth; j++) {
				field[i][j] = ".";
			}
		}

		//メイン処理
		for(int i = 0; i < iFieldBlocks; i++) {
			Block block = blockList.get(i);
			//ブロック左上位置の特定
			int ansHeight = getAnsHeight(block, field);

			//ブロックの書き込み
			write(ansHeight, block, field);
		}
		//出力
		printField(field);
	}

	//ブロックの左上位置を特定
	public static int getAnsHeight(Block block, String[][] field) {
		int ans = field.length - block.iBlockHeight;
		boolean flag = false;

		for(int i = 0; i < field.length - block.iBlockHeight; i++) {
			for(int j = 0; j < block.iBlockWidth; j++) {
				if(field[block.iBlockHeight + i][block.iBlockPosi + j].equals("#")){
					ans = i;
					flag = true;
					break;
				}
			}if(flag) break;
		}
		return ans;
	}

	//書き込み
	public static String[][] write(int ans, Block block, String[][] field) {
		for(int i = 0; i < block.iBlockHeight; i++) {
			for(int j = 0; j < block.iBlockWidth; j++) {
				field[ans + i][block.iBlockPosi + j] = "#";
			}
		}
		return field;
	}

	//出力
	public static void printField(String[][] field) {
		for(int i = 0; i < field.length; i++) {
			for(int j = 0; j < field[i].length; j++) {
				System.out.print(field[i][j]);
			}System.out.println("");
		}
	}
}

//ブロッククラス
class Block{
	int iBlockHeight;
	int iBlockWidth;
	int iBlockPosi;

	Block(int iBlockHeight, int iBlockWidth, int iBlockPosi){
		this.iBlockHeight = iBlockHeight;
		this.iBlockWidth  = iBlockWidth;
		this.iBlockPosi   = iBlockPosi;
	}
}