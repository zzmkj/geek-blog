package com.geek.blog.common.service;

import com.geek.blog.common.BO.CategoryBO;
import com.geek.blog.common.model.Category;
import com.geek.blog.common.repository.CategoryRepository;
import com.geek.blog.common.utils.BeanNullUtil;
import com.geek.blog.common.utils.IDUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @ClassName CategoryService
 * @Description TODO
 * @Author zzm
 * @Data 2019/9/27 19:26
 * @Version 1.0
 */
@Slf4j
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void save(CategoryBO categoryBO) {
        categoryBO.setId(IDUtil.uuid());
        categoryBO.setChildren(false);

        //如果是子节点，给父节点设置children属性
        if (!StringUtils.equals(categoryBO.getParentId(), "0")){
            Category parentCategory = findById(categoryBO.getParentId());
            if (!parentCategory.getChildren()){
                parentCategory.setChildren(true);
                categoryRepository.save(parentCategory);
            }
        }

        Category category = new Category();
        //copy
        BeanUtils.copyProperties(categoryBO, category, BeanNullUtil.getNullPropertyNames(categoryBO));

        categoryRepository.save(category);
    }

    public Category findById(String id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("分类不存在"));
    }

    public void deleteById(String id) {

        //判断删除后，父节点是否还有子节点，如果没有，则设置children属性为false
        Category category = findById(id);
        categoryRepository.deleteById(id);
        List<Category> parentCategorys = findByParentId(category.getParentId());
        if (CollectionUtils.isEmpty(parentCategorys)) {
            Category parentCategory = findById(category.getParentId());
            parentCategory.setChildren(false);
            categoryRepository.save(parentCategory);
        }
    }

    public void update(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> findByParentId(String parentId) {
        return categoryRepository.findByParentId(parentId);
    }

}
