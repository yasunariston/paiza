package question;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B040 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		String[] key = sc.nextLine().trim().split("");
		String[] code = sc.nextLine().split("");
		sc.close();

		String a = "abcdefghijklmnopqrstuvwxyz";
		String[] alpha = a.split("");

		Map<String, String> abc = new HashMap<String, String>();
		for(int i=0; i<alpha.length; i++) {
			abc.put(key[i], alpha[i]);
		}

		for(int i=0; i<n; i++) {
			for(int x=0; x<code.length; x++) {
				for(int y=0; y<abc.size(); y++) {
					if(code[x].equals(key[y])) {
						code[x] = abc.get(key[y]);
						break;
					}
				}
			}
		}

		for(String value: code)System.out.print(value);
	}

}
