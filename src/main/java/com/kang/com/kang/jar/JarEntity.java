package com.kang.com.kang.jar;

/**
 * Created by kang on 16-7-3.
 */
public class JarEntity {

    /** Implementation-Version **/
    private String version;

    /** Implementation-Title **/
    private String iTitle;

    /** Specification-Title **/
    private String sTitle;


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getiTitle() {
        return iTitle;
    }

    public void setiTitle(String iTitle) {
        this.iTitle = iTitle;
    }

    public String getsTitle() {
        return sTitle;
    }

    public void setsTitle(String sTitle) {
        this.sTitle = sTitle;
    }

    @Override
    public String toString() {
        return "JarEntity{" +
                "version='" + version + '\'' +
                ", iTitle='" + iTitle + '\'' +
                ", sTitle='" + sTitle + '\'' +
                '}';
    }

    static enum  JarEntityType{

        Version("Implementation-Version"),
        ITitle("Implementation-Title"),
        STitle("Specification-Title");

        private String type;
        public String getType(){
            return this.type;
        }
        private JarEntityType(String type){
            this.type=type;
        }


    }

}

