package com.company.project.model;

import javax.persistence.*;

public class Personnel {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "Ppassword")
    private String ppassword;

    @Column(name = "Pname")
    private String pname;

    private Integer major;

    private Integer role;

    private Integer pclass;

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
     * @return Ppassword
     */
    public String getPpassword() {
        return ppassword;
    }

    /**
     * @param ppassword
     */
    public void setPpassword(String ppassword) {
        this.ppassword = ppassword;
    }

    /**
     * @return Pname
     */
    public String getPname() {
        return pname;
    }

    /**
     * @param pname
     */
    public void setPname(String pname) {
        this.pname = pname;
    }

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
     * @return role
     */
    public Integer getRole() {
        return role;
    }

    /**
     * @param role
     */
    public void setRole(Integer role) {
        this.role = role;
    }

    /**
     * @return pclass
     */
    public Integer getPclass() {
        return pclass;
    }

    /**
     * @param pclass
     */
    public void setPclass(Integer pclass) {
        this.pclass = pclass;
    }
}