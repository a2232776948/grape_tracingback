package cn.edu.scau.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AmountDTO {
    private Long areaId;
    private Long amount;
    private Long year;
    private Long month;
}
