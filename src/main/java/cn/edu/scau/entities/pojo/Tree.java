package cn.edu.scau.entities.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tree {
    private long id;
    private long areaId;
    private long treeId;
    private String treeCate;
    private String plantDate;
    private String treeState;

    public Tree(long treeId, String treeCate, String plantDate, String treeState) {
        this.treeId = treeId;
        this.treeCate = treeCate;
        this.plantDate = plantDate;
        this.treeState = treeState;
    }

    public Tree(long areaId, long treeId, String treeCate, String plantDate, String treeState) {
        this.areaId = areaId;
        this.treeId = treeId;
        this.treeCate = treeCate;
        this.plantDate = plantDate;
        this.treeState = treeState;
    }
}
