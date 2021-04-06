package stu.wbw.mapper;

import org.apache.ibatis.annotations.Param;
import stu.wbw.pojo.User;

import java.util.List;

public interface UserMapper {
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
    User queryUserByNameAndPwd(@Param("name") String name, @Param("password") String password);

}
