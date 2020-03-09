package cn.edu.scau.entities.pojo;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@Data
public class Tree {
    private long treeId;
    private String treeName;
}
