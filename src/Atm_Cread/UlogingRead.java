package Atm_Cread;

import java.util.Scanner;

import Atm_Domain.Userlogin;

public class UlogingRead {
private Scanner consoleread;
public Userlogin checkuserloging() {
	consoleread=new Scanner(System.in);
	Userlogin userlogin = new Userlogin();
	System.out.println("Enter the uuid:");
	userlogin.setUuid(consoleread.next());
	System.out.println("Enter the pin");
	userlogin.setPin(consoleread.nextInt());
	return userlogin;
}
}
