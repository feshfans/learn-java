package com.kang;

import javax.crypto.SecretKey;
import java.security.Key;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Provider[] providers= Security.getProviders();
        for(Provider provider:providers){
            System.out.println(provider.getName());

            for(Map.Entry<Object,Object> entry:provider.entrySet()){
                System.out.println("\t"+entry.getKey());
            }
        }

        System.out.println( "Hello World!" );
    }


}
