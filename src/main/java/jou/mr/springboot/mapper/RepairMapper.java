package jou.mr.springboot.mapper;

import jou.mr.springboot.entity.Repair;
import java.util.List;

public interface RepairMapper {
    Integer insertRepair(Repair repair);

    Integer updateRepairById(Repair repair);

    Integer deleteRepairById(Integer repairId);

    Repair selectRepairById(Integer repairId);

    // 查询所有报修单
    List<Repair> selectRepairAll();
}