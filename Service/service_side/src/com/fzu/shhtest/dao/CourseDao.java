package com.fzu.shhtest.dao;

import java.util.List;

import com.fzu.shhtest.domain.Course;
import com.fzu.shhtest.domain.Personnel;

public interface CourseDao {
	//��
	int createCourse(Course course);

	//ɾ
	boolean deleteCourseByName(String cname);

	//��
	boolean updateCourse(Course course,String oldcourseName);

	//��
	List getAllCourse();
	Course getCourseByName(String cname);
	List getCourseByIDHql(String id);
	
	List getAllCourseHql();
	List getCourseByNameHql(String cname);
}
