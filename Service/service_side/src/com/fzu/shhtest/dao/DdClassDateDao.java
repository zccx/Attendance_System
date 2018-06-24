package com.fzu.shhtest.dao;

import java.util.List;

import com.fzu.shhtest.domain.DdClassDate;

public interface DdClassDateDao {
	//��
	int createDdClassDate(DdClassDate ddClassDate);
	
	//ɾ
	boolean deleteDdClassDateByName(String dname);
	
	//��
	boolean updateDdClassDateStateByName(DdClassDate ddClassDate,String oldDname);

	//��
	DdClassDate getDdClassDateStateByName(String dname);
	DdClassDate getDdClassDateStateByValue(int value);
	List getAllDdClassDate();	
}
