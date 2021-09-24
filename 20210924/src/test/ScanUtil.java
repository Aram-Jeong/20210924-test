package test;

import java.util.Scanner;

public class ScanUtil {
	static Scanner scn = new Scanner(System.in);
	
	public static int readInt(String msg) {
		System.out.println(msg);
		int num=scn.nextInt();
		scn.nextLine();
		return num;
		
	}

	public static String readStr(String msg) {
		
		System.out.println(msg);
		return scn.nextLine();
		
	}
	
	public static Gender readGender(String msg) {
		System.out.println(msg);
		String gender =  scn.nextLine();
		Gender resultGender = Gender.valueOf(gender);
		return resultGender;
	}
	
}
