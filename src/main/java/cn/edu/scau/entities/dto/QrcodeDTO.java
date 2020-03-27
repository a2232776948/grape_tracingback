package cn.edu.scau.entities.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "二维码")
public class QrcodeDTO {
    @ApiModelProperty(value = "二维码编号",example = "201905182189001",required = true)
    private String qrcodeId;

    @ApiModelProperty(value = "地块ID",example = "21")
    private long areaId;

    @ApiModelProperty(value = "树ID",example = "89")
    private long treeId;

    @ApiModelProperty(value = "采摘时间",example = "2019-05-16")
    private String date;

    @ApiModelProperty(hidden = true)
    public String getDateAT(){
        return  String.valueOf(date).replace("-","")+String.valueOf(areaId)+String.valueOf(treeId);
    }

    @ApiModelProperty(hidden = true)
    public String dateFormat(){
        return date.replace("-","");
    }
}
