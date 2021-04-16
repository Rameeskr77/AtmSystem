package Atm_Domain;

public class Userlogin {
	private String Uuid;
	private int pin;
	public Userlogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Userlogin(String uuid, int pin) {
		super();
		Uuid = uuid;
		this.pin = pin;
	}
	public String getUuid() {
		return Uuid;
	}
	public void setUuid(String uuid) {
		Uuid = uuid;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "Userlogin [Uuid=" + Uuid + ", pin=" + pin + "]";
	}
	
}
