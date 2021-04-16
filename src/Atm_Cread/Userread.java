package Atm_Cread;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Atm_Domain.User;
import Atm_data.DataaccessObject;

public class Userread {
private Scanner consoleread;
User user =new User();
public User biulduser(DataaccessObject dao) {
	boolean result=true;
	List<User> userlist= new ArrayList<User>();
	consoleread=new Scanner(System.in);
	System.out.println("Enter the userid");
	user.setUserid(consoleread.nextInt());
	System.out.println("Enter the Name:");
	user.setName(consoleread.next());
	System.out.println("Enter the age");
	user.setage(consoleread.nextInt());
	System.out.println("Enter the uuid");
	String uuid=(consoleread.next());
	List<Object> objects= dao.listall();
	for(Object ol:objects) {
		userlist.add((User) ol);
	}
	for(User u : userlist) {
	if(uuid.equals(u.getUuid())) {
		result=false;
		break;
	}
	}
	if (result==false) {
		System.err.println("Please Enter the uniqe id. uuid is not Available.");
		biulduser(dao);
	}  if (result==true) {
		user.setUuid(uuid);
		System.out.println("Enter the pin");
	int pin1 = consoleread.nextInt();
	int pin=pin1^918273645;
	user.setPin(pin);
	}
	return user;
}
}
