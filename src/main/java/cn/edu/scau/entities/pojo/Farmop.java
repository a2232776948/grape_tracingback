package cn.edu.scau.entities.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;


@Mapper
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Farmop {
    private long farmopId;
    private long areaId;
    private long treeId;
    private String farmopDes;
    private long farmcateId;
    private String farmopTime;
    private String opperson;

    public Farmop(long areaId, long treeId, String farmopDes, long farmcateId, String farmopTime, String opperson) {
        this.areaId = areaId;
        this.treeId = treeId;
        this.farmopDes = farmopDes;
        this.farmcateId = farmcateId;
        this.farmopTime = farmopTime;
        this.opperson = opperson;
    }
}
