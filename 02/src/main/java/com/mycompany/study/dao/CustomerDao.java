package com.mycompany.study.dao;

import com.mycompany.study.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * User: Hu Jing Ling
 * Date: 2014-10-20
 */
//developer write repository interfaces,
// including custom finder methods,
// and Spring will provide the implementation automatically.
//see : https://github.com/spring-projects/spring-data-jpa-examples
//API : http://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
public interface CustomerDao extends CrudRepository<Customer,Integer>, CustomerDaoCustom {

    //根据getBy后面的属性名查询
    List<Customer> getByName(String name);

    //根据query语句查询
    @Query(value = "select c from Customer c where c.age > :age")
    List<Customer> getByMinAge(@Param("age") int minAge);

}
