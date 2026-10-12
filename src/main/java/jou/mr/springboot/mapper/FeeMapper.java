package jou.mr.springboot.mapper;

import jou.mr.springboot.entity.Fee;
import java.util.List;

public interface FeeMapper {
    Integer insertFee(Fee fee);

    Integer updateFeeById(Fee fee);

    Integer deleteFeeById(Integer feeId);

    Fee selectFeeById(Integer feeId);

    // 查询所有缴费记录
    List<Fee> selectFeeAll();
}