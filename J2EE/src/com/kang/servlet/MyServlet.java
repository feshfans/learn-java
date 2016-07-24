package com.kang.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kang on 16-6-9.
 */

/**
 * 用来验证Servlet是单例的,不是每次请求都构建一个新的线程.(在此不考虑并发时的安全性,只是为了测试)
 * 1. count的数会随着增加,注意,count是对象属性不是类属性
 * 2. 输出的线程id和名称不同
 * 3. 从输出结果来看,像线程池
 * 输出结果如下：
 * 41
 * http-bio-8080-exec-9
 * count:4
 * =========================
 * 42
 * http-bio-8080-exec-10
 * count:5
 * =========================
 * 42
 * http-bio-8080-exec-10
 * count:6
 * =========================
 */
public class MyServlet extends HttpServlet{

    private int count=0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        count++;
        System.out.println(Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getName());
        System.out.println(this.getClass().getClassLoader());
        System.out.println("count:"+count);
        System.out.println("=========================");
    }
}
