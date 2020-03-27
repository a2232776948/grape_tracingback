package cn.edu.scau.dao;

import cn.edu.scau.dao.sql_provider.QuaInfProvoder;
import cn.edu.scau.entities.dto.QuaInfDTO;
import cn.edu.scau.entities.pojo.QuaInf;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuaInfDao {
    @InsertProvider(type = QuaInfProvoder.class,method = "insertQuaInf")
    public void insertQuaInf(QuaInf quaInf);

    @Update("update quainf set image_name=#{quaInfImageName} where quainf_id=#{lastId)")
    public void setQuaInfImageName(String quaInfImageName,long lastId);

    @Select("select max(quainf_id) from quainf")
    public long findLastQuaInfId();

    @Select("select image_name from quainf where quainf_id=(select max(quainf_id) from quainf)")
    public String findLastImageName();

    @Delete("delete from quainf where quainf_id=#{quaInfId}")
    public void deleteOneQuaInf(int quaInfId);
}
