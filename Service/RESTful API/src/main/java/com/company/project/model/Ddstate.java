package com.company.project.model;

import javax.persistence.*;

public class Ddstate {
    @Id
    private Integer callstate;

    private String dname;

    private String state;

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