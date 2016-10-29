package com.kang.audit.bean;

import com.kang.audit.exception.NotSupportEnumException;

/**
 * 数据来源枚举类
 *
 * Created by feshfans on 2016/10/29.
 */
public enum  FromType {

    Web(1,"网站"),
    Api(2,"公开接口");
    private int fromCode;
    private String fromDesc;
    FromType(int fromCode,String fromDesc){
        this.fromCode=fromCode;
        this.fromDesc=fromDesc;
    }

    public int getFromCode() {
        return fromCode;
    }

    public void setFromCode(int fromCode) {
        this.fromCode = fromCode;
    }

    public String getFromDesc() {
        return fromDesc;
    }

    public void setFromDesc(String fromDesc) {
        this.fromDesc = fromDesc;
    }

    /**
     * 根据枚举的code获取枚举对象
     * @param fromCode     来源code
     * @return
     */
    public FromType valueOf(int fromCode){

        switch (fromCode){
            case 1:{
                return Web;
            }
            case 2:{
                return Api;
            }
            default:{
                throw new NotSupportEnumException("枚举类型不支持");
            }
        }
    }

}
