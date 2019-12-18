package com.example.xiaoshixunlianxi;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Bean {
    @Id(autoincrement = true)
    private Long id;
    private String imagePath;
    private String title;
    @Generated(hash = 331422062)
    public Bean(Long id, String imagePath, String title) {
        this.id = id;
        this.imagePath = imagePath;
        this.title = title;
    }
    @Generated(hash = 80546095)
    public Bean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImagePath() {
        return this.imagePath;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
