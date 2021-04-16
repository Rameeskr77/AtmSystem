package Atm_Domain;

public class User {
private int userid;
private String Name;
private int age;
private String uuid;
private int pin;
public User() {
	super();
}
public User(int userid, String name, int age, String uuid, int pin) {
	super();
	this.userid = userid;
	Name = name;
	this.age = age;
	this.uuid = uuid;
	this.pin = pin;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public int getage() {
	return age;
}
public void setage(int age) {
	this.age = age;
}
public String getUuid() {
	return uuid;
}
public void setUuid(String uuid) {
	this.uuid = uuid;
}
public int getPin() {
	return pin;
}
public void setPin(int pin) {
	this.pin = pin;
}
@Override
public String toString() {
	return "User [userid=" + userid + ", Name=" + Name + ", age=" + age + ", uuid=" + uuid + ", pin=" + pin + "]";
}

}
