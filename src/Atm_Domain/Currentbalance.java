package Atm_Domain;

public class Currentbalance {
	private  double cBalance;
	private double sBalance;
	public  double getCBalance() {
		return cBalance;
	}
	public void setCBalance(double cBalance) {
		this.cBalance = cBalance;
	}
	
	public double getsBalance() {
		return sBalance;
	}
	public void setsBalance(double sBalance) {
		this.sBalance = sBalance;
	}
	public double cBalanceWithdrwel(double amount) {
		cBalance=(cBalance-amount);
		return cBalance;	
	}
	public double currentBalanceDepocit(double amount) {
		cBalance=(cBalance+amount);
		return cBalance;
	}
	public double savingBalanceWithdrowel(double amount) {
		sBalance=(sBalance-amount);
		return sBalance;
	}
	public double savingBalnceDeoocit(double amuont) {
		sBalance=(sBalance+amuont);
		return sBalance;
	}
	@Override
	public String toString() {
		return "Currentbalance [cBalance=" + cBalance + ", sBalance=" + sBalance + "]";
	}
	
	
}
