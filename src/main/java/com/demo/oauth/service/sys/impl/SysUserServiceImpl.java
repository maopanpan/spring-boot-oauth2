package com.demo.oauth.service.sys.impl;

import com.demo.oauth.dao.sys.SysUserMapper;
import com.demo.oauth.model.sys.SysUser;
import com.demo.oauth.service.base.BaseService;
import com.demo.oauth.service.sys.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: maopanpan
 * @Description:
 * @Date: 2017/11/14.
 **/
@Service
public class SysUserServiceImpl extends BaseService<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;


    @Override
    public SysUser querySysUserById(int id) {
        return sysUserMapper.querySysUserByID(id);
    }

    @Override
    public List<SysUser> querySysUser() {
        return sysUserMapper.querySysUser();
    }
}
