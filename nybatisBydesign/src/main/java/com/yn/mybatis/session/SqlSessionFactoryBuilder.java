package com.yn.mybatis.session;

import com.yn.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @author yn
 * @class my-ssm-study
 * @describe
 * @date 2021/1/21-10:34
 */
public class SqlSessionFactoryBuilder {


    /**
     * 根据参数的字节输入流构建一个SqlSessionFactory工厂
     * @param in
     * @return
     */
    public SqlSessionFactory build(InputStream in){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(in);
        return new DefaultSqlSessionFactory(cfg);
    }
}
