package com.harsh.jobsearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "JobPosts")
public class Post {
    private String desc;
    private int exp;
    private String profile;
    private String[] tech;

    public Post() {
    }

    public Post(String desc, int exp, String profile, String[] tech) {
        this.desc = desc;
        this.exp = exp;
        this.profile = profile;
        this.tech = tech;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String[] getTech() {
        return tech;
    }

    public void setTech(String[] tech) {
        this.tech = tech;
    }

    @Override
    public String toString() {
        return "Post{" +
                "desc='" + desc + '\'' +
                ", exp=" + exp +
                ", profile='" + profile + '\'' +
                ", tech=" + Arrays.toString(tech) +
                '}';
    }
}
