package stu.wbw.mapper;

import stu.wbw.pojo.Review;

import java.util.List;

public interface ReviewMapper {
    //增加一条评价
    int addReview(Review review);
    //删除一条评价
    int deleteReviewById(Integer id);
    //修改一条评价
    int updateReview(Review review);
    //查询一条评价
    Review queryReviewById(Integer id);
    //查询所有评价
    List<Review> queryAllReview();
    //根据product_id查询该产品下的所有评价
    List<Review> queryReviewByProductId(Integer product_id);
    //根据product_id得到当产品下评价的数量
    int getReviewCount(int product_id);
}
