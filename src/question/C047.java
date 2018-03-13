package question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C047 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iSearch_num = sc.nextInt();
		String[] strWordList = new String[iSearch_num];
		for(int i = 0; i < strWordList.length; i++) strWordList[i] = sc.next().trim();
		sc.close();

		List<String> strSearchList = new ArrayList<String>();

		for(String value: strWordList) {
			for(int i = 0; i < strSearchList.size(); i++) {
				if(value.equals(strSearchList.get(i))) {
					strSearchList.remove(i);
					break;
				}
			}
			strSearchList.add(value);
		}

		for(int i = strSearchList.size()-1; i >= 0;i--) System.out.println(strSearchList.get(i));
	}
}
