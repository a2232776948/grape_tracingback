package cn.edu.scau.entities.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FarmopConditionVO {
    private long areaId;
    private long treeId;
    private String farmopDes;
    private String startTime;
    private String endTime;
    private String farmcateName;
    private String opperson;

}

