package cn.edu.scau.dao;

import cn.edu.scau.dao.sql_provider.logisticsProvider;
import cn.edu.scau.entities.dto.LogisticsDTO;
import cn.edu.scau.entities.pojo.Logistics;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LogisticsDao {
    @Select("select * from logistics")
    public List<Logistics> getAllLogisticsInfo();

    @InsertProvider(type = logisticsProvider.class,method = "insertLogisticses")
    public void insertLogisticses(@Param("logisticsDTOS") List<LogisticsDTO> logisticsDTOS);

    @DeleteProvider(type = logisticsProvider.class,method = "deleteLogisticsInfo")
    public void deleteLogisticsInfo(@Param("ids") int[] ids);
}
