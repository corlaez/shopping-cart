package com.cesarmando.website.adapter.restapi.GitHub;

import lombok.Data;

/**
 * Created by jarma on 4/11/2017.
 */
@Data
public class Repo {
    private String name;
    private String description;
    private String url;
    private Boolean _private;
    private Boolean fork;
    private String createdAt;
    private String updatedAt;
    private String cloneUrl;
    private Boolean hasIssues;
    private Boolean hasWiki;
    private Integer forksCount;
    private Integer openIssuesCount;
}
