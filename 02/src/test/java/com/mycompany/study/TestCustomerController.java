package com.mycompany.study;

import com.mycompany.study.dao.CustomerDao;
import com.mycompany.study.entity.Customer;
import com.mycompany.study.web.CustomerController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Created by Administrator on 2014/10/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
//@SpringApplicationConfiguration
public class TestCustomerController {

    @Resource
    private CustomerDao customerDao;
    @Resource
    private CustomerController customerController;

    private MockMvc mockMvc;//from Spring Test and sets up the Mock container.

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(customerController)// test the AccountsController class in isolation
                .build();
    }

    @Test
    public void test1get(){
    }

    @Test
    public void testLoginView() throws Exception {

        //http://javasee.iteye.com/blog/1000868
        //https://www.jiwhiz.com/#/blogs/5352ebb8352eb40d58180a55
        when(customerDao.findOne(1)).thenReturn(customerDao.findOne(1));

        MvcResult result = mockMvc.perform(get("/customers/{id}",1))
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.view().name("accounts/login"))
//                .andExpect(MockMvcResultMatchers.forwardedUrl("accounts/login"))
                .andReturn();
        result.getResponse().getContentAsString();
        Assert.assertNotNull(result);
    }

}
