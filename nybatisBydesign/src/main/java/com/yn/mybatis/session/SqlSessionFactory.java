package com.yn.mybatis.session;

/**
 * @author yn
 * @class my-ssm-study
 * @describe
 * @date 2021/1/21-10:36
 */
public interface SqlSessionFactory {

    /**
     * 创建一个新的SqlSession对象
     * @return
     */
    public SqlSession openSession();
}
