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
import org.reqlist.enumerated.RequirementTypeEnum;

/**
 * API tests for {@link org.reqlist.controller.RequirementController}
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
public class RequirementTest extends BaseTest {

    static final String RESOURCE = REST_PATH.concat("requirement");
    static final String RESOURCE_ID = RESOURCE.concat("/{id}");

    @Test
    public void listScopeRequirements() throws Exception {
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
                .andExpect(jsonPath("$[*].registerDate", allItems(notNullValue())));
    }

    @Test
    public void getRequirement() throws Exception {
        mockMvc().perform(get(RESOURCE_ID, 10)
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIATYPE_JSON_UTF8))
                .andExpect(jsonPath("$.id", equalTo(10)))
                .andExpect(jsonPath("$.title", equalTo("Must be awesome")))
                .andExpect(jsonPath("$.description", equalTo("In a awesome way")))
                .andExpect(jsonPath("$.registerDate", equalTo(calendar(1990, 10, 12).getTimeInMillis())))
                .andExpect(jsonPath("$.type", equalTo(RequirementTypeEnum.FUNCTIONAL.name())))
                .andExpect(jsonPath("$.active", equalTo(true)))
                .andExpect(jsonPath("$.user", nullValue()))
                .andExpect(jsonPath("$.project", nullValue()));
    }

    @Test
    public void unkownRequirement() throws Exception {
        mockMvc().perform(get(RESOURCE_ID, 999)
        ).andDo(print())
                .andExpect(status().isNotFound());
    }
    
    @Test
    @Ignore
    public void saveRequirement() throws Exception {
        mockMvc().perform(post(RESOURCE)
                .contentType(MEDIATYPE_JSON_UTF8)
                .content(getJson("requirement/new-requirement"))
        ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MEDIATYPE_JSON_UTF8))
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.id", allOf(notNullValue(), isA(Integer.class))))
                .andExpect(jsonPath("$.title", equalTo("Some requirement")))
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
    public void updateRequirement() throws Exception {
        Date date = new Date(1425705726461L);

        mockMvc().perform(put(RESOURCE_ID, 11)
                .contentType(MEDIATYPE_JSON_UTF8)
                .content(getJson("requirement/edit-requirement"))
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIATYPE_JSON_UTF8))
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.id", equalTo(11)))
                .andExpect(jsonPath("$.title", equalTo("WHATEVS")))
                .andExpect(jsonPath("$.registerDate", timestamp(equalTo(date))));
    }

    @Test
    public void deleteUnknownRequirement() throws Exception {
        mockMvc().perform(delete(RESOURCE_ID, 777)
        ).andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void deleteRequirement() throws Exception {
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
