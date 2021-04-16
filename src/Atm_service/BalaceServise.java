package Atm_service;

import java.text.DecimalFormat;

import Atm_Domain.Balance;
import Atm_main.Atm;

public class BalaceServise extends Balance{
	DecimalFormat monyeformate=new DecimalFormat("'Rs'###,##0.00");
	public void currentWithdrowel() throws Exception {
		System.out.println("Your current Acoount balace is"+monyeformate.format(getCurrentBalance()));
		System.out.println("Enter the Amout withdorw");
		double amount=Atm.input.nextDouble();
		if((getCurrentBalance()-amount)>0) {
			currentBalanceWithdrwel(amount);
			System.out.println("\nYour Update amount"+monyeformate.format(getCurrentBalance()));
			Thread.sleep(600);
			System.out.println("\n thank you Return to account type");
		}
			else if((getCurrentBalance()-amount)==0) 
				System.out.println("\007"+"\n\t you cannot withdrow zero");
				else
					System.out.println("\007"+"\n** insufitiond balace");
		}

	public void currentdeposit() throws Exception {
		System.out.println("your current acount balance"+monyeformate.format(getCurrentBalance()));
		System.out.println("Enter the amound depocit");
		double amount= Atm.input.nextDouble();
		if((getCurrentBalance()+amount)>0) {
		   currentBalanceDepocit(amount);
			System.out.println("Amount is deposit succssfully");
			Thread.sleep(600);
			System.out.println("\n you current acount balance"+monyeformate.format(getCurrentBalance()));
		}
		else {
			System.out.println("\007"+"enter amound lover or equal ZERO");
		}
	}
		public void savingtWithdrowel() throws Exception {
			System.out.println("Your current Acoount balace is"+monyeformate.format(getSavingsBalance() ));
			System.out.println("Enter the Amout withdorw");
			double amount=Atm.input.nextDouble();
			if((getSavingsBalance()-amount)>0) {
			savingBalanceWithdrowel(amount);
				System.out.println("\nYour Update amount"+monyeformate.format(getSavingsBalance()));
				Thread.sleep(600);
				System.out.println("\n thank you Return to account type");
			}
				else if(( getSavingsBalance()-amount)==0) 
					System.out.println("\007"+"\n\t you cannot withdrow zero");
					else
						System.out.println("\007"+"\n** insufitiond balace");
			}
		public void savingdeposit() throws Exception {
			System.out.println("your current acount balance"+monyeformate.format(getSavingsBalance()));
			System.out.println("Enter the amound depocit");
			double amount= Atm.input.nextDouble();
			if((getSavingsBalance()+amount)>0) {
			savingBalnceDeoocit(amount);
				System.out.println("Amount is deposit succssfully");
				Thread.sleep(600);
				System.out.println("\n you current acount balance"+monyeformate.format(getSavingsBalance()));
			}
			else {
				System.out.println("\007"+"enter amound lover or equal ZERO");
			}
		}
}
