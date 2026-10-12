package jou.mr.springboot.mapper;

import jou.mr.springboot.entity.Parking;
import java.util.List;

public interface ParkingMapper {
    Integer insertParking(Parking parking);

    Integer updateParkingById(Parking parking);

    Integer deleteParkingById(Integer parkingId);

    Parking selectParkingById(Integer parkingId);

    // 查询所有车位
    List<Parking> selectParkingAll();
}