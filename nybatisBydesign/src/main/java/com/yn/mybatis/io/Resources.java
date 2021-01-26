package com.yn.mybatis.io;

import java.io.InputStream;

/**
 * @author yn
 * @class my-ssm-study
 * @describe 用于读取配置文件的类
 * @date 2021/1/21-10:23
 */
public class Resources {

    /**
     * 用于加载xml文件，并且得到一个流对象
     * @param pathInfo
     * @return
     */
    public static InputStream getResourceAsStream(String pathInfo){
        /*
        * 在开发中读取配置文件的方式
        * 第一是使用类加载器，但是有要求：1.文件不能过大；2.文件必须在类路径下
        * 第二是使用SevletContext的getRealPath()*/

       return Resources.class.getClassLoader().getResourceAsStream(pathInfo);
    }
}
