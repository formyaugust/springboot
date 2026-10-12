package jou.mr.springboot.controller;

import jou.mr.springboot.entity.Result;
import jou.mr.springboot.entity.Repair;
import jou.mr.springboot.mapper.RepairMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/repair")
@CrossOrigin
public class RepairController {

    @Autowired
    RepairMapper repairMapper;

    @RequestMapping("/insertRepair")
    public Result insertRepair(@RequestBody Repair repair) {
        return repairMapper.insertRepair(repair) > 0 ? Result.success("添加成功") : Result.fail("添加失败");
    }

    @RequestMapping(value = "/updateRepairById", produces = "application/json;charset=utf-8")
    public Result updateRepairById(@RequestBody Repair repair) {
        return repairMapper.updateRepairById(repair) > 0 ? Result.success("修改成功") : Result.fail("修改失败");
    }

    @RequestMapping(value = "/deleteRepairById", produces = "application/json;charset=utf-8")
    public Result deleteRepairById(Integer repairId) {
        return repairMapper.deleteRepairById(repairId) > 0 ? Result.success("删除成功") : Result.fail("删除失败");
    }

    @RequestMapping(value = "/selectRepairById", produces = "application/json;charset=utf-8")
    public Result selectRepairById(Integer repairId) {
        return Result.success(repairMapper.selectRepairById(repairId));
    }

    @RequestMapping(value = "/selectRepairAll", produces = "application/json;charset=utf-8")
    public Result selectRepairAll() {
        return Result.success(repairMapper.selectRepairAll());
    }
}