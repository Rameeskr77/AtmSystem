package Atm_main;

import java.util.List;
import java.util.Scanner;

import Atm_Cread.Adminread;
import Atm_Cread.UlogingRead;
import Atm_Cread.Userread;
import Atm_Domain.Admin;
import Atm_Domain.Userlogin;
import Atm_data.DataaccessObject;
import Atm_data.Userrelation;
import Atm_data.adminAccess;
import Atm_service.AdminService;
import Atm_service.UserService;

public class Atm {
	public static Scanner input=new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		Adminread ar=new Adminread();
		DataaccessObject dao =new adminAccess();
		AdminService as =new AdminService(dao);
		List<Object>userlist=dao.listall();
		
	//	User
		DataaccessObject dao1= new Userrelation();
		UserService us = new UserService(dao1);
		try {
			System.out.println("\n\t\t"+"-----Welcome to virtual ATM------");
			System.out.println("\t\t Type 1: Bank");
			System.out.println("\t\t Type 2: User");
			System.out.println("\t\t Type 3: Exit");
			System.out.println("Choice");
			int choice=input.nextInt();
			switch (choice) {
			case 1: {
				Admin admin= ar.bildadmin();
				as.login(admin);
				break;
			}
			case 2: {
			 us.userlogin(userlist);
				
				break;
			}
			case 3: {
				System.out.println("\t\t\n Thank u have nice DAY");
				System.exit(0);
			}
			default:
				System.err.println("\t\t\n invalide  select currectly");
				System.out.println("\n\t return to  type");
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		} catch (Exception e) {
			System.err.println("\t ATM is Temporary out of service");
		}
	}

}
