package com.example.myapplication;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class MyDbBean {
    @Id(autoincrement = true)
   private Long id;
    private String url;
    private String title;
    private String title1;
    @Generated(hash = 775734601)
    public MyDbBean(Long id, String url, String title, String title1) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.title1 = title1;
    }
    @Generated(hash = 720896287)
    public MyDbBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle1() {
        return this.title1;
    }
    public void setTitle1(String title1) {
        this.title1 = title1;
    }

  




}
