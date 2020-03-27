package cn.edu.scau.entities.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "农事操作表")
public class FarmopDTO {
    private long farmopId;
    @ApiModelProperty(value = "地块ID",example = "2")
    private long areaId;
    @ApiModelProperty(value = "地块名称",example = "")
    private String areaName;
    @ApiModelProperty(value = "树ID",example = "2")
    private long treeId;
    @ApiModelProperty(value = "农事描述",example = "施肥2千克")
    private String farmopDes;
    @ApiModelProperty(value = "农事时间",example = "2018-12-23")
    private String farmopTime;
    @ApiModelProperty(value = "农事操作种类Id",example = "1")
    private long farmcateId;
    @ApiModelProperty(value = "农事操作种类名称",example = "施肥")
    private String farmcateName;
    @ApiModelProperty(value = "操作人",example = "张三")
    private String opperson;

}
