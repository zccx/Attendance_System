package com.company.project.model;

import javax.persistence.*;

public class Ddclassdate {
    @Id
    @Column(name = "classDate")
    private Integer classdate;

    private String dname;

    private String state;

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
     * @return dname
     */
    public String getDname() {
        return dname;
    }

    /**
     * @param dname
     */
    public void setDname(String dname) {
        this.dname = dname;
    }

    /**
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }
}