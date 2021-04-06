package stu.wbw.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.wbw.mapper.ProductMapper;
import stu.wbw.pojo.Category;
import stu.wbw.pojo.Product;
import stu.wbw.service.ProductImageService;
import stu.wbw.service.ProductService;
import stu.wbw.service.ReviewService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Autowired
    ReviewService reviewService;

    @Autowired
    ProductImageService productImageService;

    @Override
    public int addProduct(Product product) {
        return productMapper.addProduct(product);
    }

    @Override
    public int deleteProduct(Integer id) {
        productImageService.deleteProductImageByProductId(id);
        return productMapper.deleteProduct(id);
    }

    @Override
    public int updateProduct(Product product) {
        return productMapper.updateProduct(product);
    }

    @Override
    public Product queryProductById(Integer id) {
        return productMapper.queryProductById(id);
    }

    @Override
    public List<Product> queryAllProduct() {
        return productMapper.queryAllProduct();
    }

    @Override
    public List<Product> queryAllProductByCategoryId(Integer category_id) {
        List<Product> products = productMapper.queryAllProductByCategoryId(category_id);
        return products;
    }

    @Override
    public void fill(List<Category> categories) {
        for (Category category : categories) {
            fill(category);
        }
    }

    @Override
    public void fill(Category category) {
        List<Product> products = queryAllProductByCategoryId(category.getId());
        category.setProducts(products);
    }

    @Override
    public void fillByRow(List<Category> categories) {
        int productNumberOfEachRow = 8;
        for (Category category : categories) {
            List<Product> products = category.getProducts();
            List<List<Product>> productByRow =  new ArrayList<>();
            for (int i = 0; i < products.size(); i+=productNumberOfEachRow) {
                int size = i + productNumberOfEachRow;
                size = size >products.size() ? products.size() : size;
                List<Product> productsOfEachRow = products.subList(i, size);
                productByRow.add(productsOfEachRow);
            }
            category.setProductByRow(productByRow);
        }
    }

    @Override
    public void setReviewCount(Product product) {
        int reviewCount = reviewService.getReviewCount(product.getId());
        product.setReviewCount(reviewCount);
    }

    @Override
    public List<Product> search(String keyword) {
        //若在数据库中添加%%存在sql注入的危险
        keyword = "%"+keyword+"%";
        return productMapper.search(keyword);
    }
}
