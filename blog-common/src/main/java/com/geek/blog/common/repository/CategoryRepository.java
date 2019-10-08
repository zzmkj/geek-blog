package com.geek.blog.common.repository;

import com.geek.blog.common.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName CategoryRepository
 * @Description TODO
 * @Author zzm
 * @Data 2019/9/27 19:25
 * @Version 1.0
 */
public interface CategoryRepository extends JpaRepository<Category, String> {
    List<Category> findByParentId(String parentId);

    List<Category> findByParentIdIn(List<String> ids);
}
