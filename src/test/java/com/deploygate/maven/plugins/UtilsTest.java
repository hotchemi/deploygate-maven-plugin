package com.deploygate.maven.plugins;

import org.apache.http.entity.mime.content.StringBody;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for {@link com.deploygate.maven.plugins.Utils}.
 */
public class UtilsTest {

    @Test
    public void isNotNullOrEmptyTest() {
        assertFalse(Utils.isNotNullOrEmpty(null));
        assertFalse(Utils.isNotNullOrEmpty(""));
        assertTrue(Utils.isNotNullOrEmpty("test"));
    }

    @Test
    public void createContentBodyTest() {
        StringBody contentBody = Utils.createContentBody("test");
        assertThat(contentBody.getMediaType(), is("text"));
        assertThat(contentBody.getContentLength(), is((long) 4));
        assertNull(contentBody.getFilename());
    }

}
