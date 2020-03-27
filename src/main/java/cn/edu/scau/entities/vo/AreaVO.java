package cn.edu.scau.entities.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaVO {
    private long areaId;
    private String areaName;
    private String addr;
    private long treeCount;
}
