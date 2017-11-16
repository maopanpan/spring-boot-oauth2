package com.demo.oauth.service.base;

import com.demo.oauth.dao.base.BaseDao;
import com.demo.oauth.model.base.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: maopanpan
 * @Description:
 * @Date: 2017/10/16.
 **/
@Transactional(readOnly = true)
public abstract class BaseService<B extends BaseDao<T>, T extends BaseEntity<T>> {

    @Autowired
    private B dao;

    /**
     * 查询列表数据
     * @param entity
     * @return
     */
    public List<T> findList(T entity) {
        return dao.findList(entity);
    }

}
