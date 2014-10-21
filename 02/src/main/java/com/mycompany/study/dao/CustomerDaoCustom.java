package com.mycompany.study.dao;

import com.mycompany.study.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * User: Hu Jing Ling
 * Date: 2014-10-21
 * Spring Data JPA 不支持的方法，可以自定义扩展
 */
public interface CustomerDaoCustom {

    /**
     * 根据属性名，属性值查询
     * @param prop 属性名
     * @param value 属性值
     * @return 符合条件的 Customer list 集合
     */
    List<Customer> getByProp(String prop, Object value);

}
