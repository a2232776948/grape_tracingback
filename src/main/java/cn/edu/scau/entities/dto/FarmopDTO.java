package cn.edu.scau.entities.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
@Data
@NoArgsConstructor
public class FarmopDTO {
    private long areaId;
    private long treeId;
    private String farmopDes;
    private Date farmopTime;
    private String farmcateName;
    private String opperson;

}
