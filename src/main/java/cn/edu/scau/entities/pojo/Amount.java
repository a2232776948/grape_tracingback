package cn.edu.scau.entities.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Amount {
    private Long id;
    private Long areaId;
    private Long amount;
    private Long year;
    private Long month;
}
