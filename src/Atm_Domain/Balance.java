package Atm_Domain;




public class Balance {
	private double currentBalance;
	private double savingsBalance;
	
	public double getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	public double getSavingsBalance() {
		return savingsBalance;
	}
	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	public double currentBalanceWithdrwel(double amount) {
		currentBalance=(currentBalance-amount);
		return currentBalance;	
	}
	public double currentBalanceDepocit(double amount) {
		currentBalance=(currentBalance+amount);
		return currentBalance;
	}
	public double savingBalanceWithdrowel(double amount) {
		savingsBalance=(savingsBalance-amount);
		return savingsBalance;
	}
	public double savingBalnceDeoocit(double amuont) {
		savingsBalance=(savingsBalance+amuont);
		return savingsBalance;
	}
}
