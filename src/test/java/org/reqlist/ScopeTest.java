package org.reqlist;

import java.util.Calendar;
import java.util.Date;
import static org.exparity.hamcrest.date.DateMatchers.sameDay;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import static org.reqlist.util.CustomMatchers.*;
import org.springframework.http.MediaType;

/**
 * API tests for {@link org.reqlist.controller.ScopeController}
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
public class ScopeTest extends BaseTest {

    static final String RESOURCE = REST_PATH.concat("scope");
    static final String RESOURCE_ID = RESOURCE.concat("/{id}");

    @Test
    public void listProjectScopes() throws Exception {
        mockMvc().perform(get(RESOURCE)
                .param("project", "10")
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIATYPE_JSON_UTF8))
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$[*]", hasSize(1)))
                .andExpect(jsonPath("$[*].id", allItems(notNullValue())))
                .andExpect(jsonPath("$[*].title", allItems(notNullValue())))
                .andExpect(jsonPath("$[*].registerDate", allItems(notNullValue())))
                .andExpect(jsonPath("$[*].active", allItems(anyOf(equalTo(true), equalTo(false)))));
    }

    @Test
    public void getScope() throws Exception {
        //1990-10-12 00:00:00
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(0);
        calendar.set(1990, 9, 12, 0, 0, 0);

        mockMvc().perform(get(RESOURCE_ID, 10)
                .contentType(MEDIATYPE_JSON_UTF8)
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIATYPE_JSON_UTF8))
                .andExpect(jsonPath("$.id", equalTo(10)))
                .andExpect(jsonPath("$.title", equalTo("v1.0")))
                .andExpect(jsonPath("$.registerDate", equalTo(calendar.getTimeInMillis())))
                .andExpect(jsonPath("$.active", equalTo(true)));
    }

    @Test
    public void unkownScope() throws Exception {
        mockMvc().perform(get(RESOURCE_ID, 999)
                .contentType(MEDIATYPE_JSON_UTF8)
        ).andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void saveScope() throws Exception {
        mockMvc().perform(post(RESOURCE)
                .contentType(MEDIATYPE_JSON_UTF8)
                .content(getJson("scope/new-scope"))
        ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MEDIATYPE_JSON_UTF8))
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.id", allOf(notNullValue(), isA(Integer.class))))
                .andExpect(jsonPath("$.title", equalTo("v1.1")))
                .andExpect(jsonPath("$.registerDate", timestamp(sameDay(new Date()))))
                .andExpect(jsonPath("$.active", equalTo(true)));
    }

    @Test
    public void updateScope() throws Exception {
        Date date = new Date(1425705726461L);
        
        mockMvc().perform(put(RESOURCE_ID, 11)
                .contentType(MEDIATYPE_JSON_UTF8)
                .content(getJson("scope/edit-scope"))
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIATYPE_JSON_UTF8))
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.id", equalTo(11)))
                .andExpect(jsonPath("$.title", equalTo("WHATEVS")))
                .andExpect(jsonPath("$.registerDate", timestamp(equalTo(date))))
                .andExpect(jsonPath("$.active", equalTo(false)));
    }

    @Test
    public void deleteUnknownScope() throws Exception {
        mockMvc().perform(delete(RESOURCE_ID, 777)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void deleteScope() throws Exception {
        mockMvc().perform(
            get(RESOURCE_ID, 666)
        ).andDo(print())
                .andExpect(status().isOk());

        mockMvc().perform(
            delete(RESOURCE_ID, 666)
        ).andDo(print())
                .andExpect(status().isNoContent())
                .andExpect(content().string(""));

        mockMvc().perform(
            get(RESOURCE_ID, 666)
        ).andDo(print())
                .andExpect(status().isNotFound());
    }

}
