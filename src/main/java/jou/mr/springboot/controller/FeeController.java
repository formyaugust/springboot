package jou.mr.springboot.controller;

import jou.mr.springboot.entity.Result;
import jou.mr.springboot.entity.Fee;
import jou.mr.springboot.mapper.FeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fee")
@CrossOrigin
public class FeeController {

    @Autowired
    FeeMapper feeMapper;

    @RequestMapping("/insertFee")
    public Result insertFee(@RequestBody Fee fee) {
        return feeMapper.insertFee(fee) > 0 ? Result.success("添加成功") : Result.fail("添加失败");
    }

    @RequestMapping(value = "/updateFeeById", produces = "application/json;charset=utf-8")
    public Result updateFeeById(@RequestBody Fee fee) {
        return feeMapper.updateFeeById(fee) > 0 ? Result.success("修改成功") : Result.fail("修改失败");
    }

    @RequestMapping(value = "/deleteFeeById", produces = "application/json;charset=utf-8")
    public Result deleteFeeById(@RequestParam Integer feeId) {
        return feeMapper.deleteFeeById(feeId) > 0 ? Result.success("删除成功") : Result.fail("删除失败");
    }

    @RequestMapping(value = "/selectFeeById", produces = "application/json;charset=utf-8")
    public Result selectFeeById(Integer feeId) {
        return Result.success(feeMapper.selectFeeById(feeId));
    }

    @RequestMapping(value = "/selectFeeAll", produces = "application/json;charset=utf-8")
    public Result selectFeeAll() {
        return Result.success(feeMapper.selectFeeAll());
    }
}