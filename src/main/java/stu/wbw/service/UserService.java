package stu.wbw.service;

import stu.wbw.pojo.User;

import java.util.List;

public interface UserService {
    //增加一个用户
    int addUser(User user);
    //删除一个用户
    int deleteUserById(Integer id);
    //修改一个用户
    int updateUser(User user);
    //查询一个用户
    User queryUserById(Integer id);
    //查询所有用户
    List<User> queryAllUser();
    //根据用户名查询用户
    List<User> queryUserByUsername(String name);
    //根据用户名和密码查询用户
    User queryUserByNameAndPwd(String name, String password);
    //根据用户名判断该用户是否存在
    boolean isExist(String name);
}
