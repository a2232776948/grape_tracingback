package cn.edu.scau.entities.pojo;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;


@Data
public class Logistics {
    private long logisticsId;
    private String qrcodeId;
    private String descri;
    private String time;
}
