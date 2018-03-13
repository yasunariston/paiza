package question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A018 {

	public static void main(String[] args) {
		Scanner sc 		= new Scanner(System.in);
		int iWidth 		= sc.nextInt();
		int iHeight 		= sc.nextInt();
		int iCameraNum 	= sc.nextInt();
		int iItemNum 	= sc.nextInt();

		List<Camera> 	camera_list 	= new ArrayList<Camera>();
		List<Item>		item_list 	= new ArrayList<Item>();
		for(int i = 0; i < iCameraNum; i++) {
			camera_list.add(new Camera(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()));
		}
		for(int i = 0; i < iItemNum; i++) {
			item_list.add(new Item(sc.nextInt(),sc.nextInt()));
		}
		sc.close();

		for(int i = 0; i < iCameraNum; i++) {
			for(int j = 0; j < iItemNum; j++) {
				int cx = camera_list.get(i).i_x;
				int cy = camera_list.get(i).i_y;
				int cr = camera_list.get(i).iLength;
				int ca = camera_list.get(i).iAngle;
				int cs = camera_list.get(i).iScope;

				int ix = item_list.get(i).i_x;
				int iy = item_list.get(i).i_y;

				if(
					Math.pow(ix-cx, 2) + Math.pow(iy-cy, 2) <= Math.pow(cr, 2)

				) {

					item_list.get(i).covered = true;
				}
			}
		}


		//判定
		for(int i = 0; i < iItemNum; i++) {
			if(item_list.get(i).covered)	System.out.println("YES");
			else 						System.out.println("NO");
		}
	}
}

class Camera{

	int i_x;
	int i_y;
	int iAngle;
	int iScope;
	int iLength;

	Camera(int i_x, int i_y, int iAngle, int iScope, int iLength){
		this.i_x	 	= i_x;
		this.i_y	 	= i_y;
		this.iAngle	= iAngle;
		this.iScope	= iScope;
		this.iLength	= iLength;
	}
}

class Item{
	int i_x;
	int i_y;
	boolean covered = false;

	Item(int i_x, int i_y){
		this.i_x = i_x;
		this.i_y = i_y;
	}
}
