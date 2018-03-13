package question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class B026 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Map<String, Integer> coinMap = new HashMap<String, Integer>();
		//コインリスト作成
		coinMap.put("v_500", sc.nextInt());
		coinMap.put("v_100", sc.nextInt());
		coinMap.put("v_50", sc.nextInt());
		coinMap.put("v_10", sc.nextInt());

		//購入客のリスト作成
		int iGuest = sc.nextInt();
		List<Guest> guestList = new ArrayList<Guest>();
		for(int i = 0; i < iGuest; i++) {
			guestList.add(new Guest(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		sc.close();

		//メイン
		for(int i = 0; i < guestList.size(); i++) {
			Guest guest = guestList.get(i);
			coinCalc(guest, coinMap);
		}
	}

	public static void coinCalc(Guest guest, Map<String, Integer> m) {
		//購入処理
		int all = guest.g_500 * 500 + guest.g_100 * 100 + guest.g_50 * 50 + guest.g_10 * 10;
		int o = all - guest.drink;
		int o_500 = o/500;
		int o_100 = (o - o_500 * 500)/100;
		int o_50  = (o - o_500 * 500 - o_100 * 100)/50;
		int o_10  = (o - o_500 * 500 - o_100 * 100 - o_50 * 50)/10;
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

class Guest{
	int drink;
	int g_500;
	int g_100;
	int g_50;
	int g_10;

	Guest(int drink, int g_500, int g_100, int g_50, int g_10){
		this.drink = drink;
		this.g_500 = g_500;
		this.g_100 = g_100;
		this.g_50 = g_50;
		this.g_10 = g_10;
	}
}