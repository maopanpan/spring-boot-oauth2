package com.demo.oauth.service.sys;

import com.demo.oauth.model.sys.SysUser;

import java.util.List;

/**
 * @Author: maopanpan
 * @Description:
 * @Date: 2017/11/14.
 **/
public interface SysUserService {

    public SysUser querySysUserById(int id);

    public List<SysUser> querySysUser();
}
