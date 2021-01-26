package com.yn.mybatis.session;

/**
 * @author yn
 * @class my-ssm-study
 * @describe
 * @date 2021/1/21-10:45
 */
public interface SqlSession {

    /**
     * 创建dao接口的代理类
     * @param daoClass
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoClass);

    /**
     * 关闭资源
     */
    public void close();
}
