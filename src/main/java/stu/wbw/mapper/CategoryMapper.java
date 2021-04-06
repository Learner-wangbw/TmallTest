package stu.wbw.mapper;

import stu.wbw.pojo.Category;

import java.util.List;

public interface CategoryMapper {
    //增加一个分类
    int addCategory(Category category);
    //删除一个分类
    int deleteCategoryById(Integer id);
    //修改一个分类
    int updateCategory(Category category);
    //根据id查询一个分类
    Category queryCategoryById(Integer id);
    //查询所有分类
    List<Category> queryAllCategory();


}
