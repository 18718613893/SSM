package com.xxx.domain;

import org.springframework.stereotype.Component;

@Component
public class Student {
    private Integer id;
    private String username;
    private String sex;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Student() {
    }

    public Student(Integer id, String username, String sex, String password) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.password = password;
    }
}
