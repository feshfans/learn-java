package com.kang.audit.bean;

/**
 * Created by feshfans on 2016/10/29.
 */
public class AuditFields {
    private String ip;
    private FromType fromType;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public FromType getFromType() {
        return fromType;
    }

    public void setFromType(FromType fromType) {
        this.fromType = fromType;
    }

    @Override
    public String toString() {
        return "AuditFields{" +
                "ip='" + ip + '\'' +
                ", fromType=" + fromType +
                '}';
    }
}
