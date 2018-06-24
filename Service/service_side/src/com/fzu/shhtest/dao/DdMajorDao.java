package com.fzu.shhtest.dao;

import java.util.List;
import com.fzu.shhtest.domain.DdMajor;

public interface DdMajorDao {
	//��
	int createDdMajor(DdMajor ddMajor);
	
	//ɾ
	boolean deleteDdMajorByName(String dname);
	
	//��
	boolean updateDdMajorStateByName(DdMajor ddMajor,String oldDname);	
	
	//��
	DdMajor getDdMajorStateByName(String dname);
	List getAllDdMajor();	
}
