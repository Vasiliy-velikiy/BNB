package com.dataart.it.leaders.rest.api.model;

public class ServiceResponse {
    private String url;
    private Integer responseCode;

    public ServiceResponse(String url, Integer responseCode) {
        this.url = url;
        this.responseCode = responseCode;
    }

    public Integer getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }


}
