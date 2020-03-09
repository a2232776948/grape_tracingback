package cn.edu.scau.entities.pojo;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@Data
public class Farmcate {
    private long farmcateId;
    private String farmcateName;


}
