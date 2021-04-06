package stu.wbw.pojo;
//产品表
public class Product {
    //主键ID
    private Integer id;
    //产品名称
    private String name;
    //小标题
    private String sub_title;
    //产品价格
    private Float price;
    //销量
    private Integer sale;
    //库存
    private Integer stock;
    //对应分类ID
    private Integer category_id;
    //对应评价总数
    private Integer reviewCount;

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

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public Integer getSaleXReviewCount() {
        return this.reviewCount * this.sale;
    }
}
