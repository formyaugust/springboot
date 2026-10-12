package jou.mr.springboot.controller;

import jou.mr.springboot.entity.Result;
import jou.mr.springboot.entity.Parking;
import jou.mr.springboot.mapper.ParkingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking")
@CrossOrigin
public class ParkingController {

    @Autowired
    ParkingMapper parkingMapper;

    @RequestMapping("/insertParking")
    public Result insertParking(@RequestBody Parking parking) {
        return parkingMapper.insertParking(parking) > 0 ? Result.success("添加成功") : Result.fail("添加失败");
    }

    @RequestMapping(value = "/updateParkingById", produces = "application/json;charset=utf-8")
    public Result updateParkingById(@RequestBody Parking parking) {
        return parkingMapper.updateParkingById(parking) > 0 ? Result.success("修改成功") : Result.fail("修改失败");
    }

    @RequestMapping(value = "/deleteParkingById", produces = "application/json;charset=utf-8")
    public Result deleteParkingById(Integer parkingId) {
        return parkingMapper.deleteParkingById(parkingId) > 0 ? Result.success("删除成功") : Result.fail("删除失败");
    }

    @RequestMapping(value = "/selectParkingById", produces = "application/json;charset=utf-8")
    public Result selectParkingById(Integer parkingId) {
        return Result.success(parkingMapper.selectParkingById(parkingId));
    }

    @RequestMapping(value = "/selectParkingAll", produces = "application/json;charset=utf-8")
    public Result selectParkingAll() {
        return Result.success(parkingMapper.selectParkingAll());
    }
}