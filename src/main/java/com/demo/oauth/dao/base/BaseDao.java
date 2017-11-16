package com.demo.oauth.dao.base;

import java.util.List;

/**
 * @Author: maopanpan
 * @Description:
 * @Date: 2017/10/16.
 **/
public interface BaseDao<T> {

    public List<T> findList(T entity);
}
