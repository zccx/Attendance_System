package com.fzu.shhtest.dao;

import java.util.List;

import com.fzu.shhtest.domain.Personnel;

public interface PersonnelDao {
	//��
	int createPersonnel(Personnel personnel);
	
	//ɾ
	boolean deletePersonnelByName(String sname);
	boolean deletePersonnelByID(String id);

	//��
	boolean updatePersonnel(Personnel personnel);

	//��
	List getAllPersonnel();
	List getAllPersonnelHql();
	Personnel getPersonnelByName(String pname);
	List getPersonnelByNameHql(String pname);
	Personnel getPersonnelByID(String ID);
	List getPersonnelByIDHql(String ID);
	
}
