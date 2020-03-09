package cn.edu.scau.entities.pojo;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@Data
public class Logistics {
    private long logisticsId;
    private long qrcodeId;
    private String desc;
}
