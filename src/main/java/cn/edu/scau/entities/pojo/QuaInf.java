package cn.edu.scau.entities.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuaInf {
    private long quainfId;
    private long areaId;
    private long treeId;
    private String qrcodeId;
    private String inf;
    private String imageName;

    public QuaInf(long areaId, long treeId, String qrcodeId, String inf, String imageName) {
        this.areaId = areaId;
        this.treeId = treeId;
        this.qrcodeId = qrcodeId;
        this.inf = inf;
        this.imageName = imageName;
    }
}
