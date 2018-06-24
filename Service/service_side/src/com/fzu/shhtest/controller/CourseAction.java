package com.fzu.shhtest.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.fzu.shhtest.domain.Course;
import com.fzu.shhtest.service.CourseService;
import com.fzu.shhtest.service.DdClassDateService;
import com.fzu.shhtest.utils.ResultUtils;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class CourseAction extends ActionSupport {
	private CourseService courseService;
	private DdClassDateService ddClassDateService;
	
	public void setDdClassDateService(DdClassDateService ddClassDateService) {
		this.ddClassDateService = ddClassDateService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	public String execute() {
		return SUCCESS;
	}

	public String createCourse() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		String contentType = request.getHeader("Content-Type");
		String courseName = ResultUtils.getPostParameter(param, "coursename",contentType);
		String dailyWeight = ResultUtils.getPostParameter(param, "dailyweight",contentType);
		String finalWeight = ResultUtils.getPostParameter(param, "finalweight",contentType);
		String picketLine = ResultUtils.getPostParameter(param, "picketline",contentType);
		String classSession = ResultUtils.getPostParameter(param, "classsession",contentType);
		String classLocation = ResultUtils.getPostParameter(param, "classlocation",contentType);
		String classDate = ResultUtils.getPostParameter(param, "classdate",contentType);
		String classOrder = ResultUtils.getPostParameter(param, "classorder",contentType);
		String ID = ResultUtils.getPostParameter(param, "id",contentType);
		String shape = ResultUtils.getPostParameter(param, "shape",contentType);
		
		Course course = new Course();
		course.setCourseName(courseName);
		course.setDailyWeight(Double.parseDouble(dailyWeight));
		course.setFinalWeight(Double.parseDouble(finalWeight));
		course.setPicketLine(Integer.parseInt(picketLine));
		course.setClassSession(classSession);
		course.setClassLocation(classLocation);
		course.setClassDate(Integer.parseInt(classDate));
		course.setClassOrder(classOrder);
		course.setID(ID);
		course.setShape(shape);
		System.out.println(course.toString());
		courseService.createCourse(course);
		
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String deleteCourseByName() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String cname = ResultUtils.getRequestParameter(request, "coursename");
		Map<String, Object> map = new HashMap<String, Object>();
		courseService.deleteCourseByName(cname);
		map.put("state", 1);
		HttpServletResponse response = ResultUtils.setResponse(ServletActionContext.getResponse());
		ResultUtils.toJson(response, map);
		return null;
	}

	public String updateCourse() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		String contentType = request.getHeader("Content-Type");
		String oldcourseName = ResultUtils.getPostParameter(param, "oldcoursename",contentType);
		System.out.println("oldcourseName is : "+oldcourseName);
		String courseName = ResultUtils.getPostParameter(param, "coursename",contentType);
		String dailyWeight = ResultUtils.getPostParameter(param, "dailyweight",contentType);
		String finalWeight = ResultUtils.getPostParameter(param, "finalweight",contentType);
		String picketLine = ResultUtils.getPostParameter(param, "picketline",contentType);
		String classSession = ResultUtils.getPostParameter(param, "classsession",contentType);
		String classLocation = ResultUtils.getPostParameter(param, "classlocation",contentType);
		String classDate = ResultUtils.getPostParameter(param, "classdate",contentType);
		String classOrder = ResultUtils.getPostParameter(param, "classorder",contentType);
		String ID = ResultUtils.getPostParameter(param, "id",contentType);
		String shape = ResultUtils.getPostParameter(param, "shape",contentType);
		System.out.println("courseName is : "+courseName);
		
		Course course = new Course();
		course.setCourseName(courseName);
		course.setDailyWeight(Double.parseDouble(dailyWeight));
		course.setFinalWeight(Double.parseDouble(finalWeight));
		course.setPicketLine(Integer.parseInt(picketLine));
		course.setClassSession(classSession);
		course.setClassLocation(classLocation);
		course.setClassDate(Integer.parseInt(classDate));
		course.setClassOrder(classOrder);
		course.setID(ID);
		course.setShape(shape);
		System.out.println(course);
		courseService.updateCourse(course,oldcourseName);
		
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getAllCourse() throws IOException {
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		List<Course> list = (List<Course>) courseService.getAllCourse();
		map.put("courses", list);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getCourseByName() throws IOException {
		//http://localhost:8080/shhTest/courseaction/getCourseByNameHql
		//id=160327000&coursename=���繤��&bcalldate=2017-06-14&acalldate=2017-06-14&calldate=2017-06-14
		HttpServletRequest request = ServletActionContext.getRequest();
		String cname = ResultUtils.getRequestParameter(request, "coursename");
		Map<String, Object> map = new HashMap<String, Object>();
		Course course = courseService
				.getCourseByName(cname);
		map.put("course", course);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		ResultUtils.toJson(response, map);
		return null;
	}
	
	

	public String getAllCourseHql() throws IOException {
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		List<Course> list = (List<Course>) courseService.getAllCourseHql();
		String[] parameters= {"courseName","ID","dailyWeight","finalWeight","picketLine","classSession","classLocation","classDate","classOrder","shape"};
		List<Map<String, Object>> maplist = ResultUtils.setResults(list, parameters);//new ArrayList<Map<String, Object>>();
		
		
		map.put("courses", maplist);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getCourseByNameHql() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();
		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		String contentType = request.getHeader("Content-Type");
		String cname = ResultUtils.getPostParameter(param, "coursename",contentType);
		Map<String, Object> map = new HashMap<String, Object>();
		List course = courseService
				.getCourseByNameHql(cname);
		String[] parameters= {"courseName","ID","dailyWeight","finalWeight","picketLine","classSession","classLocation","classDate","classOrder","shape"};
		List<Map<String, Object>> maplist = ResultUtils.setResults(course, parameters);//new ArrayList<Map<String, Object>>();
		
		map.put("course", maplist);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		ResultUtils.toJson(response, map);
		return null;
	}
	
	public String getCourseByIDHql() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();
		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		String contentType = request.getHeader("Content-Type");
		String id = ResultUtils.getPostParameter(param, "id",contentType);
		Map<String, Object> map = new HashMap<String, Object>();
		List course = (ArrayList<Course>)courseService
				.getCourseByIDHql(id);
		String[] parameters= {"courseName","ID","dailyWeight","finalWeight","picketLine","classSession","classLocation","classDate","classOrder","shape"};
		List<Map<String, Object>> maplist = ResultUtils.setResults(course, parameters);//new ArrayList<Map<String, Object>>();
		
		map.put("courses", maplist);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		ResultUtils.toJson(response, map);
		return null;
	}
}
