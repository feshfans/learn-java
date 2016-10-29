package com.kang.annotation;

import com.kang.bean.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by feshfans on 2016/8/29.
 *
 * @email feshfans@163.com
 */
public class Demo {
    public static void main(String[] args) {
        Field[] fields= User.class.getDeclaredFields();
        for(Field field:fields){
            System.out.println(field.getName());
            /*Annotation[] annotations= field.getDeclaredAnnotations();
            System.out.println(annotations.length);
            for(Annotation annotation:annotations){
                System.out.println(annotation.annotationType());
            }*/
            JsonFilters jsonFilters= field.getAnnotation(JsonFilters.class);
            //System.out.println(jsonFilters);
            if(jsonFilters!=null){
                /*System.out.println("isIgnore:"+jsonFilter.isIgnore());
                System.out.println("name:"+jsonFilter.name());*/

                for(JsonFilter jsonFilter:jsonFilters.value()){
                    System.out.println("name:"+jsonFilter.name());
                    System.out.println("isIgnore:"+jsonFilter.isIgnore());
                }
                //System.out.println("=="+jsonFilters.value());
            }

            System.out.println("=========================");
        }



    }
}
