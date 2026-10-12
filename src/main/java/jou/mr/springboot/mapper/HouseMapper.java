package jou.mr.springboot.mapper;

import jou.mr.springboot.entity.House;
import java.util.List;

public interface HouseMapper {
    Integer insertHouse(House house);

    Integer updateHouseById(House house);

    Integer deleteHouseById(Integer houseId);

    House selectHouseById(Integer houseId);

    // 根据业主ID查询房屋
    List<House> selectHouseByOwnerId(Integer ownerId);

    // 查询所有房屋
    List<House> selectHouseAll();
}