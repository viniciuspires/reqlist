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
import org.reqlist.enumerated.RoleEnum;

/**
 * API tests for {@link org.reqlist.controller.UserController}
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
public class UserTest extends BaseTest {

    static final String RESOURCE = REST_PATH.concat("user");
    static final String RESOURCE_ID = RESOURCE.concat("/{id}");
    static final String RESOURCE_AVATAR = RESOURCE_ID.concat(".png");

    /**
     * @throws Exception
     */
    @Test
    public void listProjectUsers() throws Exception {
        mockMvc().perform(get(RESOURCE)
                .param("project", "10")
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIATYPE_JSON_UTF8))
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$[*]", hasSize(greaterThan(0))))
                .andExpect(jsonPath("$[*].role", allItems(anyOf(
                                                equalTo(RoleEnum.ADMIN.name()),
                                                equalTo(RoleEnum.DEVELOPER.name()),
                                                equalTo(RoleEnum.CUSTOMER.name())
                                        ))))
                .andExpect(jsonPath("$[*].user", allItems(notNullValue())))
                .andExpect(jsonPath("$[*].user.id", allItems(isA(Integer.class))))
                .andExpect(jsonPath("$[*].user.name", allItems(not(isEmptyOrNullString()))))
                .andExpect(jsonPath("$[*].user.email", allItems(not(isEmptyOrNullString()))))
                .andExpect(jsonPath("$[*].user.avatar", allItems(not(isEmptyOrNullString()))))
                .andExpect(jsonPath("$[*].user.password", allItems(nullValue())))
                .andExpect(jsonPath("$[*].user.registerDate", allItems(timestamp(sameDay(date(1990, 10, 12))))))
                .andExpect(jsonPath("$[*].user.confirmed", allItems(anyOf(
                                                equalTo(true),
                                                equalTo(false)
                                        ))))
                .andExpect(jsonPath("$[*].project", allItems(notNullValue())))
                .andExpect(jsonPath("$[*].project.id", allItems(equalTo(10))))
                .andExpect(jsonPath("$[*].project.name", allItems(not(isEmptyOrNullString()))))
                .andExpect(jsonPath("$[*].project.description", allItems(notNullValue())))
                .andExpect(jsonPath("$[*].project.registerDate", allItems(timestamp(sameDay(date(1990, 10, 12))))))
                .andExpect(jsonPath("$[*].project.active", allItems(anyOf(
                                                equalTo(true),
                                                equalTo(false)
                                        ))));
    }

    @Test
    public void getUser() throws Exception {
        mockMvc().perform(get(RESOURCE_ID, 10)
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIATYPE_JSON_UTF8))
                .andExpect(jsonPath("$.id", equalTo(10)))
                .andExpect(jsonPath("$.name", equalTo("Vinicius")))
                .andExpect(jsonPath("$.email", equalTo("vinicius.costa.pires@gmail.com")))
                .andExpect(jsonPath("$.avatar", equalTo("https://gravatar.com/avatar/6bb8d259b6b46a59ec66aadbd2b13015?size=400")))
                .andExpect(jsonPath("$.password", nullValue()))
                .andExpect(jsonPath("$.registerDate", timestamp(sameDay(date(1990, 10, 12)))))
                .andExpect(jsonPath("$.confirmed", equalTo(true)));
    }

    @Test
    public void unkownUser() throws Exception {
        mockMvc().perform(get(RESOURCE_ID, 999)
        ).andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void saveUser() throws Exception {
        mockMvc().perform(post(RESOURCE)
                .contentType(MEDIATYPE_JSON_UTF8)
                .content(getJson("user/new-user"))
        ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MEDIATYPE_JSON_UTF8))
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.id", isA(Integer.class)))
                .andExpect(jsonPath("$.name", equalTo("Somebody")))
                .andExpect(jsonPath("$.email", equalTo("somebody@ydobemos.com")))
                .andExpect(jsonPath("$.password", nullValue()))
                .andExpect(jsonPath("$.registerDate", timestamp(sameDay(new Date()))))
                .andExpect(jsonPath("$.confirmed", equalTo(false)));
    }

    /**
     * FIXME {@link ReqlistExceptionHandler} is not intercepting
     * javax.validation.ConstraintViolationException and translating to a JSON
     * Array. Discover why and solve that.
     *
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
                .andExpect(jsonPath("$", is(true)));
    }

    @Test
    public void updateUser() throws Exception {
        Date date = new Date(1425705726461L);

        mockMvc().perform(put(RESOURCE_ID, 11)
                .contentType(MEDIATYPE_JSON_UTF8)
                .content(getJson("user/edit-user"))
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MEDIATYPE_JSON_UTF8))
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.id", equalTo(11)))
                .andExpect(jsonPath("$.name", equalTo("Somebody")))
                .andExpect(jsonPath("$.email", equalTo("somebody@ydobemos.com")))
                .andExpect(jsonPath("$.avatar", equalTo("https://gravatar.com/avatar/35d179c0fcd4e906c5de959c1d9891ae?size=400")))
                .andExpect(jsonPath("$.password", nullValue()))
                .andExpect(jsonPath("$.registerDate", timestamp(sameDay(date))))
                .andExpect(jsonPath("$.confirmed", equalTo(true)));
    }

    @Test
    public void deleteUnknownUser() throws Exception {
        mockMvc().perform(delete(RESOURCE_ID, 777)
        ).andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void deleteUser() throws Exception {
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
