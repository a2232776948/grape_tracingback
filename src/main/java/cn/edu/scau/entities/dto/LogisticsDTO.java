package cn.edu.scau.entities.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@ApiModel
public class LogisticsDTO {
    @ApiModelProperty(value="二维码")
    private String qrcodeId;
    @ApiModelProperty(value="描述")
    private String descri;
    @ApiModelProperty(value="时间")
    private String time;
}
