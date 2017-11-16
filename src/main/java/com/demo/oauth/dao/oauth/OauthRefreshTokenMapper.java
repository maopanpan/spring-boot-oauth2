package com.demo.oauth.dao.oauth;

import com.demo.oauth.dao.base.BaseDao;
import com.demo.oauth.model.oauth.OauthRefreshToken;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OauthRefreshTokenMapper extends BaseDao<OauthRefreshToken> {

}