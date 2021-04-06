package stu.wbw.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.wbw.mapper.CategoryMapper;
import stu.wbw.pojo.Category;
import stu.wbw.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public int addCategory(Category category) {
        return categoryMapper.addCategory(category);
    }

    @Override
    public int deleteCategoryById(Integer id) {
        return categoryMapper.deleteCategoryById(id);
    }

    @Override
    public int updateCategory(Category category) {
        return categoryMapper.updateCategory(category);
    }

    @Override
    public Category queryCategoryById(Integer id) {
        return categoryMapper.queryCategoryById(id);
    }

    @Override
    public List<Category> queryAllCategory() {
        return categoryMapper.queryAllCategory();
    }
}
