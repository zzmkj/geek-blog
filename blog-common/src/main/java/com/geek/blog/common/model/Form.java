package com.geek.blog.common.model;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;

/**
 * @ClassName Form
 * @Description 表单实体
 * @Author lrg
 * @Date 2019-10-08 19:08
 * @Version 1.0
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Form {

    @Id
    private String id;

    private String name; //名字

    @OneToMany(mappedBy = "form", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<FormItem> formItems;

    private String pid;

    private String userid;
}
