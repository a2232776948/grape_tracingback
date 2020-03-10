package cn.edu.scau.dao;

import cn.edu.scau.entities.dto.FarmopDTO;
import cn.edu.scau.entities.pojo.Farmop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FarmopDao {
    @Select("select * from farmop")
    List<Farmop> findAllFarmop();
    @Select("select area_id,tree_id,farmop_des,farmcate_name,farmop_time,opperson from farmop,farmcate where farmop.farmcate_id=farmcate.farmcate_id")
    List<FarmopDTO> findDTOAllFarmop();
    @Select("select area_id,tree_id,farmop_des,farmcate_name,farmop_time,opperson from farmop,farmcate where farmop.farmcate_id=farmcate.farmcate_id and farmop_id=#{id}")
    FarmopDTO findOneFarmopById(Integer id);
}
