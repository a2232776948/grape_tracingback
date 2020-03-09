package cn.edu.scau.entities.pojo;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@Data
public class Role {
    private int roleId;
    private String roleName;
}
