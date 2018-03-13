package question;

import java.util.Scanner;

public class D085 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine().trim();
		String wordList = sc.nextLine();
		sc.close();

		if(wordList.contains(word)) System.out.println("YES");
		else System.out.println("NO");


//		String[] wordList = new String[10];
//		for(int i = 0; i < 10; i++) wordList[i] = sc.next().trim();
//		sc.close();
//
//		boolean check = false;
//		for(int i = 0; i < 10; i++) {
//			if(word.equals(wordList[i])) check = true;
//		}
//
//		if(check) System.out.println("YES");
//		else System.out.println("NO");
	}
}