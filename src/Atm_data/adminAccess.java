package Atm_data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Atm_Domain.Admin;
import Atm_Domain.User;

public class adminAccess extends relationdataAcces {
private Connection connection;
private PreparedStatement statment;
	@Override
	protected void insertobject(Object object) {
		User user=(User)object;
		try {
			connection=relationdatabaseinfo.getConnection();
			statment=connection.prepareStatement("INSERT INTO Uregistration (userid, name, age, uuid, pin) values(?, ?, ?,?,?)");
			statment.setInt(1, user.getUserid());
			statment.setString(2, user.getName());
			statment.setInt(3, user.getage());
			statment.setString(4, user.getUuid());
			statment.setInt(5, user.getPin());
			statment.executeUpdate();
			System.out.println( user.getName()+  " saved successfully.");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statment.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	protected List<Object> listitem() {
		List<Object> listobj= new ArrayList<Object>();
		try {
			connection= relationdatabaseinfo.getConnection();
			statment=connection.prepareStatement("SELECT * FROM Uregistration;");
		    ResultSet rs=statment.executeQuery();
		    while(rs.next()) {
		    	int i=rs.getInt(5)^918273645;
		    	User user =new User(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),i);
		    	listobj.add(user);
		    }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statment.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listobj;
	}

	@Override
	protected void updation(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Object findkey(int id) {
		Admin admin =new Admin();
		try {
			connection=relationdatabaseinfo.getConnection();
			statment=connection.prepareStatement("SELECT * FROM admin where pin=?");
			statment.setInt(1, id);
			ResultSet rs = statment.executeQuery();
			while(rs.next()) {
				admin.setAdminid(rs.getString(1));
				admin.setPin(rs.getInt(2));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statment.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return admin;
		
	}

	@Override
	protected void deleteitemin(int id) {
		try {
			int cry=id^918273645;
			connection=relationdatabaseinfo.getConnection();
			statment=connection.prepareStatement("DELETE FROM Uregistration WHERE pin=?");
			statment.setInt(1, cry);
			statment.executeUpdate();
			System.out.println("terminate succsed");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statment.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
