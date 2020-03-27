package cn.edu.scau.service;

import cn.edu.scau.entities.dto.UserFaction;
import cn.edu.scau.entities.pojo.User;
import cn.edu.scau.exception.GlobalException;

import java.util.List;

public interface UserService {
    public User login(String userName, String passWord) throws GlobalException;
    public void logiOut(String userName,String passWord);
    public void register(String userName,String passWord);

    public void updateUser(User user);
    public void deleteUser(String name);
    public void addUser(User user);
    public List<User> getAllUser();
}
