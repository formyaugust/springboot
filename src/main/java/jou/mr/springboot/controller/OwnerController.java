package jou.mr.springboot.controller;

import jou.mr.springboot.entity.Result;
import jou.mr.springboot.entity.Owner;
import jou.mr.springboot.mapper.OwnerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/owner")
@CrossOrigin
public class OwnerController {

    @Autowired
    OwnerMapper ownerMapper;

    @RequestMapping("/insertOwner")
    public Result insertOwner(@RequestBody Owner owner) {
        return ownerMapper.insertOwner(owner) > 0 ? Result.success("添加成功") : Result.fail("添加失败");
    }

    @RequestMapping(value = "/updateOwnerById", produces = "application/json;charset=utf-8")
    public Result updateOwnerById(@RequestBody Owner owner) {
        return ownerMapper.updateOwnerById(owner) > 0 ? Result.success("修改成功") : Result.fail("修改失败");
    }

    @RequestMapping(value = "/deleteOwnerById", produces = "application/json;charset=utf-8")
    public Result deleteOwnerById(Integer ownerId) {
        return ownerMapper.deleteOwnerById(ownerId) > 0 ? Result.success("删除成功") : Result.fail("删除失败");
    }

    @RequestMapping(value = "/selectOwnerById", produces = "application/json;charset=utf-8")
    public Result selectOwnerById(Integer ownerId) {
        return Result.success(ownerMapper.selectOwnerById(ownerId));
    }

    @RequestMapping(value = "/selectOwnerAll", produces = "application/json;charset=utf-8")
    public Result selectOwnerAll() {
        return Result.success(ownerMapper.selectOwnerAll());
    }
}