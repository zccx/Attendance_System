package com.company.project.model;

import javax.persistence.*;

public class Mark {
    @Id
    @Column(name = "MarkID")
    private Integer markid;

    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "courseName")
    private String coursename;

    @Column(name = "dailyScore")
    private Double dailyscore;

    @Column(name = "finalScore")
    private Double finalscore;

    private String markreserve;

    /**
     * @return MarkID
     */
    public Integer getMarkid() {
        return markid;
    }

    /**
     * @param markid
     */
    public void setMarkid(Integer markid) {
        this.markid = markid;
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
     * @return dailyScore
     */
    public Double getDailyscore() {
        return dailyscore;
    }

    /**
     * @param dailyscore
     */
    public void setDailyscore(Double dailyscore) {
        this.dailyscore = dailyscore;
    }

    /**
     * @return finalScore
     */
    public Double getFinalscore() {
        return finalscore;
    }

    /**
     * @param finalscore
     */
    public void setFinalscore(Double finalscore) {
        this.finalscore = finalscore;
    }

    /**
     * @return markreserve
     */
    public String getMarkreserve() {
        return markreserve;
    }

    /**
     * @param markreserve
     */
    public void setMarkreserve(String markreserve) {
        this.markreserve = markreserve;
    }
}