package com.ins.common.entity;

import java.io.Serializable;

/**
 * Created by liaoinstan on 15/9/2.
 * BannerView需要的一个实体类，可以考虑放在BannerView作为一个内部类，不要让它参与网络数据的转换，否则你的混淆配置又要加入这些实体类了
 */
public class Image implements Serializable {

    private int id;
    private String title;
    private String img;
    private String url;

    public Image() {
    }

    public Image(int id, String img) {
        this.id = id;
        this.img = img;
    }
    public Image(String img) {
        this.img = img;
    }
    public Image(int id, String title, String img) {
        this.id = id;
        this.title = title;
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", img='" + img + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
