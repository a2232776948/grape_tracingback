package cn.edu.scau.entities.pojo;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@Data
public class Quainf {
    private long quainfId;
    private long areaId;
    private long treeId;
    private long qrcodeId;
}
