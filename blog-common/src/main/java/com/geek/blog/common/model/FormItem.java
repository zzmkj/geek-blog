package com.geek.blog.common.model;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;

/**
 * @ClassName FormItem
 * @Description 表单项实体
 * @Author lrg
 * @Date 2019-10-08 19:09
 * @Version 1.0
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class FormItem {

    @Id
    private String id;

    private String name; //名字

    private String type; //类型 （文本，单选，多选之类）

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private List<String> option; //可选项 -- 如果为单选或者多选时，的选项

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private List<String> result; //结果

    private Integer sort;

    @ManyToOne
    @JoinColumn(name = "pid")
    private Form form;

}
