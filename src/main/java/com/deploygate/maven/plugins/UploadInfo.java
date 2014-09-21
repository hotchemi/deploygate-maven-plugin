package com.deploygate.maven.plugins;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static com.deploygate.maven.plugins.Utils.isNotNullOrEmpty;

final class UploadInfo {

    public UploadInfo(String ownerName, String token, String file, String message, String distributionKey, String releaseNote) {
        this.ownerName = ownerName;
        this.token = token;
        this.file = new File(file);
        this.message = message;
        this.distributionKey = distributionKey;
        this.releaseNote = releaseNote;
    }

    private String ownerName;

    private String token;

    private File file;

    private String message;

    private String distributionKey;

    private String releaseNote;

    public String getOwnerName() {
        return ownerName;
    }

    public String getToken() {
        return token;
    }

    public File getFile() {
        return file;
    }

    public String getMessage() {
        return message;
    }

    public String getDistributionKey() {
        return distributionKey;
    }

    public String getReleaseNote() {
        return releaseNote;
    }

    public Map<String, String> getOptionalParams() {
        Map<String, String> params = new HashMap<>();
        if (isNotNullOrEmpty(message)) {
            params.put("message", getMessage());
        }
        if (isNotNullOrEmpty(distributionKey)) {
            params.put("distribution_key", getDistributionKey());
        }
        if (isNotNullOrEmpty(releaseNote)) {
            params.put("release_note", getReleaseNote());
        }
        return params;
    }

}