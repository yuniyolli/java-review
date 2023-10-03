package com.review.thymeleaf.practice;

public class StudentEntity {
    // ${} 사용 시, public 선언 또는 getter.
    public String name;
    public String email;


    public StudentEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public StudentEntity() {};


    // --------------------------
    // private선언 후 getter 포함하여 생성자 만들기


    /*
    private String email;
    private String name;




    public StudentEntity() {};


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


    @Override
    public String toString() {
        return "StudentEntity{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


    public StudentEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }


     */

}
