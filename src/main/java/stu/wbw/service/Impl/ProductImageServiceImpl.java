package stu.wbw.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.wbw.mapper.ProductImageMapper;
import stu.wbw.pojo.ProductImage;
import stu.wbw.service.ProductImageService;

import java.util.List;

@Service
public class ProductImageServiceImpl implements ProductImageService {
    @Autowired
    ProductImageMapper productImageMapper;

    @Override
    public int addProductImage(ProductImage productImage) {
        return productImageMapper.addProductImage(productImage);
    }

    @Override
    public int deleteProductImageById(Integer id) {
        return productImageMapper.deleteProductImageById(id);
    }

    @Override
    public void deleteProductImageByProductId(Integer product_id) {
        List<ProductImage> productImages = productImageMapper.queryAllProductImageByProductId(product_id);
        for (int i = 0; i < productImages.size(); i++) {
            productImageMapper.deleteProductImageById(productImages.get(i).getId());
        }
    }

    @Override
    public int updateProductImage(ProductImage productImage) {
        return productImageMapper.updateProductImage(productImage);
    }

    @Override
    public ProductImage queryProductImageById(Integer id) {
        return productImageMapper.queryProductImageById(id);
    }

    @Override
    public List<ProductImage> queryAllProductImageByProductId(Integer product_id) {
        return productImageMapper.queryAllProductImageByProductId(product_id);
    }

}
