package question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = sc.nextLine().split("",0);
		sc.close();

		int[] keyCode = new int[s.length*2];

		List<List<String>> keyBox_height = new ArrayList<List<String>>();
		List<String>	 keyBox_width0 = new ArrayList<String>();
		List<String>	 keyBox_width1 = new ArrayList<String>();
		List<String>	 keyBox_width2 = new ArrayList<String>();
		keyBox_width0.add("q"); keyBox_width1.add("a"); keyBox_width2.add("z");
		keyBox_width0.add("w"); keyBox_width1.add("s"); keyBox_width2.add("x");
		keyBox_width0.add("e"); keyBox_width1.add("d"); keyBox_width2.add("c");
		keyBox_width0.add("r"); keyBox_width1.add("f"); keyBox_width2.add("v");
		keyBox_width0.add("t"); keyBox_width1.add("g"); keyBox_width2.add("b");
		keyBox_width0.add("y"); keyBox_width1.add("h"); keyBox_width2.add("n");
		keyBox_width0.add("u"); keyBox_width1.add("j"); keyBox_width2.add("m");
		keyBox_width0.add("i"); keyBox_width1.add("k");
		keyBox_width0.add("o"); keyBox_width1.add("l");
		keyBox_width0.add("p");

		keyBox_height.add(keyBox_width0);
		keyBox_height.add(keyBox_width1);
		keyBox_height.add(keyBox_width2);

		for(int a=0; a<s.length; a++) {
			boolean check = false;
			for(int i=0; i<keyBox_height.size(); i++) {
				for(int j=0; j<keyBox_height.get(i).size(); j++) {
					if(s[a].trim().equals(keyBox_height.get(i).get(j).trim())) {
						keyCode[2*a]=i;
						keyCode[2*a+1]=j;
						check = true;
						break;
					}
				}if(check) break;
			}
		}

		boolean rMissFlag = false;
		boolean lMissFlag = false;
		int count = 0;
		for(int i=0; i<keyCode.length; i+=2) {

			if(
			lMissFlag &&
			keyCode[i] - keyCode[i-2] >= -1 &&
			keyCode[i] - keyCode[i-2] <= 1 &&
			keyCode[i+1] - keyCode[i-1] >= -1 &&
			keyCode[i+1] - keyCode[i-1] <= 1 &&
			keyCode[i+1] >= 5
			) count++;
			else if(keyCode[i+1] != 4 && lMissFlag) lMissFlag=false;

			if(
			rMissFlag &&
			keyCode[i] - keyCode[i-2] >= -1 &&
			keyCode[i] - keyCode[i-2] <= 1 &&
			keyCode[i+1] - keyCode[i-1] >= -1 &&
			keyCode[i+1] - keyCode[i-1] <= 1 &&
			keyCode[i+1] <= 4
			) count++;
			else if(keyCode[i+1] != 5 && rMissFlag) rMissFlag=false;

			if(!lMissFlag && !rMissFlag && keyCode[i+1]==4) {
				lMissFlag=true;
				continue;
			}
			if(!lMissFlag && !rMissFlag && keyCode[i+1]==5) {
				rMissFlag=true;
				continue;
			}
		}

		System.out.println(count);
	}
}

//		int[] keyBox = new int[s.length*2];
//		for(int i=0; i<s.length; i++) {
//
//		}
//
//
//		boolean rMissFlag = false;
//		boolean lMissFlag = false;
//		int count = 0;
//		for(int i=0; i<s.length; i++) {
//			if(!rMissFlag && !lMissFlag && keyBox[i]==5) {
//				rMissFlag=true;
//				System.out.println("rFlag");
//				continue;
//			}
//			else if(!rMissFlag && !lMissFlag && keyBox[i]==4) {
//				lMissFlag=true;
//				System.out.println("lFlag");
//				continue;
//			}
//
//			if(rMissFlag &&
//			keyBox[i] <= 4 &&
//			keyBox[i] - keyBox[i-1] <= 1 &&
//			keyBox[i] - keyBox[i-1] >= -1
//			) count++;
//			else if(keyBox[i] != 5) rMissFlag=false; System.out.println("r解除");
//
//			if(lMissFlag &&
//			keyBox[i] >= 5 &&
//			keyBox[i] - keyBox[i-1] <= 1 &&
//			keyBox[i] - keyBox[i-1] >= -1
//			) count++;
//			else if(keyBox[i] != 4) lMissFlag=false; System.out.println("l解除");
//		}