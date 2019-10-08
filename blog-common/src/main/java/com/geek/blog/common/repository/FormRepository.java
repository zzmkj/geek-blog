package com.geek.blog.common.repository;

import com.geek.blog.common.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName FormRepository
 * @Description
 * @Author lrg
 * @Date 2019-10-08 19:22
 * @Version 1.0
 */
@Transactional
@Repository
public interface FormRepository extends JpaRepository<Form, String> {

}
