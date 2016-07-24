package com.kang;

import redis.clients.jedis.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );

        Jedis jedis=new Jedis("127.0.0.1",6379);

      /*  JedisPool jedisPool=new JedisPool();
        jedisPool.

        JedisPoolConfig poolConfig=new JedisPoolConfig();
        poolConfig.*/

        /*System.out.println(jedis.get("key"));

        List<String> values= jedis.mget("key","key1");
        for(String value:values){
            System.out.println(value);
        }

        *//*jedis.incr("key");
        jedis.incrBy("key",3);

        System.out.println(jedis.get("key"));

        jedis.decrBy("key",100);
        System.out.println(jedis.get("key"));

        jedis.append("key","kang");
        getKey(jedis);*//*

        Set<String> keys= jedis.hkeys("hset");

        System.out.println("size:"+keys.size());
        for(String key:keys){
            System.out.println(key);
        }


        jedis.hsetnx("hset","name","kang");

        System.out.println(jedis.hget("hset","name"));

        System.out.println(jedis.hexists("hset","name"));

        System.out.println(jedis.hlen("hset"));

        Map<String,String> map= jedis.hgetAll("hset");

        for(Map.Entry<String ,String> entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        jedis.lpush("list","kang","hui","26");

        System.out.println(jedis.llen("list"));

        jedis.rpush("list","lai");

        System.out.println(jedis.rpop("list"));

        jedis.linsert("list", BinaryClient.LIST_POSITION.BEFORE,"kang","kanghuilai");

        jedis.lrem("list",2,"hui");
        System.out.println(jedis.lrange("list",0,-1));*/



        jedis.sadd("set","kang","hui","lai");

        System.out.println(jedis.sadd("set","kang"));
        System.out.println(jedis.smembers("set"));


        Transaction transaction= jedis.multi();

        transaction.discard();

        jedis.watch("*");

        jedis.bgsave();


        //JedisPubSub
    }

    private static void getKey(Jedis jedis){
        System.out.println(jedis.get("key"));
    }
}
