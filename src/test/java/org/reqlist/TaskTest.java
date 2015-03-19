package org.reqlist;

import java.util.Date;
import static org.exparity.hamcrest.date.DateMatchers.sameDay;
import static org.hamcrest.Matchers.*;
import org.junit.Ignore;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import static org.reqlist.arch.CustomMatchers.*;
import org.reqlist.arch.ReqlistExceptionHandler;

/**
 * API tests for {@link org.reqlist.controller.TaskController}
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
public class TaskTest extends BaseTest {

    static final String RESOURCE = REST_PATH.concat("task");
    static final String RESOURCE_ID = RESOURCE.concat("/{id}");

    @Test
    public void listScopeTasks() throws Exception {
        mockMvc().perform(get(RESOURCE)
                .param("scope", "10")
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIATYPE_JSON_UTF8))
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$[*]", hasSize(greaterThanOrEqualTo(1))))
                .andExpect(jsonPath("$[*].id", allItems(isA(Integer.class))))
                .andExpect(jsonPath("$[*].title", allItems(notNullValue())))
                .andExpect(jsonPath("$[*].description", allItems(notNullValue())))
                .andExpect(jsonPath("$[*].registerDate", allItems(notNullValue())))
                .andExpect(jsonPath("$[*].done", allItems(anyOf(equalTo(true), equalTo(false)))));
    }

    @Test
    public void getTask() throws Exception {
        mockMvc().perform(get(RESOURCE_ID, 10)
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIATYPE_JSON_UTF8))
                .andExpect(jsonPath("$.id", equalTo(10)))
                .andExpect(jsonPath("$.title", equalTo("Must be awesome")))
                .andExpect(jsonPath("$.description", equalTo("In a awesome way")))
                .andExpect(jsonPath("$.registerDate", equalTo(calendar(1990, 10, 12).getTimeInMillis())))
                .andExpect(jsonPath("$.done", equalTo(false)))
                .andExpect(jsonPath("$.user", nullValue()))
                .andExpect(jsonPath("$.delivery", nullValue()));
    }

    @Test
    public void unkownTask() throws Exception {
        mockMvc().perform(get(RESOURCE_ID, 999)
        ).andDo(print())
                .andExpect(status().isNotFound());
    }
    
    @Test
    public void saveTask() throws Exception {
        mockMvc().perform(post(RESOURCE)
                .contentType(MEDIATYPE_JSON_UTF8)
                .content(getJson("task/new-task"))
        ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MEDIATYPE_JSON_UTF8))
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.id", allOf(notNullValue(), isA(Integer.class))))
                .andExpect(jsonPath("$.title", equalTo("Some task")))
                .andExpect(jsonPath("$.description", equalTo("Some description")))
                .andExpect(jsonPath("$.registerDate", timestamp(sameDay(new Date()))));
    }

    /**
     * FIXME {@link ReqlistExceptionHandler} is not intercepting
     * javax.validation.ConstraintViolationException and translating to a JSON Array.
     * Discover why and solve that.
     * @throws Exception 
     */
    @Test
    @Ignore
    public void validationErrorOnSave() throws Exception {
        mockMvc().perform(post(RESOURCE)
                .contentType(MEDIATYPE_JSON_UTF8)
                .content("{}")
        ).andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MEDIATYPE_JSON_UTF8))
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$", is(true)))
                ;
    }

    @Test
    public void updateTask() throws Exception {
        Date date = new Date(1425705726461L);

        mockMvc().perform(put(RESOURCE_ID, 11)
                .contentType(MEDIATYPE_JSON_UTF8)
                .content(getJson("task/edit-task"))
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIATYPE_JSON_UTF8))
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.id", equalTo(11)))
                .andExpect(jsonPath("$.title", equalTo("WHATEVS")))
                .andExpect(jsonPath("$.registerDate", timestamp(equalTo(date))));
    }

    @Test
    public void deleteUnknownTask() throws Exception {
        mockMvc().perform(delete(RESOURCE_ID, 777)
        ).andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void deleteTask() throws Exception {
        mockMvc().perform(get(RESOURCE_ID, 666)
        ).andDo(print())
                .andExpect(status().isOk());

        mockMvc().perform(delete(RESOURCE_ID, 666)
        ).andDo(print())
                .andExpect(status().isNoContent())
                .andExpect(content().string(""));

        mockMvc().perform(get(RESOURCE_ID, 666)
        ).andDo(print())
                .andExpect(status().isNotFound());
    }

}
