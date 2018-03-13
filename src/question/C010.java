package question;

import java.util.Scanner;

public class C010 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); int b = sc.nextInt(); int r = sc.nextInt();
        int pN = sc.nextInt();
        int[] place = new int[pN*2];
        for(int i=0; i<place.length; i++) place[i] = sc.nextInt();
        sc.close();
        for(int i=0; i<place.length; i+=2) {
        		int x = place[i];    int y = place[i+1];
        		int dis = (int) Math.pow((x-a),2) + (int) Math.pow((y-b),2);
        		if(dis>=Math.pow(r, 2)) System.out.println("silent");
        		else System.out.println("noisy");
        }
	}
}
