package stu.wbw.pojo;

//订单货物表
public class OrderItem {
    //主键ID
    private Integer id;
    //产品ID
    private Integer product_id;
    //订单ID
    private Integer order_id;
    //用户ID
    private Integer user_id;
    //对应产品购买数量
    private Integer number;
    //订单中对应的产品
    private Product product;

    //测试用
    /*@Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", order_id=" + order_id +
                ", user_id=" + user_id +
                ", number=" + number +
                ", product=" + product +
                '}';
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
