package com.demo.oauth.dao.sys;

import com.demo.oauth.dao.base.BaseDao;
import com.demo.oauth.model.sys.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserMapper extends BaseDao<SysUser> {

    public SysUser querySysUserByID(Integer id);

    public List<SysUser> querySysUser();

    public SysUser querySysUserByUsername(String username);

}