package com.example.day03_exam;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Student  {
    @Id(autoincrement = true)
    private Long id;
    private String pic;
    private String String;
    @Generated(hash = 1653095854)
    public Student(Long id, String pic, String String) {
        this.id = id;
        this.pic = pic;
        this.String = String;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPic() {
        return this.pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }
    public String getString() {
        return this.String;
    }
    public void setString(String String) {
        this.String = String;
    }
    
}
