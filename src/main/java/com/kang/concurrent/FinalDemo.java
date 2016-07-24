package com.kang.concurrent;

/**
 * Created by kang on 16-6-10.
 */
public class FinalDemo {

    public static void main(String[] args) {
        final User user=new User();
        user.setId("1");;
        user.setName("kang");
        new Thread(new Runnable() {
            @Override
            public void run() {
                user.setName("hui");
            }
        }).start();

        //user=new User();
        System.out.println(user);
    }


}

final class User{

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
