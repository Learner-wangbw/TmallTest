package stu.wbw.mapper;

import stu.wbw.pojo.Property;

import java.util.List;

public interface PropertyMapper {
    //增加一个属性名
    int addProperty(Property property);
    //删除一个属性名
    int deleteProperty(Integer id);
    //修改一个属性名
    int updateProperty(Property property);
    //查询一个属性名
    Property queryProperty(Integer id);
    //查询所有属性名
    List<Property> queryAllProperty();
    //查询category_id下的Property列表
    List<Property> queryAllPropertyByCategoryId(Integer category_id);
}
