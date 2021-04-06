package stu.wbw.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.wbw.mapper.PropertyValueMapper;
import stu.wbw.pojo.Property;
import stu.wbw.pojo.PropertyValue;
import stu.wbw.service.ProductService;
import stu.wbw.service.PropertyService;
import stu.wbw.service.PropertyValueService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyValueServiceImpl implements PropertyValueService {
    @Autowired
    PropertyValueMapper propertyValueMapper;

    @Autowired
    PropertyService propertyService;

    @Autowired
    ProductService productService;


    @Override
    public int addPropertyValue(PropertyValue propertyValue) {
        return propertyValueMapper.addPropertyValue(propertyValue);
    }

    @Override
    public int deletePropertyValueById(Integer id) {
        return propertyValueMapper.deletePropertyValueById(id);
    }

    @Override
    public void deletePropertyByProductId(Integer product_id) {
        Integer category_id = productService.queryProductById(product_id).getCategory_id();
        List<PropertyValue> propertyValues = queryByProductIdAndPropertyId(product_id, category_id);
        for (int i = 0; i < propertyValues.size(); i++) {
            propertyValueMapper.deletePropertyValueById(propertyValues.get(i).getId());
        }
    }

    @Override
    public int updatePropertyValue(PropertyValue propertyValue) {
        return propertyValueMapper.updatePropertyValue(propertyValue);
    }

    @Override
    public PropertyValue queryPropertyValueById(Integer id) {
        return propertyValueMapper.queryPropertyValueById(id);
    }

    @Override
    public List<PropertyValue> queryAllPropertyValue() {
        return propertyValueMapper.queryAllPropertyValue();
    }

    //根据分类ID查询出所有的属性
    @Override
    public List<PropertyValue> queryByProductIdAndPropertyId(Integer product_id, Integer category_id) {
        List<PropertyValue> propertyValues = new ArrayList<>();
        List<Property> properties = propertyService.queryAllPropertyByCategoryId(category_id);
        for (Property property : properties) {
            propertyValues.addAll(propertyValueMapper.queryByProductIdAndPropertyId(product_id,property.getId()));
        }
        return propertyValues;
    }

    @Override
    public List<PropertyValue> queryByProductId(Integer product_id) {
        List<PropertyValue> propertyValues = propertyValueMapper.queryByProductId(product_id);
        for (PropertyValue propertyValue : propertyValues) {
            Property property = propertyService.queryProperty(propertyValue.getProperty_id());
            propertyValue.setProperty(property);
        }
        return propertyValues;
    }
}
