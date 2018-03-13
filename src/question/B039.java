package question;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class B039 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt() - 1;
		int[][] water = new int[n][4];
		for(int i = 0; i < water.length; i++) {
			for(int j = 0; j < water[i].length; j++) water[i][j] = sc.nextInt();
		}
		sc.close();

		Set<Integer> field = new TreeSet<Integer>();
		field.add(s);


		for(int i: field) {
			for(int j = 0; j < water.length; j++) {
				if(
				((water[i][0] >= water[j][0] && water[i][0] <= water[j][2]) ||
				(water[i][2] >= water[j][0] && water[i][2] <= water[j][2])) &&
				((water[i][1] >= water[j][1] && water[i][1] <= water[j][3]) ||
				(water[i][3] >= water[j][1] && water[i][3] <= water[j][3]))
				) {
					if(! field.contains(j)) {
						field.add(j);
					}
				}
			}

		}
		for(int i: field)
		System.out.println(i + 1);
	}
}
