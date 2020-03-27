package cn.edu.scau.entities.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class AddTreeForAreaDTO {
    @ApiModelProperty(value = "地块编号",example = "12")
    private int areaId;
    private List<TreeForAreaDTO> treeForAreaDTOS;
}
