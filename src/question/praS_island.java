package question;

import java.util.Scanner;

public class praS_island {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		Island[][] field = new Island[N][M];
		for(int i = 0; i < field.length; i++) {
			for(int j = 0; j < field[i].length; j++) field[i][j] = Island.valueOf(sc.nextInt());
		}
		sc.close();

		int count = 0;
		for(int i = 0; i < field.length; i++) {
			for(int j = 0; j < field[i].length; j++) {
				if(field[i][j].equals(Island.land)) {
					int left = 0; int right = j; int over = 0; int under = i;
					if(j != 0) left = j - 1;
					if(j != field[i].length - 1) right = j + 1;
					if(i != 0) over = i - 1;
					if(i != field.length - 1) under = i + 1;

					//配列外のアクセスにどのように対応するか。
				}
			}
		}
	}
}

enum Island{
	land(1), sea(0);
	private boolean check;
	private int id;

	//コンストラクタ
	private Island(int id) {
		this.id= id;
		if(this.id == 1)	this.check = true;
		else				this.check = false;
	}

	//ゲッター
	public int getId() {return this.id;}
	public boolean getCheck() {return this.check;}

	//valueOfのオーバーライド
	public static Island valueOf(int id) {
		for(Island i: Island.values()) {
			if(id == i.getId()) return i;
		}
		return null;
	}
}
