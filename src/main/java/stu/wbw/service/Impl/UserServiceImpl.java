package stu.wbw.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.wbw.mapper.UserMapper;
import stu.wbw.pojo.User;
import stu.wbw.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User queryUserById(Integer id) {
        return userMapper.queryUserById(id);
    }

    @Override
    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }

    @Override
    public List<User> queryUserByUsername(String name) {
        //若在数据库中添加%%存在sql注入的危险
        name = "%"+name+"%";
        return userMapper.queryUserByUsername(name);
    }

    @Override
    public User queryUserByNameAndPwd(String name, String password) {
        return userMapper.queryUserByNameAndPwd(name, password);
    }

    @Override
    public boolean isExist(String name) {
        //若在数据库中添加%%存在sql注入的危险
        name = "%"+name+"%";
        List<User> userList = userMapper.queryUserByUsername(name);
        if (!userList.isEmpty()){
            return true;
        }
        return false;
    }
}
