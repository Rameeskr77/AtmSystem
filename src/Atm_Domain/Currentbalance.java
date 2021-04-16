package Atm_Domain;

public class Currentbalance {
	private double cBalance;
	public double getCBalance() {
		return cBalance;
	}
	public void setCBalance(double cBalance) {
		this.cBalance = cBalance;
	}
	public double cBalanceWithdrwel(double amount) {
		cBalance=(cBalance-amount);
		return cBalance;	
	}
	public double currentBalanceDepocit(double amount) {
		cBalance=(cBalance+amount);
		return cBalance;
	}
	@Override
	public String toString() {
		return "Currentbalance [currentBalance=" + cBalance + "]";
	}
	
}
