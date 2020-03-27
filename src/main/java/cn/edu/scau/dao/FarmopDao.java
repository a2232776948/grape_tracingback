package cn.edu.scau.dao;

import cn.edu.scau.dao.sql_provider.FarmopProvider;
import cn.edu.scau.entities.dto.FarmopDTO;
import cn.edu.scau.entities.pojo.Farmcate;
import cn.edu.scau.entities.pojo.Farmop;
import cn.edu.scau.entities.vo.FarmopConditionVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FarmopDao {
    @Select("select * from farmop")
    List<Farmop> findAllFarmop();

    @Select("select farmop_id,farmop.area_id,area.area_name,farmop.tree_id,farmop_des,farmop.farmcate_id,farmcate_name,farmop_time,opperson from farmop,farmcate,area where area.area_id=farmop.area_id and farmop.farmcate_id=farmcate.farmcate_id")
    List<FarmopDTO> findDTOAllFarmop();

    @Select("select farmop_id,farmop.area_id,area.area_name,farmop.tree_id,farmop_des,farmcate_name,farmop_time,opperson from farmop,farmcate,area where area.area_id=farmop.area_id and farmop.farmcate_id=farmcate.farmcate_id and farmop_id=#{id}")
    FarmopDTO findOneFarmopById(@Param("id") Integer id);

    @SelectProvider(type = FarmopProvider.class,method = "findFarmopByCondition")
    List<FarmopDTO> findFarmopByCondition(FarmopConditionVO farmopConditionVO);

    @InsertProvider(type = FarmopProvider.class,method = "addFarmops")
    void addFarmops(List<Farmop> farmops);

    @Insert("insert into farmop(area_id,tree_id,farmop_des,farmcate_id,farmop_time,opperson) VALUES (#{areaId},#{treeId},#{farmopDes}, #{farmcateId},#{farmopTime},#{opperson})")
    void insertOneFarmop(Farmop f);

    @UpdateProvider(type=FarmopProvider.class,method = "updateOneFarmop")
    void updateOneFarmop(Farmop f);

    @DeleteProvider(type = FarmopProvider.class,method = "deleteFarmop")
    void deleteFarmop(@Param("ids") List<Integer> ids);

    @Select("select * from farmcate")
    List<Farmcate> getAllFarmCate();

    @InsertProvider(type = FarmopProvider.class,method = "insertFarmopsForTree")
    void insertFarmopsForTree(@Param("farmops") List<Farmop> farmops);

    @InsertProvider(type = FarmopProvider.class,method = "insertFarmopsForArea")
    void insertFarmopsForArea(@Param("farmops") List<Farmop> farmops);
}
