package com.fzu.shhtest.dao;

import com.fzu.shhtest.domain.SchoolInfo;
public interface SchoolInfoDao {
	//��
	int createSchoolInfo(SchoolInfo schoolInfo);
	
	//ɾ
	boolean deleteSchoolInfo();
	
	//��
	boolean updateSchoolInfo(SchoolInfo schoolInfo);
	
	//��
	SchoolInfo getSchoolInfo();
}
