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
import org.springframework.http.MediaType;

/**
 * API tests for {@link org.reqlist.controller.ObjectiveController}
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
public class ObjectiveTest extends BaseTest {

    static final String RESOURCE = REST_PATH.concat("objective");
    static final String RESOURCE_ID = RESOURCE.concat("/{id}");

    @Test
    public void listProjectObjectives() throws Exception {
        mockMvc().perform(get(RESOURCE)
                .param("project", "10")
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIATYPE_JSON_UTF8))
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$[*]", hasSize( greaterThanOrEqualTo(1) )))
                .andExpect(jsonPath("$[*].id", allItems(isA(Integer.class))))
                .andExpect(jsonPath("$[*].title", allItems(notNullValue())))
                .andExpect(jsonPath("$[*].description", allItems(notNullValue())))
                .andExpect(jsonPath("$[*].registerDate", allItems(notNullValue())));
    }

    @Test
    public void getObjective() throws Exception {
        mockMvc().perform(get(RESOURCE_ID, 10)
                .contentType(MEDIATYPE_JSON_UTF8)
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIATYPE_JSON_UTF8))
                .andExpect(jsonPath("$.id", equalTo(10)))
                .andExpect(jsonPath("$.title", equalTo("Dominate the world")))
                .andExpect(jsonPath("$.description", equalTo("And a planet at choice")))
                .andExpect(jsonPath("$.registerDate", equalTo(calendar(1990, 10, 12).getTimeInMillis())));
    }

    @Test
    public void unkownObjective() throws Exception {
        mockMvc().perform(get(RESOURCE_ID, 999)
                .contentType(MEDIATYPE_JSON_UTF8)
        ).andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @Ignore
    public void saveObjective() throws Exception {
        mockMvc().perform(post(RESOURCE)
                .contentType(MEDIATYPE_JSON_UTF8)
                .content(getJson("objective/new-objective"))
        ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MEDIATYPE_JSON_UTF8))
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.id", allOf(notNullValue(), isA(Integer.class))))
                .andExpect(jsonPath("$.title", equalTo("Some objective")))
                .andExpect(jsonPath("$.description", equalTo("Some description")))
                .andExpect(jsonPath("$.registerDate", timestamp(sameDay(new Date()))));
    }

    @Test
    public void updateObjective() throws Exception {
        Date date = new Date(1425705726461L);
        
        mockMvc().perform(put(RESOURCE_ID, 11)
                .contentType(MEDIATYPE_JSON_UTF8)
                .content(getJson("objective/edit-objective"))
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIATYPE_JSON_UTF8))
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.id", equalTo(11)))
                .andExpect(jsonPath("$.title", equalTo("WHATEVS")))
                .andExpect(jsonPath("$.registerDate", timestamp(equalTo(date))));
    }

    @Test
    public void deleteUnknownObjective() throws Exception {
        mockMvc().perform(delete(RESOURCE_ID, 777)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void deleteObjective() throws Exception {
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
