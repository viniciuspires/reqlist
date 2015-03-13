/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.reqlist.util;

import java.util.Date;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
public class AssertUtilsTest {

    @Test
    public void testIsNull() {
        Object object = null;
        assertThat(AssertUtils.isNull(object), is(true));
        assertThat(AssertUtils.isNull(null), is(true));
        
        object = new Object();
        assertThat(AssertUtils.isNull(object), is(false));
        assertThat(AssertUtils.isNull(new Date()), is(false));
    }

    @Test
    public void testIsNotNull() {
        Object object = null;
        assertThat(AssertUtils.isNotNull(object), is(false));
        assertThat(AssertUtils.isNotNull(null), is(false));
        
        object = new Object();
        assertThat(AssertUtils.isNotNull(object), is(true));
        assertThat(AssertUtils.isNotNull(new Date()), is(true));
    }
    
}
