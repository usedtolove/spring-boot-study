package com.mycompany.study.web;

import com.mycompany.study.dao.CustomerDao;
import com.mycompany.study.entity.Customer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: Hu Jing Ling
 * Date: 2014-09-25
 */
@RestController
public class CustomerController {

    @Resource
    private CustomerDao customerDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(){
        return "Hello World!";
    }

    @RequestMapping(value = "/customer/save")
    public String save(){
        Customer customer = new Customer();
        customer.setName("jack");
        customer.setAge(23);
//        customerDao.save(customer);
        return "/test.html";
    }

    @RequestMapping(value = "/customers/{id}")
    public Customer get(@PathVariable int id){
        Customer customer = customerDao.findOne(id);
        return customer;
    }

    @RequestMapping(value = "/customers", method= RequestMethod.GET)
    public List<Customer> list(){
        List<Customer> customerList = (List<Customer>) customerDao.findAll();
        return customerList;
    }
}
