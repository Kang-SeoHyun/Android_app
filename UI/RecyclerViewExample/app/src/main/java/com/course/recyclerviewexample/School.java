package com.course.recyclerviewexample;

public class School {

    String school_name;
    int image_id;
    String school_url;

    public School (int id, String name, String url) {
            this.image_id = id;
            this.school_name = name;
            this.school_url = url;
    }

    public String getSchoolName() {
            return school_name;
    }

    public int getImageID() {
            return image_id;
    }

    public String getURL() {
            return school_url;
    }
}

