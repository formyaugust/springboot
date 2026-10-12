package jou.mr.springboot.controller;

import jou.mr.springboot.entity.Result;
import jou.mr.springboot.entity.SysUser;
import jou.mr.springboot.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/sysUser")
@CrossOrigin
public class SysUserController {

    @Autowired
    SysUserMapper sysUserMapper;

    @RequestMapping("/insertSysUser")
    public Result insertSysUser(@RequestBody SysUser sysUser) {
        return sysUserMapper.insertSysUser(sysUser) > 0 ? Result.success("添加成功") : Result.fail("添加失败");
    }

    @RequestMapping(value = "/updateSysUserById", produces = "application/json;charset=utf-8")
    public Result updateSysUserById(@RequestBody SysUser sysUser) {
        return sysUserMapper.updateSysUserById(sysUser) > 0 ? Result.success("修改成功") : Result.fail("修改失败");
    }

    @RequestMapping(value = "/deleteSysUserById", produces = "application/json;charset=utf-8")
    public Result deleteSysUserById(Integer userId) {
        return sysUserMapper.deleteSysUserById(userId) > 0 ? Result.success("删除成功") : Result.fail("删除失败");
    }

    @RequestMapping(value = "/checkLogin", produces = "application/json;charset=utf-8")
    public Result checkLogin(@RequestBody SysUser sysUser) {
        SysUser loginUser = sysUserMapper.checkLogin(sysUser);
        if(loginUser != null)
        {
            return Result.success(loginUser);
        }else {
            return Result.fail("账号或密码错误");
        }
    }

    @RequestMapping(value = "/selectSysUserAll", produces = "application/json;charset=utf-8")
    public Result selectSysUserAll() {
        return Result.success(sysUserMapper.selectSysUserAll());
    }
}