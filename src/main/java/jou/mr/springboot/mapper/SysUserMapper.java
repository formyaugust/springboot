package jou.mr.springboot.mapper;

import jou.mr.springboot.entity.SysUser;

import java.util.List;

public interface SysUserMapper {
    Integer insertSysUser(SysUser sysUser);

    Integer updateSysUserById(SysUser sysUser);

    Integer deleteSysUserById(Integer userId);

    SysUser checkLogin(SysUser sysUser);
    // 查询所有用户
    List<SysUser> selectSysUserAll();
}