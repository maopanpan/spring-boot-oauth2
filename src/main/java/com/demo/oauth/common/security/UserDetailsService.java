package com.demo.oauth.common.security;

import com.demo.oauth.dao.sys.SysUserMapper;
import com.demo.oauth.dao.sys.SysUserPrivilegeMapper;
import com.demo.oauth.model.sys.SysUser;
import com.demo.oauth.model.sys.SysUserPrivilege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author: maopanpan
 * @Description: 加载用户信息
 * @Date: 2017/11/15.
 **/
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserPrivilegeMapper sysUserPrivilegeMapper;

    protected static final String ROLE_PREFIX = "ROLE_";

    @Override
    public UserDetails loadUserByUsername(final String s) throws UsernameNotFoundException {
        SysUser sysUser = sysUserMapper.querySysUserByUsername(s);

        if (sysUser == null) {
            throw new UsernameNotFoundException("User " + s + " was not found in the database");
        }

        List<SysUserPrivilege> sysUserPrivileges = sysUserPrivilegeMapper.querySysUserPrivilege(sysUser.getId());
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (SysUserPrivilege sup : sysUserPrivileges) {
            String a = ROLE_PREFIX + sup.getPrivilege();
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(a);
            grantedAuthorities.add(grantedAuthority);
        }
        return new User(sysUser.getUsername(), sysUser.getPassword(), grantedAuthorities);
    }
}
