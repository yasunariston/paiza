package question;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class C043 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int player = sc.nextInt();
		int[] id = new int[player];
		for(int i=0; i<id.length; i++) id[i] = sc.nextInt();
		sc.close();
		Map<Integer, Integer> id_list = new TreeMap<Integer, Integer>();

		int max = 1;
		for(int i=0; i<id.length; i++) {
			if(id_list.containsKey(id[i])) {
				id_list.put(id[i], 1);
			}else {
				id_list.put(id[i], id_list.get(id[i])+1);
				if(id_list.get(id[i]) > max) max = id_list.get(id[i]);
			}
		}

		for(int key: id_list.keySet()) {
			int value = id_list.get(key);
			if(value == max) System.out.print(key + "");
		}
		System.out.println("");

//		int max=1;
//		for(int i=0; i<id.length; i++) {
//			if(id_list.containsKey(id[i])) id_list.put(id[i], 1);
//			else {
//				id_list.put(id[i], id_list.get(id[i])+1);
//				if(id_list.get(id[i])>max) max = id_list.get(id[i]);
//			}
//		}
//
//		for(int key: id_list.keySet()) {
//			int value = id_list.get(key);
//			if(value == max) System.out.print(key + "");
//		}
//		System.out.println("");
	}
}
