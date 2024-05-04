package com.example.demo.student;

import java.time.LocalDate;

public class Student {
    private long id;
    private String name;
    private int age;
    private String email;
    private LocalDate dob;

    public Student() {

    }

    public Student(long id, String name, int age, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name, int age, String email, LocalDate dob) {

        this.name = name;
        this.age = age;
        this.email = email;
        this.dob = dob;
    }


    public void setId(Long id){
this.id=id;
    }
    public Long getId(){return id;}
    public void setName(String name){this.name=name;}
    public String getName(){ return name ;}
    public void setAge(int age){this.age=age;}
    public int getAge(){return age;}
    public void setEmail(String email){this.email=email;}
    public String getEmail(){return email;}
    public void setDob(LocalDate dob){this.dob=dob;}
    public LocalDate getDob(){return dob;}
    @Override
    public String toString() {
return "Student{"+"id="+id+",name="+name+"\n"+",email="+email+"\n"+",age="+age+"\n"+",dob="+dob+"}";
    
}

}
