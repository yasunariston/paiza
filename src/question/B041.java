package question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B041 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int K = Integer.parseInt(sc.nextLine());
		int N = Integer.parseInt(sc.nextLine());
		List<String> image = new ArrayList<String>();
		for(int i = 0; i < N; i++) image.add(sc.nextLine());
		sc.close();

		for(int i = 0; i < K; i++) {
			remark(image);
		}
	}

	public static List<String> remark(List<String> field){
		int startSize = field.size();
		int lastSize = field.size()^2;
		for(int i = 0; i < lastSize; i += startSize) {
			for(int j = 0; j < lastSize; j += startSize) {
				char check = field.get(i).charAt(j);
				if(check == '.') {
					//TODO 繰り返し構文　保留
				}

			}
		}
		return field;
	}
}
