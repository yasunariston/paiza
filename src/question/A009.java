package question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A009 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		List<String[]> field = new ArrayList<String[]>();
		for(int i = 0; i < H; i++) field.add(sc.next().split(""));
		sc.close();

		int news = 1;
		int line = 0;
		int row = 0;
		int count = 1;
		//擬似的なループ
		boolean in = true;
		while(in) {
			if(field.get(line)[row].equals("/")) {
				if(news == 0 || news == 2) news++;
				else if(news == 1 || news == 3) news--;
			}
			else if(field.get(line)[row].equals("\\")) {
				if(news == 0 || news == 2) news--;
				else if(news == 1 || news == 3) news++;
			}
			news = (news + 4) % 4;

			if(news == 0) line--;
			else if(news == 1) row++;
			else if(news == 2) line++;
			else if(news == 3) row--;
			if(line >= H || line < 0|| row >= W || row < 0) break;
			count++;
		}
		System.out.println(count);
	}
}