package com.mycompany.study;

import com.mycompany.study.dao.CustomerDao;
import com.mycompany.study.entity.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Test methods of CurdRepository
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
//@TransactionConfiguration(defaultRollback = true)
@Transactional//默认自动回滚
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCustomerDao1 {

    @Resource
    private CustomerDao customerDao;

    private Customer customer;

    @Before
    public void initCustomer(){
        customer = new Customer();
        customer.setName("some customer");
        customer.setAge(30);
    }

    @Test
    public void test1findOne() {
        customerDao.save(customer);
        Customer temp = customerDao.findOne(customer.getId());
        Assert.assertEquals(customer, temp);
    }

    //Returns all instances of the type.
    @Test
    public void test2findAll(){
        customerDao.save(customer);
        List<Customer> list = (List<Customer>) customerDao.findAll();
        Assert.assertEquals(true, list.size()>0);
    }

    @Test
    public void test3findAllByIds(){
        Set set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        List<Customer> list = (List<Customer>) customerDao.findAll(set);
        Assert.assertNotNull(list);//always true
    }

    @Test
    public void test4update(){
        customerDao.save(customer);
        Customer temp = customerDao.findOne(customer.getId());
        temp.setName("updated name");
        temp.setAge(temp.getAge()+1);
        customerDao.save(temp);
    }

    @Test
    public void test5delete(){
        customerDao.save(customer);
        customerDao.delete(customer.getId());
    }

}
