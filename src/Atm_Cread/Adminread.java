package Atm_Cread;

import java.util.Scanner;

import Atm_Domain.Admin;

public class Adminread {
private Scanner consoleread;

public Admin bildadmin() {
	consoleread=new Scanner(System.in);
	Admin admin=new Admin();
	System.out.println("Enter the Admin id:");
	admin.setAdminid(consoleread.next());
	System.out.println("Enter the pin:");
	admin.setPin(consoleread.nextInt());
	return admin;
}
}
