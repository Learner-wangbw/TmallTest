package stu.wbw.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.wbw.mapper.PropertyMapper;
import stu.wbw.pojo.Property;
import stu.wbw.service.PropertyService;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    PropertyMapper propertyMapper;

    @Override
    public int addProperty(Property property) {
        return propertyMapper.addProperty(property);
    }

    @Override
    public int deleteProperty(Integer id) {
        return propertyMapper.deleteProperty(id);
    }

    @Override
    public int updateProperty(Property property) {
        return propertyMapper.updateProperty(property);
    }

    @Override
    public Property queryProperty(Integer id) {
        return propertyMapper.queryProperty(id);
    }

    @Override
    public List<Property> queryAllProperty() {
        return propertyMapper.queryAllProperty();
    }

    @Override
    public List<Property> queryAllPropertyByCategoryId(Integer category_id) {
        return propertyMapper.queryAllPropertyByCategoryId(category_id);
    }
}
