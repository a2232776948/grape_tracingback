package cn.edu.scau.entities.pojo;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@Data
public class Qrcode {
    private long qrcodeId;
    private long qrcodeAddr;
    private String desc;
}
