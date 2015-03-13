package org.reqlist.util;

import static org.hamcrest.Matchers.equalTo;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
public class HashTest {
    
    @Test
    public void testMd5() {
        String result = Hash.md5("");
        assertThat(result, equalTo("d41d8cd98f00b204e9800998ecf8427e"));
        
        result = Hash.md5("test");
        assertThat(result, equalTo("98f6bcd4621d373cade4e832627b4f6"));
    }
    
    @Test
    public void testSha1() {
        String result = Hash.sha1("");
        assertThat(result, equalTo("da39a3ee5e6b4b0d3255bfef95601890afd80709"));
        
        result = Hash.sha1("test");
        assertThat(result, equalTo("a94a8fe5ccb19ba61c4c0873d391e987982fbbd3"));
    }
    
}
