package question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class B042{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int catsNumber	= sc.nextInt();
		int totalDis		= sc.nextInt();
		List<Cats> catsInfo = new ArrayList<Cats>();
		for(int i = 0; i < catsNumber; i++) catsInfo.add(new Cats(sc.nextInt(), sc.nextInt()));
		sc.close();


	}
}

class Cats{
	int eatTime;
	int disSati;

	Cats(int eatTime, int disSati){
		this.eatTime = eatTime;
		this.disSati = disSati;
	}
}