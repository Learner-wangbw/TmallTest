package stu.wbw.pojo;

import java.util.List;

//类别表
public class Category {
    //主键ID
    private Integer id;
    //类别名
    private String name;
    //产品列表
    private List<Product> products;
    //一行产品
    private List<List<Product>> productByRow;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<List<Product>> getProductByRow() {
        return productByRow;
    }

    public void setProductByRow(List<List<Product>> productByRow) {
        this.productByRow = productByRow;
    }
}
