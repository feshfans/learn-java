package com.kang.bean;

import com.kang.annotation.JsonFilter;
import com.kang.annotation.JsonFilters;

/**
 * Created by feshfans on 2016/8/29.
 *
 * @email feshfans@163.com
 */
public class User {
    @JsonFilters({@JsonFilter(isIgnore = true),@JsonFilter(isIgnore = false)})
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
