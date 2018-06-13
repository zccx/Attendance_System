package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

public class Calltheroll {
    @Id
    private Integer autoid;

    @Column(name = "courseName")
    private String coursename;

    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private Integer callstate;

    private Date calldate;

    private String callposition;

    /**
     * @return autoid
     */
    public Integer getAutoid() {
        return autoid;
    }

    /**
     * @param autoid
     */
    public void setAutoid(Integer autoid) {
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
     * @return callstate
     */
    public Integer getCallstate() {
        return callstate;
    }

    /**
     * @param callstate
     */
    public void setCallstate(Integer callstate) {
        this.callstate = callstate;
    }

    /**
     * @return calldate
     */
    public Date getCalldate() {
        return calldate;
    }

    /**
     * @param calldate
     */
    public void setCalldate(Date calldate) {
        this.calldate = calldate;
    }

    /**
     * @return callposition
     */
    public String getCallposition() {
        return callposition;
    }

    /**
     * @param callposition
     */
    public void setCallposition(String callposition) {
        this.callposition = callposition;
    }
}