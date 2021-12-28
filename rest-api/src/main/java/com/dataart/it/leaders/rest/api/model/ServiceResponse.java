package com.dataart.it.leaders.rest.api.model;
/**Класс содержит структуру ответа от вспомогающих вычислителей, когда к ним обращаются живой/не живой*/
public class ServiceResponse {
    private String url;
    private Integer responseCode;

    public ServiceResponse(String url, Integer responseCode) {
        this.url = url;
        this.responseCode = responseCode;
    }

    public String getUrl() {
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
