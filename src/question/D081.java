package question;

import java.util.Scanner;

public class D081 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int fN = sc.nextInt();
        int h = sc.nextInt(); int w = sc.nextInt();
        sc.close();
        int sN = h*w;
        System.out.println(sN%fN);
	}
}
