package com.demo.oauth.dao.oauth;


import com.demo.oauth.dao.base.BaseDao;
import com.demo.oauth.model.oauth.OauthCode;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OauthCodeMapper extends BaseDao<OauthCode> {

}