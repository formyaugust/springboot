package jou.mr.springboot.controller;

import jou.mr.springboot.entity.Result;
import jou.mr.springboot.entity.House;
import jou.mr.springboot.mapper.HouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/house")
@CrossOrigin
public class HouseController {

    @Autowired
    HouseMapper houseMapper;

    @RequestMapping("/insertHouse")
    public Result insertHouse(@RequestBody House house) {
        return houseMapper.insertHouse(house) > 0 ? Result.success("添加成功") : Result.fail("添加失败");
    }

    @RequestMapping(value = "/updateHouseById", produces = "application/json;charset=utf-8")
    public Result updateHouseById(@RequestBody House house) {
        return houseMapper.updateHouseById(house) > 0 ? Result.success("修改成功") : Result.fail("修改失败");
    }

    @RequestMapping(value = "/deleteHouseById", produces = "application/json;charset=utf-8")
    public Result deleteHouseById(@RequestParam Integer houseId) {
        return houseMapper.deleteHouseById(houseId) > 0 ? Result.success("删除成功") : Result.fail("删除失败");
    }

    @RequestMapping(value = "/selectHouseById", produces = "application/json;charset=utf-8")
    public Result selectHouseById(Integer houseId) {
        return Result.success(houseMapper.selectHouseById(houseId));
    }

    @RequestMapping(value = "/selectHouseAll", produces = "application/json;charset=utf-8")
    public Result selectHouseAll() {
        return Result.success(houseMapper.selectHouseAll());
    }
}