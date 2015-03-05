package org.reqlist.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@Component
public class MockMvcProvider {
    @Autowired
    private WebApplicationContext wac;
    
    private MockMvc mockMvc;

    public MockMvc getInstance() {
        if ( mockMvc == null ) {
            mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        }
        return mockMvc;
    }
}
