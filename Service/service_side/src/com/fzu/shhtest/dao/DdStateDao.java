package com.fzu.shhtest.dao;

import java.util.List;

import com.fzu.shhtest.domain.DdState;
public interface DdStateDao {
	//��
	int createDdState(DdState ddState);
	
	//ɾ
	boolean deleteDdStateByName(String dname);
	//��
	boolean updateDdStateStateByName(DdState ddState,String oldDname);

	//��
	DdState getDdStateStateByName(String dname);
	List getAllDdState();
}
