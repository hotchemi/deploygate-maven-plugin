package com.deploygate.maven.plugins;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import static com.deploygate.maven.plugins.Utils.createHttpPost;

public class UploadExecutor {

    private static final Logger LOGGER = Logger.getLogger(UploadExecutor.class.getName());

    public static void execute(UploadInfo uploadInfo) {
        HttpPost httpPost = createHttpPost(uploadInfo);
        HttpResponse response = doPost(httpPost);
        HttpEntity entity = response.getEntity();
        try (InputStream is = entity.getContent()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            JSONObject json = new JSONObject(reader.readLine());
            log(uploadInfo.getFile().getName(), json);
        } catch (IOException e) {
            LOGGER.warning(e.getMessage());
        }
    }

    private static HttpResponse doPost(HttpPost httpPost) {
        try {
            return HttpClientBuilder.create().build().execute(httpPost);
        } catch (IOException e) {
            LOGGER.warning(e.getMessage());
        }
        return null;
    }

    private static void log(String apkName, JSONObject json) {
        if (json.getBoolean("error")) {
            LOGGER.warning(apkName + " error message:" + json.getString("message"));
        } else {
            LOGGER.info(apkName + " result:" + json.toString());
        }
    }

}