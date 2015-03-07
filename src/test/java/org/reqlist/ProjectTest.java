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
 * API tests for {@link org.reqlist.controller.ProjectController}
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
public class ProjectTest extends BaseTest {

    static final String RESOURCE = REST_PATH.concat("project");
    static final String RESOURCE_ID = RESOURCE.concat("/{id}");

    @Test
    public void listProjects() throws Exception {
        mockMvc().perform(get(RESOURCE)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$[*]", hasSize(greaterThan(1))))
                .andExpect(jsonPath("$[*].id", allItems(notNullValue())))
                .andExpect(jsonPath("$[*].name", allItems(notNullValue())))
                .andExpect(jsonPath("$[*].registerDate", allItems(notNullValue())))
                .andExpect(jsonPath("$[*].description", allItems(notNullValue())))
                .andExpect(jsonPath("$[*].active", allItems(anyOf(equalTo(true), equalTo(false)))));
    }

    @Test
    public void getProject() throws Exception {
        //1990-10-12 00:00:00
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(0);
        calendar.set(1990, 9, 12, 0, 0, 0);

        mockMvc().perform(get(RESOURCE_ID, 10)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(jsonPath("$.id", equalTo(10)))
                .andExpect(jsonPath("$.name", equalTo("Reqlist")))
                .andExpect(jsonPath("$.registerDate", equalTo(calendar.getTimeInMillis())))
                .andExpect(jsonPath("$.description", equalTo("Whatevs")))
                .andExpect(jsonPath("$.active", equalTo(true)));
    }

    @Test
    public void unkownProject() throws Exception {
        mockMvc().perform(get(RESOURCE_ID, 999)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void saveProject() throws Exception {
        mockMvc().perform(post(RESOURCE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(getJson("project/new-project"))
        ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.id", allOf(notNullValue(), isA(Integer.class), greaterThan(0))))
                .andExpect(jsonPath("$.name", equalTo("Reqlist")))
                .andExpect(jsonPath("$.description", nullValue()))
                .andExpect(jsonPath("$.registerDate", timestamp(sameDay(new Date()))))
                .andExpect(jsonPath("$.active", equalTo(true)));
    }

    @Test
    public void updateProject() throws Exception {
        Date date = new Date(1425705726461L);
        
        mockMvc().perform(put(RESOURCE_ID, 11)
                .contentType(MediaType.APPLICATION_JSON)
                .content(getJson("project/edit-project"))
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.id", allOf(notNullValue(), isA(Integer.class), equalTo(11))))
                .andExpect(jsonPath("$.name", equalTo("French Fries")))
                .andExpect(jsonPath("$.description", equalTo("Hellyeah")))
                .andExpect(jsonPath("$.registerDate", timestamp(equalTo(date))))
                .andExpect(jsonPath("$.active", equalTo(false)));
    }

    @Test
    public void deleteUnknownProject() throws Exception {
        mockMvc().perform(delete(RESOURCE_ID, 777)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void deleteProject() throws Exception {
        mockMvc().perform(get(RESOURCE_ID, 666)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isOk());

        mockMvc().perform(delete(RESOURCE_ID, 666)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isNoContent())
                .andExpect(content().string(""));

        mockMvc().perform(get(RESOURCE_ID, 666)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isNotFound());
    }

}
