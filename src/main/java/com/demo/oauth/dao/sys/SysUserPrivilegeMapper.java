package com.demo.oauth.dao.sys;

import com.demo.oauth.dao.base.BaseDao;
import com.demo.oauth.model.sys.SysUserPrivilege;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserPrivilegeMapper extends BaseDao<SysUserPrivilege> {

    public List<SysUserPrivilege> querySysUserPrivilege(Integer id);
}