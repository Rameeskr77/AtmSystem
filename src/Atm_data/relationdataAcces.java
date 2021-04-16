package Atm_data;

import java.util.List;

import Atm_Domain.User;

public abstract class relationdataAcces implements DataaccessObject{

	@Override
	public void insert(Object object) {
	
		insertobject(object);
	}

	@Override
	public List<Object> listall() {
	List<Object>objlist=listitem();
	return objlist;
	
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object findprimarykey(int id) {
	Object obj=	findkey(id);
		return obj;
	}

	@Override
	public void delete(int id) {
		deleteitemin(id);
		
	}
	protected abstract void insertobject(Object object);
	protected abstract List<Object> listitem();
	protected abstract void updation(Object object);
	protected abstract Object findkey(int id);
	protected abstract void deleteitemin(int id);
}
