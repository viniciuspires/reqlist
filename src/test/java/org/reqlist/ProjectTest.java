package org.reqlist;

import java.util.Calendar;
import static org.hamcrest.Matchers.*;
import org.junit.Ignore;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import static org.reqlist.util.CustomMatchers.*;
import org.springframework.http.MediaType;

/**
 * API tests of {@link org.reqlist.controller.ProjectController}
 * 
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
public class ProjectTest extends BaseTest {
    static final String RESOURCE = REST_PATH.concat("project");
    static final String RESOURCE_ID = RESOURCE.concat("/{id}");
    
    @Test
    public void sucessoBuscarAplicacoes() throws Exception {
        mockMvc().perform(get(RESOURCE)
            .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
            .andExpect(jsonPath("$", notNullValue()))
            .andExpect(jsonPath("$[*]", hasSize(greaterThan(1))))
            .andExpect(jsonPath("$[*].id", todosOsItens(notNullValue())))
            .andExpect(jsonPath("$[*].nome", todosOsItens(notNullValue())))
            .andExpect(jsonPath("$[*].data", todosOsItens(notNullValue())))
            .andExpect(jsonPath("$[*].descricao", todosOsItens(notNullValue())))
            .andExpect(jsonPath("$[*].status", todosOsItens(notNullValue())));
    }
    
    @Test
    public void sucessoBuscarAplicacaoPorID() throws Exception {
        //1990-10-12 00:00:00
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(0);
        calendar.set(1990, 9, 12, 0, 0, 0);
        
        mockMvc().perform(get(RESOURCE_ID, 1)
            .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
            .andExpect(jsonPath("$", notNullValue()))
            .andExpect(jsonPath("$.id", allOf(notNullValue(), equalTo(1))))
            .andExpect(jsonPath("$.nome", allOf(notNullValue(), equalTo("Reqlist"))))
            .andExpect(jsonPath("$.data", allOf(notNullValue(), equalTo(calendar.getTimeInMillis()) )))
            .andExpect(jsonPath("$.descricao", allOf(notNullValue(), equalTo("Teste descrição"))))
            .andExpect(jsonPath("$.status", allOf(notNullValue(), equalTo(1))));
    }
    
    @Test
    @Ignore
    public void sucessoSalvarAplicacao() throws Exception {
        mockMvc().perform(post(RESOURCE)
            .contentType(MediaType.APPLICATION_JSON)
            .content(getJson("project/new-project"))
        ).andDo(print())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$", notNullValue()))
            .andExpect(jsonPath("$.id", allOf(notNullValue(), isA(Integer.class), greaterThan(0))));
    }
    
    @Test
    @Ignore
    public void sucessoAlterarAplicacao() throws Exception {
        mockMvc().perform(put(RESOURCE_ID, 1)
            .contentType(MediaType.APPLICATION_JSON)
            .content(getJson("project/edit-project"))
        ).andDo(print())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", notNullValue()))
            .andExpect(jsonPath("$.id", allOf(notNullValue(), isA(Integer.class), equalTo(1))));
    }
    
    @Test
    @Ignore
    public void sucessoExcluirAplicacao() throws Exception {
        mockMvc().perform(delete(RESOURCE_ID, 99)
            .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
            .andExpect(status().isNoContent())
            .andExpect(content().string(""));
    }
    
}
