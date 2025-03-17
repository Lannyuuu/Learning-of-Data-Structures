package LessonTest;
import java.util.*;

public class Students {
    private int Id;
    private String name;
    private String gender;
    private int age;

    public Students(int id, String name, String gender, int age) {
        Id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    public void display(){
        System.out.println("姓名："+ this.name + "\n年龄："+this.age+"\n性别："+this.gender+"\n学生Id："+Id);
    }
}
