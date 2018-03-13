package question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class B036 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int stateNum = sc.nextInt();

		//政党の決定
		Map<Integer, String> partyMap = new HashMap<Integer, String>();
		for(int i = 0; i < stateNum; i++) partyMap.put(i, sc.next().trim());

		//voterList
		int voterNum = sc.nextInt();
		int[] vote = new int[stateNum];
		List<Voter> voterList = new ArrayList<Voter>();
		for(int i = 0; i < voterNum; i++) {
			for(int j = 0; j < stateNum; j++) vote[j] = sc.nextInt();
			voterList.add(new Voter(vote));
		}

		sc.close();

		//各党代表選出
		int rStand = decideStand(partyMap, voterList, "Republican");
		int dStand = decideStand(partyMap, voterList, "Democratic");

		//最終選出
		int rCount = 0;
		int dCount = 0;
		for(int i = 0; i < voterList.size(); i++) {
			Voter voter = voterList.get(i);
			for(int j = 0; j < stateNum; j++) {
				if(voter.num[j] == rStand) {
					rCount++;
					break;
				}
				if(voter.num[j] == dStand) {
					dCount++;
					break;
				}
			}
		}
		if(rCount > dCount) System.out.println(rStand);
		if(dCount > rCount) System.out.println(dStand);
	}


	//代表選出
	public static int decideStand(Map<Integer, String> partyMap, List<Voter> voterList, String party) {
		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		for(int i = 0; i < partyMap.size(); i++) countMap.put(i, 0);

		for(int i = 0; i < voterList.size(); i++) {
			Voter voter = voterList.get(i);
			for(int j = 0; j < partyMap.size(); j++) {
				String partyName =partyMap.get(voter.num[j] - 1);
				if(partyName.equals(party)) {
					countMap.put(voter.num[j], countMap.get(j) + 1);
					break;
				}
			}
		}

		int stand = 0;
		int count = 0;
		for(int i = 0; i < partyMap.size(); i++) {
			if(countMap.get(i) > count) {
				count = countMap.get(i);
				stand = i + 1;
			}
		}
		return stand;
	}

}

class Voter{
	int[] num;
	Voter(int[] num){
		this.num = num.clone();
	}
}