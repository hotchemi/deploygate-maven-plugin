package com.deploygate.maven.plugins;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Execute `mvn deploygate:upload` to call this mojo.
 *
 * @author Shintaro Katafuchi
 */
@SuppressWarnings("unchecked")
@Mojo(name = "upload")
public class UploadMojo extends AbstractMojo {

    @Parameter(property = "ownerName", required = true)
    private String ownerName;

    @Parameter(property = "token", required = true)
    private String token;

    @Parameter(property = "file", required = true)
    private String file;

    @Parameter(property = "message")
    private String message;

    @Parameter(property = "distributionKey")
    private String distributionKey;

    @Parameter(property = "releaseNote")
    private String releaseNote;

    @Override
    public void execute() throws MojoExecutionException {
        UploadExecutor.execute(new UploadInfo(ownerName, token, file, message, distributionKey, releaseNote));
    }

}