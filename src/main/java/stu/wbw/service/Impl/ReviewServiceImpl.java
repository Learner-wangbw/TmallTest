package stu.wbw.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.wbw.mapper.ReviewMapper;
import stu.wbw.pojo.Review;
import stu.wbw.pojo.User;
import stu.wbw.service.ReviewService;
import stu.wbw.service.UserService;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewMapper reviewMapper;
    @Autowired
    UserService userService;

    @Override
    public int addReview(Review review) {
        return reviewMapper.addReview(review);
    }

    @Override
    public int deleteReviewById(Integer id) {
        return reviewMapper.deleteReviewById(id);
    }

    @Override
    public int updateReview(Review review) {
        return reviewMapper.updateReview(review);
    }

    @Override
    public Review queryReviewById(Integer id) {
        return reviewMapper.queryReviewById(id);
    }

    @Override
    public List<Review> queryAllReview() {
        return reviewMapper.queryAllReview();
    }

    @Override
    public List<Review> queryReviewByProductId(Integer product_id) {
        List<Review> reviews = reviewMapper.queryReviewByProductId(product_id);
        setUser(reviews);
        return reviews;
    }
    private void setUser(Review review){
        int user_id = review.getUser_id();
        User user = userService.queryUserById(user_id);
        review.setUser(user);
    }
    private void setUser(List<Review> reviews){
        for (Review review : reviews) {
            setUser(review);
        }
    }

    @Override
    public int getReviewCount(int product_id) {
        return reviewMapper.getReviewCount(product_id);
    }
}
