package com.fzu.shhtest.dao;

import java.util.List;
import com.fzu.shhtest.domain.DdRole;

public interface DdRoleDao {
	//��
	int createDdRole(DdRole ddRole);
	
	//ɾ
	boolean deleteDdRoleByName(String dname);
	
	//��
	boolean updateDdRoleStateByName(DdRole ddRole,String oldDname);
	
	//��
	DdRole getDdRoleStateByName(String dname);
	List getAllDdRole();	
}
