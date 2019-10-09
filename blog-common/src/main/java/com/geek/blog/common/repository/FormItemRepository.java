package com.geek.blog.common.repository;

import com.geek.blog.common.model.FormItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName FormItemRepository
 * @Description
 * @Author lrg
 * @Date 2019-10-08 19:23
 * @Version 1.0
 */
@Transactional
@Repository
public interface FormItemRepository extends JpaRepository<FormItem, String> {

    List<FormItem> findByFormIdOrderBySortAsc(String formid);

}
