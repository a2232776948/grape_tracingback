package cn.edu.scau.entities.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class AmountConditionVO {
    @ApiModelProperty(value = "地块ID",example = "2")
    private Long areaId;
    @ApiModelProperty(value = "年份",example = "2020")
    private Long year;
    @ApiModelProperty(value = "月份",example = "2")
    private Long month;
}
