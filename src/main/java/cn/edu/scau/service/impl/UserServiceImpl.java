package cn.edu.scau.service.impl;

import cn.edu.scau.dao.UserDao;
import cn.edu.scau.entities.dto.UserFaction;
import cn.edu.scau.entities.pojo.User;
import cn.edu.scau.exception.GlobalException;
import cn.edu.scau.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User login(String userName,String passWord) throws GlobalException {
        if (userName == null || "".equals(userName.trim())
                || passWord == null || "".equals(passWord.trim())) {
            throw new GlobalException("用户名和密码不能为空");
        }

        User user = userDao.selectOne(userName.trim());
        //对前端输入的密码进行md5加密后再与后台取出的密码进行对比
        //password = MD5.getMD5(password);
        System.out.println("ok1");

        if (user == null) {
            throw new GlobalException("用户名不存在");
        } else if(!user.getPassword().equals(passWord.trim())){
            throw new GlobalException("密码错误");
        } else {
            UserFaction userFaction = new UserFaction();
//            userFunction.setUsername(users.getUsername());
//            //获取用户权限url
//            String roleNo = users.getRole();
//            if (roleNo == null || "".equals(roleNo)) {
//                userFunction.setFunctions(new ArrayList<String>());
//            } else {
//                userFunction.setFunctions(functionDAO.selectURLByRole(roleNo));
//            }
        }
        return user;
    }

    @Override
    public void logiOut(String userName,String passWord) {

    }

    @Override
    public void register(String userName,String passWord) {

    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(String name) {
        userDao.deleteUser(name);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }


}
