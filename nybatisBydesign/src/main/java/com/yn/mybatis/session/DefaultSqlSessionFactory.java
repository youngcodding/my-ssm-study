package com.yn.mybatis.session;

import com.yn.mybatis.utils.XMLConfigBuilder;
import jdk.internal.util.xml.impl.Input;

import java.io.InputStream;

/**
 * @author yn
 * @class my-ssm-study
 * @describe
 * @date 2021/1/21-10:46
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg=cfg;
    }

    /**
     * 用于创建一个新的操作数据库对象
     * @return
     */
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
