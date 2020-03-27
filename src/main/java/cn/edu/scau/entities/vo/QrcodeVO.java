package cn.edu.scau.entities.vo;

import cn.edu.scau.constent.Qr;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QrcodeVO {

    @ApiModelProperty(value = "地块ID",example = "2",required = true)
    private long areaId;

    @ApiModelProperty(value = "树ID",example = "8",required = true)
    private long treeId;

    @ApiModelProperty(value = "采摘时间",example = "2019-05-16",required = true)
    private String date;

    @ApiModelProperty(hidden = true)
    public String getDateAT(){
        String areaIdFormat = Qr.numTransFormat(String.valueOf(areaId),"00",0);
        String treeIdFormat = Qr.numTransFormat(String.valueOf(treeId),"00",0);
        return  String.valueOf(date).replace("-","")+areaIdFormat+treeIdFormat;
    }
}
