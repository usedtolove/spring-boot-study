package com.mycompany.study.web;

import com.mycompany.study.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Hu Jing Ling
 * Date: 2014-09-25
 */
@Controller
public class CustomerController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(){
        return "redirect:/index.jsp";
    }

    @RequestMapping(value = "/customers", method= RequestMethod.GET)
    @ResponseBody
    public List<Customer> list(){
        return getCustomers();
    }

    @RequestMapping(value = "/thymeleaf/customers", method= RequestMethod.GET)
    public String list2(Model model){
        model.addAttribute("customers", getCustomers());
        return "thymeleaf/customers";
    }

    @RequestMapping(value = "/jsp/customers", method= RequestMethod.GET)
    public String list3(Model model){
        model.addAttribute("customers", getCustomers());
        return "jsp/customers";
    }

    private List<Customer> getCustomers(){
        List<Customer> customerList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Customer customer = new Customer();
            customer.setId(i);
            customer.setName("customer_"+i);
            customer.setAge(25+i);
            customerList.add(customer);
        }
        return customerList;
    }

}
