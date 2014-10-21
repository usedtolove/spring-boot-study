package com.mycompany.study;

import com.mycompany.study.dao.CustomerDao;
import com.mycompany.study.entity.Customer;
import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Test methods of CustomerDao
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@TransactionConfiguration(defaultRollback = false)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCustomerDao2 {

    @Resource
    private CustomerDao customerDao;

    @Test
    public void test0initCustomer(){
        System.out.println("TestCustomerDao2 initCustomer()...");
        DataFactory df = new DataFactory();

        List<Customer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Customer customer = new Customer();
            customer.setName(df.getName());
            customer.setAge(df.getNumberBetween(20,70));
            list.add(customer);
        }

        customerDao.save(list);
    }

    @Test
    public void test1() {
        List<Customer> list = customerDao.getByName("Lindsey Craft");
        Assert.assertNotNull(list);
    }

    @Test
    public void test2() {
        List<Customer> list = customerDao.getByMinAge(68);
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void test3() {
        List<Customer> list = customerDao.getByProp("name", "Lindsey Craft");
        Assert.assertTrue(list.size()>0);
    }



}
