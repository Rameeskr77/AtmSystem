package Atm_service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import Atm_Domain.Currentbalance;
import Atm_data.relationdatabaseinfo;
import Atm_main.Atm;

public class BalaceServise extends Currentbalance{
 private Connection connection;
 private PreparedStatement statement;
// UserService us = new  UserService(null);
	DecimalFormat monyeformate=new DecimalFormat("'Rs'###,##0.00");
	public void currentWithdrowel(String s) throws Exception {
		System.out.println("Your current Acoount balace is"+monyeformate.format(UserService.getCbalance(s)));
		System.out.println("Enter the Amout withdorw");
		double amount=Atm.input.nextDouble();
		if((UserService.getCbalance(s)-amount)>0) {
			
			updateCwbalance(s,amount);
			System.out.println("\nYour Update amount"+monyeformate.format(UserService.getCbalance(s)));
			Thread.sleep(600);
			System.out.println("\n thank you Return to account type");
		}
			else if((UserService.getCbalance(s)-amount)==0) 
				System.out.println("\007"+"\n\t you cannot withdrow zero");
				else
					System.out.println("\007"+"\n** insufitiond balace");
		}

	public void currentdeposit(String s) throws Exception {
		System.out.println("your current acount balance"+monyeformate.format(UserService.getCbalance(s)));
		System.out.println("Enter the amound depocit");
		double amount= Atm.input.nextDouble();
		if(UserService.getCbalance(s)<=0) {
			cdepositWithzero(s, amount);
		}
		else if((UserService.getCbalance(s)+amount)>0) {
		   updateCdbalance(s, amount);
			System.out.println("Amount is deposit succssfully");
			Thread.sleep(600);
			System.out.println("\n you current acount balance"+monyeformate.format(UserService.getCbalance(s)));
		}
		else {
			System.out.println("\007"+"enter amound lover or equal ZERO");
		}
	}
	
	
		public void savingtWithdrowel(String s) throws Exception {
			System.out.println("Your current Acoount balace is"+monyeformate.format(UserService.getSbalance(s) ));
			System.out.println("Enter the Amout withdorw");
			double amount=Atm.input.nextDouble();
			if((UserService.getSbalance(s)-amount)>0) {
			updateSwbalance(s, amount);
				System.out.println("\nYour Update amount"+monyeformate.format(UserService.getSbalance(s)));
				Thread.sleep(600);
				System.out.println("\n thank you Return to account type");
			}
				else if(( UserService.getSbalance(s)-amount)==0) 
					System.out.println("\007"+"\n\t you cannot withdrow zero");
					else
						System.out.println("\007"+"\n** insufitiond balace");
			}
		public void savingdeposit(String s) throws Exception {
			System.out.println("your current acount balance"+monyeformate.format(UserService.getSbalance(s)));
			System.out.println("Enter the amound depocit");
			double amount= Atm.input.nextDouble();
			if(UserService.getSbalance(s)<=0) {
				sdepositWithzero(s, amount);
			}
			else if((UserService.getSbalance(s)+amount)>0) {
			updateSdbalance(s,amount);
				System.out.println("Amount is deposit succssfully");
				Thread.sleep(600);
				System.out.println("\n you current acount balance"+monyeformate.format(UserService.getSbalance(s)));
			}
			else {
				System.out.println("\007"+"enter amound lover or equal ZERO");
			}
		}
	
	
//	Current acount updates
	public void updateCwbalance(String s,double amount) throws ClassNotFoundException, SQLException {
	setCBalance(UserService.getCbalance(s));
	double balance=	cBalanceWithdrwel(amount);
	connection=relationdatabaseinfo.getConnection();
	statement=connection.prepareStatement("UPDATE currentbalance SET balance= ? WHERE uid = ?");
	statement.setDouble(1, balance);
	statement.setString(2, s);
	statement.executeUpdate();
	statement.close();
	connection.close();
	}
	public void updateCdbalance(String s,double amount) throws ClassNotFoundException, SQLException {
		setCBalance(UserService.getCbalance(s));
		double balance=	currentBalanceDepocit(amount);
		connection=relationdatabaseinfo.getConnection();
		statement=connection.prepareStatement("UPDATE currentbalance SET balance= ? WHERE uid = ?");
		statement.setDouble(1, balance);
		statement.setString(2, s);
		statement.executeUpdate();
		statement.close();
		connection.close();
	}
	
	public void cdepositWithzero(String s, double balance) throws ClassNotFoundException, SQLException {
		connection=relationdatabaseinfo.getConnection();
		statement=connection.prepareStatement("INSERT INTO currentbalance ( uid, balance) values(?, ?)",
					statement.RETURN_GENERATED_KEYS);
		statement.setString(1, s);
		statement.setDouble(2, balance);
		statement.executeUpdate();
		System.out.println(" Depocit successfully.");
		statement.close();
		connection.close();
	}
	
	
//	savings acount updates
	public void updateSwbalance(String s,double amount) throws ClassNotFoundException, SQLException {
	setsBalance(UserService.getSbalance(s));
	double balance=	savingBalanceWithdrowel(amount);
	connection=relationdatabaseinfo.getConnection();
	statement=connection.prepareStatement("UPDATE Sevingsbalance SET balance= ? WHERE uid = ?");
	statement.setDouble(1, balance);
	statement.setString(2, s);
	statement.executeUpdate();
	statement.close();
	connection.close();
	}
	public void updateSdbalance(String s,double amount) throws ClassNotFoundException, SQLException {
		setsBalance(UserService.getSbalance(s));
		double balance=	savingBalnceDeoocit(amount);
		connection=relationdatabaseinfo.getConnection();
		statement=connection.prepareStatement("UPDATE Sevingsbalance SET balance= ? WHERE uid = ?");
		statement.setDouble(1, balance);
		statement.setString(2, s);
		statement.executeUpdate();
		statement.close();
		connection.close();
	}
	
	public void sdepositWithzero(String s, double balance) throws ClassNotFoundException, SQLException {
		connection=relationdatabaseinfo.getConnection();
		statement=connection.prepareStatement("INSERT INTO Sevingsbalance ( uid, balance) values(?, ?)",
					statement.RETURN_GENERATED_KEYS);
		statement.setString(1, s);
		statement.setDouble(2, balance);
		statement.executeUpdate();
		System.out.println(" Depocit successfully.");
		statement.close();
		connection.close();
	}
}
