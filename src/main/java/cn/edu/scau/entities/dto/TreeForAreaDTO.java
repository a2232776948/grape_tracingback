package cn.edu.scau.entities.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class TreeForAreaDTO {
    @ApiModelProperty(value = "植株种类",example = "黑加仑")
    private String treeCate;
    @ApiModelProperty(value = "种植日期",example = "2019-3-2")
    private String plantDate;
    @ApiModelProperty(value = "植株状态",example = "存活")
    private String treeState;
}
