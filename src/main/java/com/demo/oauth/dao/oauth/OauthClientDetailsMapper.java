package com.demo.oauth.dao.oauth;


import com.demo.oauth.dao.base.BaseDao;
import com.demo.oauth.model.oauth.OauthClientDetails;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OauthClientDetailsMapper extends BaseDao<OauthClientDetails>{

}