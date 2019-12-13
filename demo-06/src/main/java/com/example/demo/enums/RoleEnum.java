package com.example.demo.enums;

/**
 * Created by zhanghongwei on 2019/11/8.
 */
public enum RoleEnum {
    A(1,"普通员工"),
    B(2,"经理");


    private int id;
    private String roleName;
    RoleEnum(int id,String name) {
        this.id = id;
        this.roleName = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public static String getRoleNameById(int id){
        for(RoleEnum roleEnum : RoleEnum.values()){
            if(roleEnum.getId() == id){
                return roleEnum.getRoleName();
            }
        }
        return "";
    }
}
