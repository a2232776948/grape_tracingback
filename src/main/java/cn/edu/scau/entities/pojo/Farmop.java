package cn.edu.scau.entities.pojo;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;


@Mapper
@Data
public class Farmop {
    private long farmopId;
    private long areaId;
    private long treeId;
    private String farmopDes;
    private long farmcateId;
    private Date farmopTime;
    private String oppersonName;
}
