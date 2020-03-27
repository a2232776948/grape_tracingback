package cn.edu.scau.controller;

import cn.edu.scau.entities.pojo.User;
import cn.edu.scau.entities.vo.Response;
import cn.edu.scau.exception.GlobalException;
import cn.edu.scau.service.impl.UserServiceImpl;
import cn.edu.scau.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "用户接口")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @ApiOperation(value = "登录")
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public Response<User> Login(String userName,String passWord) throws GlobalException {
        User user = userService.login(userName, passWord);
        return ResponseUtil.success("登录成功",user);
    }

    @ApiOperation(value = "更改用户信息")
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public Response updateUser(User user){
        userService.updateUser(user);
        return ResponseUtil.success("用户信息更新成功");
    }

    @ApiOperation(value = "删除用户")
    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    public Response deleteUser(String userName){
        userService.deleteUser(userName);
        return ResponseUtil.success("删除成功");
    }

    @ApiOperation(value = "添加用户")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public Response addUser(User user){
        userService.addUser(user);
        return ResponseUtil.success("添加成功");
    }

    @ApiOperation(value = "获取所有用户")
    @RequestMapping(value = "/getAllUser",method = RequestMethod.POST)
    public Response<List<User>> getAllUser(){
        List<User> users = userService.getAllUser();
        return ResponseUtil.success(users);
    }
}
