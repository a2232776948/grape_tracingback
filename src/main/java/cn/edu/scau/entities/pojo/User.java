package cn.edu.scau.entities.pojo;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@Data
public class User {
    private String name;
    private String password;
    private int role;
    private String remark;
}
