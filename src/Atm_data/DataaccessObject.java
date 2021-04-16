package Atm_data;

import java.util.List;

public interface DataaccessObject {
	void insert(Object object);

	public abstract List<Object> listall();

	void update(Object object);

	Object findprimarykey(int id);

	void delete(int id);
}
