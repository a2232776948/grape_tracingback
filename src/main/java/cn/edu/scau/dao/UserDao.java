package cn.edu.scau.dao;

import cn.edu.scau.entities.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    @Select("select * from user where name=#{userName}")
    public User selectOne(String userName);

    @Update("update user SET password=#{password},sex=#{sex},email=#{email},introduce=#{introduce},nikename=#{nikename} where name=#{name}")
    public void updateUser(User user);

    @Delete("delete from user where name=#{name}")
    public void deleteUser(String name);

    @Insert("insert into user value(#{name},#{password},#{sex},#{email},#{introduce},#{nikename},#{role})")
    public void addUser(User user);

    @Select("select * from user")
    public List<User> getAllUser();
}
