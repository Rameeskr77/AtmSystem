package Atm_Domain;

public class Admin {
private String Adminid;
private int pin;
public Admin() {
	super();
	// TODO Auto-generated constructor stub
}
public Admin(String adminid, int pin) {
	super();
	Adminid = adminid;
	this.pin = pin;
}
public String getAdminid() {
	return Adminid;
}
public void setAdminid(String adminid) {
	Adminid = adminid;
}
public int getPin() {
	return pin;
}
public void setPin(int pin) {
	this.pin = pin;
}
@Override
public String toString() {
	return "Admin [Adminid=" + Adminid + ", pin=" + pin + "]";
}

}
