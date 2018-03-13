package question;
import java.util.Scanner;

public class D082 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] wordA = sc.nextLine().split("");
		String[] wordB = sc.nextLine().split("");
		sc.close();

		int i = 0;
		if(wordA[wordA.length-1].equals(wordB[0])) i++;
		if(!wordB[wordB.length-1].equals("n")) i++;

		if(i==2) System.out.println("OK");
		else System.out.println("NG");
	}
}