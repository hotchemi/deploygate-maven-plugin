package com.deploygate.maven.plugins;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;

import java.io.File;
import java.util.Map;

final class Utils {

    private static final String END_POINT = "https://deploygate.com/api/users/%s/apps";

    private Utils() {
    }

    static boolean isNotNullOrEmpty(final String text) {
        return text != null && !text.equals("");
    }

    static StringBody createContentBody(final String text) {
        return new StringBody(text, ContentType.DEFAULT_TEXT);
    }

    static FileBody createFileBody(final File file) {
        return new FileBody(file.getAbsoluteFile());
    }

    static HttpEntity createHttpEntity(UploadInfo uploadInfo) {
        MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
        entityBuilder.addPart("token", createContentBody(uploadInfo.getToken()));
        entityBuilder.addPart("file", createFileBody(uploadInfo.getFile()));
        entityBuilder.addPart("token", createContentBody(uploadInfo.getToken()));
        Map<String, String> optionalParams = uploadInfo.getOptionalParams();
        for (Map.Entry<String, String> entry : optionalParams.entrySet()) {
            entityBuilder.addPart(entry.getKey(), createContentBody(entry.getValue()));
        }
        return entityBuilder.build();
    }

    static HttpPost createHttpPost(UploadInfo uploadInfo) {
        String uri = String.format(END_POINT, uploadInfo.getOwnerName());
        HttpPost httpPost = new HttpPost(uri);
        httpPost.setEntity(createHttpEntity(uploadInfo));
        return httpPost;
    }

}