package com.geek.blog.common.service;

import com.geek.blog.common.model.Form;
import com.geek.blog.common.repository.FormRepository;
import com.geek.blog.common.utils.IDUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName FormService
 * @Description
 * @Author lrg
 * @Date 2019-10-08 19:23
 * @Version 1.0
 */
@Service
@Slf4j
public class FormService {

    @Autowired
    private FormRepository formRepository;

    // 增加
    public void save(Form form) {
        if (StringUtils.isBlank(form.getId())) {
            form.setId(IDUtil.uuid());
            formRepository.save(form);
        }
    }

    //删除
    public void deleteById(String id) {
        formRepository.deleteById(id);
    }

    //查询全部
    public List<Form> findAll() {
        List<Form> formList = formRepository.findAll();
        return formList;
    }

    //查询单个
    public Form findById(String id) {
        Form form = formRepository.findById(id).get();
        return form;
    }

}
