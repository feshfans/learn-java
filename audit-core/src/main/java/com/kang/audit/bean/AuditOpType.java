package com.kang.audit.bean;

import com.kang.audit.exception.NotSupportEnumException;

/**
 * Created by feshfans on 2016/10/29.
 */
public enum  AuditOpType {

    LoginIn(1,"登录"),
    LoginOut(2,"登出"),
    Add(3,"添加"),
    Update(4,"修改"),
    Delete(5,"删除");

    private int opCode;
    private String opName;
    AuditOpType(int code,String name){
        this.opCode=code;
        this.opName=name;
    }

    public int getOpCode() {
        return opCode;
    }

    public void setOpCode(int opCode) {
        this.opCode = opCode;
    }

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    /**
     * 根据枚举的code获取枚举对象
     * @param opCode     操作类型code
     * @return
     */
    public AuditOpType valueOf(int opCode){

        switch (opCode){
            case 1:{
                return LoginIn;
            }
            case 2:{
                return LoginOut;
            }
            case 3:{
                return Add;
            }
            case 4:{
                return Update;
            }
            case 5:{
                return Delete;
            }
            default:{
                throw new NotSupportEnumException("枚举类型不支持");
            }
        }
    }
}
