package cn.edu.scau.entities.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Mapper;

import java.beans.ConstructorProperties;

@Mapper
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Qrcode {
    private String qrcodeId;
    private String qrcode_addr;
    private String desc;

    public Qrcode(String qrcodeId) {
        this.qrcodeId = qrcodeId;
    }

}
