package cn.edu.scau.entities.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QrcodeCSDTO {
    @ApiModelProperty(value = "二维码编号",example = "201905182189001")
    private String qrcodeId;

    @ApiModelProperty(value = "地块ID",example = "21")
    private long areaId;

    @ApiModelProperty(value = "树ID",example = "89")
    private long treeId;

    @ApiModelProperty(value = "采摘时间",example = "2019-05-16")
    private String startDate;

    @ApiModelProperty(value = "采摘时间",example = "2019-05-16")
    private String endDate;

    @ApiModelProperty(hidden = true)
    public String getStartDateFormat(){
        return startDate.replace("-","");
    }

    @ApiModelProperty(hidden = true)
    public String getEndDateFormat(){
        return endDate.replace("-","");
    }

    @ApiModelProperty(hidden = true)
    public String getStartDateAT(){
        return  String.valueOf(startDate).replace("-","")+String.valueOf(areaId)+String.valueOf(treeId);
    }
}
