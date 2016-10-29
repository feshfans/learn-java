package com.feshfans.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by feshfans on 2016/9/3.
 *
 * @email feshfans@163.com
 */
@Path("/")
public class Demo {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test(){

        return "Hello World";
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test2(){

        return "Hello test";
    }
}
