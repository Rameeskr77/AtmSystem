package Atm_service;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Atm_Cread.Adminread;
import Atm_Cread.Userread;
import Atm_Domain.Admin;
import Atm_Domain.User;
import Atm_data.DataaccessObject;
import Atm_main.Atm;

public class AdminService {
	private DataaccessObject dao;
	
	public AdminService(DataaccessObject dao) {
		super();
		this.dao = dao;
	}
	public void login(Admin admin) throws ClassNotFoundException, SQLException{
		boolean value=true;
		Adminread ar =new Adminread();
		try {
			Admin admin1=(Admin) dao.findprimarykey(admin.getPin());
			if(admin1.getAdminid().equals(admin.getAdminid()) && admin1.getPin()==admin.getPin()) {
				adminOption();
			}else {
				System.err.println("ADMIN ACCESS DENAID!");
				System.out.println("please try again.....");
				value=false;
			}
			
		} catch (Exception e) {
			System.err.println("Admin access denaid!");
			System.out.println("please try again.....");
			value=false;
		}
		if(value==false) {
			
			login(ar.bildadmin());
		}
}
	public void adminOption() {
		System.out.println("\007"+"\n\n\t* Select the Operation type:");
		System.out.println("\t\t Type 1: Add User");
		System.out.println("\t\t Type 2: Terminate User");
		System.out.println("\t\t Type 3: Exit");
		System.out.println("Choice:");
		int choice=Atm.input.nextInt();
		switch (choice) {
		case 1: {
			addUser();
			break;
		}
		case 2: {
			terminateUser();
			break;
		}
		case 3: {
			System.out.println("\t\t\n Thank u have nice DAY");
			System.exit(0);
			break;
		}
		default:
			System.err.println("\t\t\n invalide  select currectly");
			System.out.println("\n\t return to account type"); adminOption();;
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
	}
public void	addUser() {
	Userread ur =new Userread();
	User user=ur.biulduser(dao);
	dao.insert(user);
	adminOption();
}
public void terminateUser() {
	boolean result = false;
	List<User> userliList = new ArrayList<User>();
	User user=new User();
	Scanner sc=new Scanner(System.in);
	
    List<Object>objlist=dao.listall();
    for(Object o: objlist ) {
    	userliList.add((User) o);
    }
    for(User us:userliList) {
    	System.out.println(us);
    }
    System.out.println("Enter the Uuid:");
	user.setUuid(sc.next());
	System.out.println("Enter the Pin");
	user.setPin(sc.nextInt());
    for(User u: userliList) {
    	if(u.getUuid().equals(user.getUuid()) && u.getPin()==user.getPin()) {
    		dao.delete(user.getPin());
 
    		adminOption();
    		result=true;
    		break;
    	}
    }
    if(result==false) {
    	System.err.println("user not available");
    	adminOption();
    }
}
}