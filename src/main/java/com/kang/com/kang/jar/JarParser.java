package com.kang.com.kang.jar;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

/**
 * Created by kang on 16-7-3.
 *
 * 解析Jar中的manifest文件,获取jar版本和厂商
 * 用于将ant转换为maven时寻找方便用maven打依赖
 */
public class JarParser {

    public static void main(String[] args) {

        try {
            JarFile file=new JarFile("/home/kang/repository/dom4j/dom4j/1.6.1/dom4j-1.6.1.jar");

            JarParser parser=new JarParser();
            JarEntity entity= parser.parseManifest(file);

            System.out.println(entity);

            List<JarEntity> list=parser.parseDir("/home/kang/Workspace/webmagic/lib");
            System.out.println(list);



        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private JarEntity parseManifest(JarFile jarFile) throws IOException {

        JarEntity jarEntity=new JarEntity();
        Manifest manifest=jarFile.getManifest();

        Attributes attributes= manifest.getMainAttributes();

        for(Map.Entry<Object,Object> entry: attributes.entrySet()){

            if(entry.getKey().toString().toLowerCase().equals(JarEntity.JarEntityType.Version.getType())){
                jarEntity.setVersion(entry.getValue().toString());
            }
            if(entry.getKey().toString().toLowerCase().equals(JarEntity.JarEntityType.ITitle.getType())){
                jarEntity.setiTitle(entry.getValue().toString());
            }
            if(entry.getKey().toString().toLowerCase().equals(JarEntity.JarEntityType.STitle.getType())){
                jarEntity.setsTitle(entry.getValue().toString());
            }
        }

        return jarEntity;

    }

    public List<JarEntity> parseDir(String jarDir) throws IOException {

        List<JarEntity> list=new ArrayList<JarEntity>();

        File file=new File(jarDir);

        FileFilter fileFilter=new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                System.out.println(pathname);
                if(pathname.getName().toLowerCase().endsWith(".jar")){
                    return true;
                }

                return false;
            }
        };
        File[] files= file.listFiles(fileFilter);

        System.out.println("size:"+files.length);
        for(File f : files){
            JarFile jarFile=new JarFile(f);

            JarEntity entity=this.parseManifest(jarFile);

            list.add(entity);
        }

        return list;
    }
}