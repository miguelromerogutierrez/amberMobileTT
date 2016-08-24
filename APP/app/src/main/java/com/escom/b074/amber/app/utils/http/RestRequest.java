package com.escom.b074.amber.app.utils.http;

import java.util.Map;

/**
 * Rest Request data to call rest services. RestRequestBuilder class will be
 * used to build these objects
 *
 *
 */
public class RestRequest {

    /**
     * Path of the resource that will be called
     */
    private String path;
    /**
     * type of content that is expected from servie
     */
    private String accept;
    /**
     * type of content that will be sent to the service
     */
    private String type;
    /**
     * Http method
     */
    private String httpMethod;
    /**
     * Timeout milliseconds
     */
    private Integer timeoutMilliseconds;
    /**
     * Data to be sent in body of the request
     */
    private Object requestData;
    /**
     * Base url of the server where services are located. If not set the default
     * configured one will be used
     */
    private String baseUrl = "https://www.wibe.com/mwib_mult_web_mwibpublicwebapp_02";
    /**
     * Identifier of current request. If not provided, a random generated one
     * will be used
     */
    private String requestId;

    private Map<String,String> data;

    private Map<String, String> params;

    /**
     * Atributos para ser enviados como headers
     */
    private Map<String, String> headerAttributes;

    RestRequest() {

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public Integer getTimeoutMilliseconds() {
        return timeoutMilliseconds;
    }

    public void setTimeoutMilliseconds(Integer timeoutMilliseconds) {
        this.timeoutMilliseconds = timeoutMilliseconds;
    }

    public Object getRequestData() {
        return requestData;
    }

    public void setRequestData(Object requestData) {
        this.requestData = requestData;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public Map<String, String> getHeaderAttributes() {
        return headerAttributes;
    }

    public void setHeaderAttributes(Map<String, String> headerAttributes) {
        this.headerAttributes = headerAttributes;
    }

/*    This class should not contain logic methods
    @Deprecated
    public String getParamsFormatted() {
        String formattedParams = "?";
        int i = 0;

        if (params != null) {
            for (String key : params.keySet()) {
                formattedParams += key + "=" + params.get(key);
                if (i < (params.size() - 1)) {
                    formattedParams += "&";
                }
                i++;
            }
        }
        return formattedParams;
    }*/
}
