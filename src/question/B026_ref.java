package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class B026_ref {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//コインリスト ラムダ
		int[] coin = Arrays.stream(sc.nextLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();

		//購入客のリスト作成　ラムダ
		int iGuest = sc.nextInt();
		List<int[]> guestList = new ArrayList<int[]>();
		for(int i = 0; i < iGuest; i++) {
			guestList.add(Arrays.stream(sc.nextLine().split(" "))
					.mapToInt(Integer::parseInt).toArray());
		}
		sc.close();

		//メイン　forEach
		guestList.forEach(g -> coinCalc(g, coin));
	}

	public static void coinCalc(int[] guest, int[] coin) {
		int[] type = {500, 100, 50, 10};
		//購入処理
		int all = 0;
		for(int i = 0; i < type.length; i++) all += guest[i + 1] * type[i];

		int[] otsuri = new int[4];
		for(int i = 0; i < otsuri.length; i++) {
			otsuri[i] = guest[0] % type[i];
			if(coin[i] > otsuri[i]) {
				guest[0] -= otsuri[i] * type[i];
			}else if(i == 2 && otsuri[i + 1] >= 5) {

			}
		}

		boolean o_flag = true;
		boolean flag_50 = true;

		if(o_500 > m.get("v_500")) o_flag = false;
		if(o_100 > m.get("v_100")) o_flag = false;
		while(flag_50) {
			if(o_50 > m.get("v_50")) {
				o_10 += 5;
				o_50--;
			}else flag_50 = false;
		}
		if(o_10 > m.get("v_10")) o_flag = false;

		if(o_flag) {
			m.put("v_500", m.get("v_500") - o_500 + guest.g_500);
			m.put("v_100", m.get("v_100") - o_100 + guest.g_100);
			m.put("v_50", m.get("v_50") - o_50 + guest.g_50);
			m.put("v_10", m.get("v_10") - o_10 + guest.g_10);
			System.out.println(o_500 + " " + o_100 + " " + o_50 + " " + o_10);
		}else System.out.println("impossible");
	}
}

interface myFunc{
	public abstract int calcMoney(int[] i);
}
