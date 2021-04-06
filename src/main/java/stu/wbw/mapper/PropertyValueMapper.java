package stu.wbw.mapper;

import org.apache.ibatis.annotations.Param;
import stu.wbw.pojo.PropertyValue;

import java.util.List;

public interface PropertyValueMapper {
    //增加一个属性具体值
    int addPropertyValue(PropertyValue propertyValue);
    //删除一个属性具体值
    int deletePropertyValueById(Integer id);
    //根据product_id删除对应数据
    int deletePropertyByProductId(Integer product_id);
    //修改一个属性具体值
    int updatePropertyValue(PropertyValue propertyValue);
    //查询一个属性具体值
    PropertyValue queryPropertyValueById(Integer id);
    //查询所有属性具体值
    List<PropertyValue> queryAllPropertyValue();
    //PropertyValue 表有两个外键，需要根据这两个外键进行匹配
    //返回对应的所有 PropertyValue 值
    List<PropertyValue> queryByProductIdAndPropertyId(@Param("product_id") Integer product_id, @Param("property_id") Integer property_id);
    //根据product_id返回PropertyValue，
    //并设置好自身的Property
    List<PropertyValue> queryByProductId(Integer product_id);
}
