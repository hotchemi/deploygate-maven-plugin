package com.deploygate.maven.plugins;

import org.junit.Test;

import java.io.File;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class UploadInfoTest {

    @Test
    public void uploadInfoTest() {
        {
            UploadInfo uploadInfo = new UploadInfo("ownerName", "token", "file", "message", "distributionKey", "releaseNote");
            assertThat(uploadInfo.getOwnerName(), is("ownerName"));
            assertThat(uploadInfo.getToken(), is("token"));
            assertThat(uploadInfo.getFile(), is(new File("file")));
            assertThat(uploadInfo.getMessage(), is("message"));
            assertThat(uploadInfo.getDistributionKey(), is("distributionKey"));
            assertThat(uploadInfo.getReleaseNote(), is("releaseNote"));

            Map<String, String> optionalParams = uploadInfo.getOptionalParams();
            assertTrue(optionalParams.containsKey("message"));
            assertTrue(optionalParams.containsKey("distribution_key"));
            assertTrue(optionalParams.containsKey("release_note"));
        }
        {
            UploadInfo uploadInfo = new UploadInfo("ownerName", "token", "file", null, null, null);
            Map<String, String> optionalParams = uploadInfo.getOptionalParams();
            assertFalse(optionalParams.containsKey("message"));
            assertFalse(optionalParams.containsKey("distribution_key"));
            assertFalse(optionalParams.containsKey("release_note"));
         }
    }


}
