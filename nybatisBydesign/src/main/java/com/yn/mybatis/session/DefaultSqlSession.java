package com.yn.mybatis.session;

import com.yn.mybatis.proxy.MapperProxyFactory;
import com.yn.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author yn
 * @class my-ssm-study
 * @describe
 * @date 2021/1/21-10:51
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection connection;

    public DefaultSqlSession(Configuration cfg) {
        this.cfg = cfg;
        this.connection = DataSourceUtil.getConnection(cfg);
    }

    /**
     * 创建dao接口的代理类
     * @param daoClass
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> daoClass) {
        /*使用动态代理进行方法的代理执行
        *
        * */
        T daoProxy = (T)Proxy.newProxyInstance(daoClass.getClassLoader(), new Class[]{daoClass}, new MapperProxyFactory(cfg.getMappers(),connection));
        return daoProxy;
    }

    /**
     * 关闭数据库连接
     */
    @Override
    public void close() {
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
