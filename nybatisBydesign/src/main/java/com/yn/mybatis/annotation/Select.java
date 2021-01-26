package com.yn.mybatis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yn
 * @class my-ssm-study
 * @describe
 * @date 2021/1/21-11:51
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Select {
    /**
     * 保存配置的sql语句
     * @return
     */
    String value();
}
