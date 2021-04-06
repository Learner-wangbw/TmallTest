package stu.wbw.mapper;

import stu.wbw.pojo.Product;

import java.util.List;

public interface ProductMapper {
    //增加一个产品
    int addProduct(Product product);
    //删除一个产品
    int deleteProduct(Integer id);
    //修改一个产品
    int updateProduct(Product product);
    //查询一个产品
    Product queryProductById(Integer id);
    //查询所有产品
    List<Product> queryAllProduct();
    //根据category_id返回所有对应的Product数据
    List<Product> queryAllProductByCategoryId(Integer category_id);
    //根据关键字查询相应的产品集合
    List<Product> search(String keyword);
}
