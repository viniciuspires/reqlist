package org.reqlist;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Calendar;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.reqlist.arch.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import org.reqlist.arch.MockMvcProvider;
import org.springframework.http.MediaType;

/**
 * Base test configuration and helpers
 * 
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@EnableWebMvc
@ContextConfiguration("classpath:META-INF/org.reqlist.test.xml")
public class BaseTest {
    
    @Autowired
    private MockMvcProvider mmp;
    
    protected Logger logger;
    protected static final String REST_PATH = "/";
    protected static final String TEST_RESOURCE_FOLDER = "src/test/resources/";
    protected static final String FILE_CHARSET = "UTF-8";
    
    protected static final MediaType MEDIATYPE_JSON_UTF8 = MediaType.parseMediaType("application/json;charset="+FILE_CHARSET);

    public BaseTest() {
        Mockito.mock(UserSession.class);
    }
    
    /**
     * Getter of the {@link MockMvc} shared configuration
     * @return 
     */
    protected MockMvc mockMvc() {
        return mmp.getInstance();
    }
    
    /**
     * Getter of the Logger
     * @return 
     */
    protected Logger logger() {
        if (logger == null) {
            logger = Logger.getLogger(getClass());
        }
        return logger;
    }
    
    /**
     * Returns the content of a JSON from the folder src/test/resources/json as text
     * 
     * e.g.: 
     * <br />
     * <b>Directory:</b>
     * <pre>
     * src/
     *  test/
     *   resources/
     *    json/
     *     my-module/
     *     - some-object.json
     * </pre>
     * 
     * <b>Código:</b>
     * <pre>
     * // json = "{ ... }"
     * String json = getJson("my-module/some-object");
     * </pre>
     * 
     * @param jsonName
     * @return The JSON's content
     */
    protected String getJson(String jsonName) {
        return  getTestResourceContent(String.format("json/%s.json", jsonName));
    }
    
    /**
     * Returns the content of a resource on the folder src/test/resources as text
     * 
     * e.g.:
     * 
     * <br />
     * 
     * <b>Directory:</b>
     * <pre>
     * src/
     *  test/
     *   resources/
     *    folder/
     *    - file.txt
     * </pre>
     * 
     * <b>Code:</b>
     * <pre>
     * String content = getTestResourceContent("folder/file.txt");
     * </pre>
     * 
     * @param fileName
     * @return The file's content
     */
    protected String getTestResourceContent(String fileName) {
        try {
            InputStream is = new FileInputStream(TEST_RESOURCE_FOLDER.concat(fileName));
            return IOUtils.toString(is, FILE_CHARSET);
        } catch (IOException ex) {
            logger().error("Error at retrieving the file "+fileName, ex);
        }
        return null;
    }
    
    /**
     * Returns an instance of a Calendar
     * @param year
     * @param month
     * @param day
     * @return 
     */
    protected Calendar calendar(final int year, final int month, final int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(0);
        calendar.set(year, month-1, day, 0, 0, 0);
        return calendar;
    }

    /**
     * Mantido apenas para execução do JUnit 
     */
    @Test
    public void baseTest() {}

}
