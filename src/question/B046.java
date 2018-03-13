package question;

import java.util.Scanner;

public class B046 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//int 		road_num 		= sc.nextInt();
		int 		start_road 		= sc.nextInt();
		String 	start_compass 	= sc.nextLine().trim();
		int 		goal_road 		= sc.nextInt();
		String 	goal_compass 	= sc.nextLine().trim();
		sc.close();

		boolean turn_flag = false;
		boolean over_flag = false;
		if(start_compass.equals("S")) {
			if(goal_compass.equals("E") || goal_compass.equals("W")) turn_flag = true;
			else if(goal_compass.equals("N")) over_flag = true;
		}else if(start_compass.equals("E")) {
			if(goal_compass.equals("N") || goal_compass.equals("S")) turn_flag = true;
			else if(goal_compass.equals("W")) over_flag = true;
		}else if(start_compass.equals("N")) {
			if(goal_compass.equals("W") || goal_compass.equals("E")) turn_flag = true;
			else if(goal_compass.equals("S")) over_flag = true;
		}else if(start_compass.equals("W")) {
			if(goal_compass.equals("S") || goal_compass.equals("N")) turn_flag = true;
			else if(goal_compass.equals("E")) over_flag = true;
		}

		double ans = 0;
		double road_length = 100;
		double distance = Math.abs(goal_road - start_road);
		if(turn_flag) {
			if(start_road >= goal_road) ans = (distance + (Math.PI * goal_road / 2)) * road_length;
			else ans = ((start_road * Math.PI / 2) + distance) * road_length;
		}
		else if(over_flag)	 ans = (start_road + goal_road) * road_length;
		else 				 ans = distance * road_length;

		System.out.println(ans);
	}
}
