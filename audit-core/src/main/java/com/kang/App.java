package com.kang;

import com.kang.audit.bean.AuditFields;
import com.kang.audit.logger.ProductAuditLogger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        ProductAuditLogger.add(new AuditFields(),"");
    }
}
