/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.reqlist.test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Vinicius
 */
@Ignore
public class TestProjeto {

    /*@Override
    protected Application configure() {
        //return new ResourceConfig(ProjetoResource.class);
        return null;
    }*/
    
    @Test
    public void test(){
        //final String hello = target("projeto").request().get(String.class);
        //assertEquals("Hello World!", hello);
        assertThat(true, is(true));
    }
}
