package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

public class Question {
    @Id
    private Long autoid;

    @Column(name = "courseName")
    private String coursename;

    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "attendanceDate")
    private Date attendancedate;

    private Double score;

    /**
     * @return autoid
     */
    public Long getAutoid() {
        return autoid;
    }

    /**
     * @param autoid
     */
    public void setAutoid(Long autoid) {
        this.autoid = autoid;
    }

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
     * @return attendanceDate
     */
    public Date getAttendancedate() {
        return attendancedate;
    }

    /**
     * @param attendancedate
     */
    public void setAttendancedate(Date attendancedate) {
        this.attendancedate = attendancedate;
    }

    /**
     * @return score
     */
    public Double getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(Double score) {
        this.score = score;
    }
}