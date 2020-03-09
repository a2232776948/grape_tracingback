package cn.edu.scau.dao;

import cn.edu.scau.entities.pojo.Area;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AreaDao {
    @Select("select * from area where area_id=#{id}")
    Area findOneArea(@Param("id") long id);
}
