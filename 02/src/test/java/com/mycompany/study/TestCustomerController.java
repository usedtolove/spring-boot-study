package com.mycompany.study;

import com.mycompany.study.entity.Customer;
import com.mycompany.study.web.CustomerController;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;

import static org.mockito.Mockito.when;

/**
 * Created by Administrator on 2014/10/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
//@SpringApplicationConfiguration
public class TestCustomerController {

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
    public void test1FromRepository() throws Exception {
        MockMvcBuilders.standaloneSetup(customerController)
                        .build()
                        .perform(MockMvcRequestBuilders.get("/customers/{id}", 1))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.content().contentType(MyMediaType.APPLICATION_JSON_UTF8))
                        .andExpect(MockMvcResultMatchers.jsonPath("id", Matchers.is(1)))
                        .andExpect(MockMvcResultMatchers.jsonPath("name", Matchers.is("Lindsey Craft")))
                        .andExpect(MockMvcResultMatchers.jsonPath("age", Matchers.is(26)));
//              .andExpect(MockMvcResultMatchers.content().string("{\"id\":1,\"name\":\"Lindsey Craft\",\"age\":26}"));
    }

    @Test
    public void test2ByMockito() throws Exception {
        Customer mockCustomer = new Customer();
        mockCustomer.setId(101);
        mockCustomer.setName("mock");
        mockCustomer.setAge(1);

        CustomerController mockController = Mockito.mock(CustomerController.class);

        //http://mockito.org/
        //http://code.google.com/p/mockito/
        when(mockController.get(1)).thenReturn(mockCustomer);

        MockMvcBuilders.standaloneSetup(mockController)// test the AccountsController class in isolation
                .build()
                .perform(MockMvcRequestBuilders.get("/customers/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MyMediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("id", Matchers.is(101)))
                .andExpect(MockMvcResultMatchers.jsonPath("name", Matchers.is("mock")))
                .andExpect(MockMvcResultMatchers.jsonPath("age", Matchers.is(1)));
    }

}
