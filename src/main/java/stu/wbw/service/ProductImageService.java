package stu.wbw.service;

import stu.wbw.pojo.ProductImage;

import java.util.List;

public interface ProductImageService {
    //增加一个产品图片
    int addProductImage(ProductImage productImage);
    //删除一个产品图片
    int deleteProductImageById(Integer id);
    //删除一个产品下的所有图片
    void deleteProductImageByProductId(Integer product_id);
    //修改一个产品图片
    int updateProductImage(ProductImage productImage);
    //查询一个产品图片
    ProductImage queryProductImageById(Integer id);
    //查询所有产品图片
    List<ProductImage> queryAllProductImageByProductId(Integer product_id);
}
