package com.company.project.model;

import javax.persistence.*;

public class Ddmajor {
    @Id
    private Integer major;

    private String dname;

    private String state;

    /**
     * @return major
     */
    public Integer getMajor() {
        return major;
    }

    /**
     * @param major
     */
    public void setMajor(Integer major) {
        this.major = major;
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