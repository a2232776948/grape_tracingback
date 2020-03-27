package cn.edu.scau.entities.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("质检信息表,areaId,treeId,qrcodeId三者要求只有一个有值，quaInf和image至少一个有值")
public class QuaInfDTO {
    @ApiModelProperty(value = "地块ID")
    private long areaId;
    @ApiModelProperty(value = "树ID")
    private long treeId;
    @ApiModelProperty(value = "二维码编号")
    private String qrcodeId;
    @ApiModelProperty(value = "质检信息描述")
    private String quaInf;
    @ApiModelProperty(value = "图片")
    private MultipartFile image;
}
