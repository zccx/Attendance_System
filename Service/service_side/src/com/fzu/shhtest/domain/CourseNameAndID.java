package com.fzu.shhtest.domain;

import java.io.Serializable;

public class CourseNameAndID implements Serializable {
	private String courseName;
	private String ID;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	// ����Ҫ��д����������
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CourseNameAndID)// �����ж��Ƿ���TeacherPK���͵�
		{
			CourseNameAndID pk = (CourseNameAndID) obj;
			if (this.ID.equals(pk.getID())
					&& this.courseName.equals(pk.getCourseName())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
