package com.kang.audit.logger;

import com.kang.audit.bean.AuditFields;
import com.kang.audit.bean.FromType;

/**
 * Created by feshfans on 2016/10/29.
 */
public class ProductAuditLogger extends AuditLogger {

    /**
     *
     * @param fields
     * @param jsonData   规定格式的json数据，可多但不可少
     */
    public static void add(AuditFields fields,String jsonData){
        info(fields.toString()+jsonData);
    }

    public static void add(String ip, FromType fromType,String jsonData){
        AuditFields fields=new AuditFields();
        fields.setIp(ip);
        fields.setFromType(fromType);
        add(fields,jsonData);
    }

    public static void update(AuditFields fields,String data){
        info(fields.toString()+data);
    }
    public static void update(String ip, FromType fromType,String data){
        AuditFields fields=new AuditFields();
        fields.setIp(ip);
        fields.setFromType(fromType);
        update(fields,data);
    }
}
