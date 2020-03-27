package cn.edu.scau.dao;

import cn.edu.scau.dao.sql_provider.AreaAndTreeProvider;
import cn.edu.scau.entities.dto.AreaDTO;
import cn.edu.scau.entities.dto.TreeForAreaDTO;
import cn.edu.scau.entities.pojo.Area;
import cn.edu.scau.entities.pojo.Tree;
import cn.edu.scau.entities.pojo.TreeCate;
import cn.edu.scau.entities.vo.AreaVO;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AreaAndTreeDao {
    @Select("select * from area")
    public List<Integer> findAllArea();

    @Select("select tree_id from ")
    public List<Integer> findAllTreeIdByAreaId();

    @Select("call insertArea(#{areaName},#{addr})")
    public void addArea(AreaDTO areaDTO);

    @Update("update area set area_name = #{areaName},addr=#{addr} where area_id = #{areaId}")
    public void updateAreaName(Area area);

    @Select("select * from tree where area_id=#{areaId}")
    public List<Tree> getAllTreeByAreaId(int areaId);

    @InsertProvider(type = AreaAndTreeProvider.class,method = "addTreeForArea")
    public void addTreeForArea(@Param("trees") List<Tree> trees);

    @Select("select max(tree_id) from tree where area_id=#{areaId}")
    public int findLastTreeIdByAreaId(int areaId);

    @Select("select * from treecate")
    public List<TreeCate> getAllTreeCate();

    @Insert("insert into treecate(tree_cate) value(#{treeCate})")
    public void addTreeCate(String treeCate);

    @Delete("delete from treecate where id=#{id}")
    public void deleteTreeCate(int id);

    @Select("select area.area_id,area_name,addr,count(tree.tree_id) as tree_count from area left join tree on area.area_id=tree.area_id GROUP BY area.area_id")
    public List<AreaVO> getAllAreaVO();
}
