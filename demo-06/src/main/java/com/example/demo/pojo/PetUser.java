package com.example.demo.pojo;

public class PetUser {
    private Integer id;

    private String userName;

    private String userPass;

    private Integer userRoleType;

    private Integer userIsDisable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass == null ? null : userPass.trim();
    }

    public Integer getUserRoleType() {
        return userRoleType;
    }

    public void setUserRoleType(Integer userRoleType) {
        this.userRoleType = userRoleType;
    }

    public Integer getUserIsDisable() {
        return userIsDisable;
    }

    public void setUserIsDisable(Integer userIsDisable) {
        this.userIsDisable = userIsDisable;
    }
}