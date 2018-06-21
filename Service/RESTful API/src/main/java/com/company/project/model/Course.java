package com.company.project.model;

import javax.persistence.*;

public class Course {
    @Id
    @Column(name = "courseName")
    private String coursename;

    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "dailyWeight")
    private Double dailyweight;

    @Column(name = "finalWeight")
    private Double finalweight;

    @Column(name = "picketLine")
    private Integer picketline;

    @Column(name = "classSession")
    private String classsession;

    @Column(name = "classLocation")
    private String classlocation;

    @Column(name = "classDate")
    private Integer classdate;

    @Column(name = "classOrder")
    private String classorder;

    private String shape;

    /**
     * @return courseName
     */
    public String getCoursename() {
        return coursename;
    }

    /**
     * @param coursename
     */
    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    /**
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return dailyWeight
     */
    public Double getDailyweight() {
        return dailyweight;
    }

    /**
     * @param dailyweight
     */
    public void setDailyweight(Double dailyweight) {
        this.dailyweight = dailyweight;
    }

    /**
     * @return finalWeight
     */
    public Double getFinalweight() {
        return finalweight;
    }

    /**
     * @param finalweight
     */
    public void setFinalweight(Double finalweight) {
        this.finalweight = finalweight;
    }

    /**
     * @return picketLine
     */
    public Integer getPicketline() {
        return picketline;
    }

    /**
     * @param picketline
     */
    public void setPicketline(Integer picketline) {
        this.picketline = picketline;
    }

    /**
     * @return classSession
     */
    public String getClasssession() {
        return classsession;
    }

    /**
     * @param classsession
     */
    public void setClasssession(String classsession) {
        this.classsession = classsession;
    }

    /**
     * @return classLocation
     */
    public String getClasslocation() {
        return classlocation;
    }

    /**
     * @param classlocation
     */
    public void setClasslocation(String classlocation) {
        this.classlocation = classlocation;
    }

    /**
     * @return classDate
     */
    public Integer getClassdate() {
        return classdate;
    }

    /**
     * @param classdate
     */
    public void setClassdate(Integer classdate) {
        this.classdate = classdate;
    }

    /**
     * @return classOrder
     */
    public String getClassorder() {
        return classorder;
    }

    /**
     * @param classorder
     */
    public void setClassorder(String classorder) {
        this.classorder = classorder;
    }

    /**
     * @return shape
     */
    public String getShape() {
        return shape;
    }

    /**
     * @param shape
     */
    public void setShape(String shape) {
        this.shape = shape;
    }
}