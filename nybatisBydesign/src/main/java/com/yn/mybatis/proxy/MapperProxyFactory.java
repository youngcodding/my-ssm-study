package com.yn.mybatis.proxy;

import com.yn.mybatis.session.Mapper;
import com.yn.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * @author yn
 * @class my-ssm-study
 * @describe
 * @date 2021/1/21-10:57
 */
public class MapperProxyFactory implements InvocationHandler {

    //这是存放全限定类名方法 和 sql语句返回值类型
    private Map<String, Mapper> mappers;
    private Connection conn;

    public MapperProxyFactory(Map<String, Mapper> mappers, Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1.获取方法名
        String methodName = method.getName();
        //2、获取全限定类名
        String className = method.getDeclaringClass().getName();
        //3、组合key
        String key = className+"."+methodName;
        //4、获取mappers中的mapper对象
        Mapper mapper = mappers.get(key);
        //5、判断否有mapper
        if(mapper==null){
            throw  new IllegalArgumentException("传入的参数有误！");
        }
        //6、调用工具类来执行查询所有
        return new Executor().selectList(mapper,conn);
    }
}
