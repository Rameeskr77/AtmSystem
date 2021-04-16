package Atm_service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import Atm_Cread.UlogingRead;
import Atm_Domain.Balance;
import Atm_Domain.Currentbalance;
import Atm_Domain.User;
import Atm_Domain.Userlogin;
import Atm_data.DataaccessObject;
import Atm_data.relationdatabaseinfo;
import Atm_main.Atm;

public class UserService extends BalaceServise {
private DataaccessObject dao;
private  Connection connection;
private PreparedStatement statement;
DecimalFormat monyeformate=new DecimalFormat("'Rs'###,##0.00");
BalaceServise balanceservice=new BalaceServise();

public UserService(DataaccessObject dao) {
	super();
	this.dao = dao;
}
 
public String userlogin(List<Object> userlist) {
	boolean result = false;
	UlogingRead ur =new UlogingRead();
	Userlogin ul=ur.checkuserloging();
	try {
	List<User> userlist1 =new ArrayList<User>();
	for(Object o: userlist) {
		userlist1.add((User) o);
	}
	
	for(User u: userlist1) {
		if(u.getUuid().equals(ul.getUuid()) && u.getPin()==ul.getPin()) {
			System.out.println("\n\t\t"+u.getName()+"-----Welcome to virtual ATM------");
			result=true;
			accountType(ul.getUuid());
			break;
		}
	}
	if (result==false) {
		System.err.println("USER ACCESS DENAID!");
		System.out.println("please try again.....");
		result=false;
	}
	} catch (Exception e) {
		System.err.println("User access denaid!");
		System.out.println("please try again.....");
		result=false;
	}
	
	if(result == false) {
		userlogin(userlist);
	}
	String uniqid=ul.getUuid();
	return uniqid;
}


public void accountType(String s) throws Exception{
	System.out.println("\007"+"\n\n\t* Select the account type:");
	System.out.println("\t\t Type 1: Current Account");
	System.out.println("\t\t Type 2: Savings Account");
	System.out.println("\t\t Type 3: Exit");
	System.out.println("Choice");
	int choice =Atm.input.nextInt();
	switch (choice) {
	case 1: {
		currentAccount(s);
		break;
	}
	case 2: {
		savingsAccount(s);
		break;
	}
	case 3: {
		System.out.println("\t\t\n Thank u have nice DAY");
		System.exit(0);
	}
	default:
		System.err.println("\t\t\n invalide  select currectly");
		System.out.println("\n\t return to account type"); accountType(s);
		throw new IllegalArgumentException("Unexpected value: " + choice);
	}
}
public void currentAccount(String s) throws Exception {
	System.out.println("\n\tCURRENT ACCOUNT");
	System.out.println("\t\t Type 1: View BAlance");
	System.out.println("\t\t Type 2: WIthdrow fund");
	System.out.println("\t\t TYpe 3: Deposit fund");
	System.out.println("\t\t Type 4: return to account type");
	System.out.println("\t\t Type 5: Exit");
	System.out.println("Choice: ");
	byte choice= Atm.input.nextByte();
	switch (choice) {
	case 1: {
		
		System.out.println("\n your Current balace is:"+monyeformate.format(getCbalance(s)));
		if(getCbalance(s)<=0) {
			System.err.println("oops u balace is zero");
			System.out.println("please select Type 3 to Depocit fund");
			currentAccount(s);
		}
		
		else{
			accountType(s);
		}
		break;
	}
	case 2: {
		currentWithdrowel();
		accountType(s);
		break;
	}
	case 3: {
		currentdeposit();
		currentAccount(s);
		break;
	}
	case 4: {
		accountType(s);
		break;
	}
	case 5: {
		System.out.println("\t\t\n Thank u have nice DAY");
		Thread.sleep(600);
		System.exit(0);

	}
	default:
		System.err.println("\t\t\n invalide  select currectly");
		currentAccount(s);
		throw new IllegalArgumentException("Unexpected value: " + choice);
	}
	}
public void savingsAccount(String s) throws Exception {
	System.out.println("\n\t SAVINGS ACCOUNT");
	System.out.println("\t\t Type 1: View BAlance");
	System.out.println("\t\t Type 2: WIthdrow fund");
	System.out.println("\t\t TYpe 3: Deposit fund");
	System.out.println("\t\t Type 4: return to account type");
	System.out.println("\t\t Type 5: Exit");
	System.out.println("Choice: ");
	byte choice= Atm.input.nextByte();
	switch (choice) {
	case 1: {
		System.out.println("\n your Current balace is:"+monyeformate.format(getSavingsBalance()));
		if(getSavingsBalance()<=0) {
			System.err.println("oops u balace is zero");
			System.out.println("please select Type 3 to Depocit fund");
			savingsAccount(s);
		}
		
		else{
			accountType(s);
		}
		break;
	}
	case 2: {
		savingtWithdrowel();
		accountType(s);
		break;
	}
	case 3: {
		savingdeposit();
		savingsAccount(s);
		break;
	}
	case 4: {
		accountType(s);
		break;
	}
	case 5: {
		System.out.println("\t\t\n Thank u have nice DAY");
		System.exit(0);

	}
	default:
		System.err.println("\t\t\n invalide  select currectly");
		savingsAccount(s);
		throw new IllegalArgumentException("Unexpected value: " + choice);
	}
}
public double getCbalance(String s) throws ClassNotFoundException, SQLException {
	Currentbalance cub=new Currentbalance();
	String uuid=s;
	System.out.println(uuid);
	connection=relationdatabaseinfo.getConnection();
	statement=connection.prepareStatement("select balance from Currentbalance where uid=?");
	statement.setString(1, uuid);
	ResultSet rs = statement.executeQuery();
	while(rs.next()) {
		cub.setCBalance(rs.getDouble("balance"));
	}
double balance=cub.getCBalance();
return balance;
}
}
