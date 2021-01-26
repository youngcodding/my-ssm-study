package com.yn.mybatis.session;

/**
 * @author yn
 * @class my-ssm-study
 * @describe
 * @date 2021/1/21-11:05
 */
public class Mapper {

    private String queryString;
    private String resultType;

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
