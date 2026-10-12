package jou.mr.springboot.mapper;

import jou.mr.springboot.entity.Owner;

import java.util.List;

public interface OwnerMapper {
    Integer insertOwner(Owner owner);

    Integer updateOwnerById(Owner owner);

    Integer deleteOwnerById(Integer ownerId);

    Owner selectOwnerById(Integer ownerId);

    // 查询所有业主
    List<Owner> selectOwnerAll();
}