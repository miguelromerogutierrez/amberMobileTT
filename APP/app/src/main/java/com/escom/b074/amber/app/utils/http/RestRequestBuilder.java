package com.escom.b074.amber.app.utils.http;

import com.escom.b074.amber.app.utils.http.constants.HttpMethod;
import com.escom.b074.amber.app.utils.http.constants.MimeType;

import java.util.Map;

/**
 * Builder for RestRequest objects. Offers simple DSL for easy http requests
 * building
 *
 */
public class RestRequestBuilder {

    private String path;
    private String accept;
    private String type;
    private String httpMethod;
    private Integer timeoutMilliseconds;

    private Object requestData;
    private Map<String, String> params;


     private String baseUrl = "http://192.168.0.23:8080/AlertAmberTT";

    private String requestId;

    private Map<String, String> headerAttributes;


    public String getBaseUrl() {
        return  baseUrl;
    }

    /**
     * Xml will be sent (if apply) and received in this request
     *
     * @return RestRequestBuilder
     */
    public RestRequestBuilder forXML() {
        type = MimeType.APPLICATION_XML;
        accept = MimeType.APPLICATION_XML;
        return this;
    }

    /**
     * Json will be sent (if apply) and received in this request
     *
     * @return RestRequestBuilder
     */
    public RestRequestBuilder forJSON() {
        type = MimeType.APPLICATION_JSON;
        accept = MimeType.APPLICATION_JSON;
        return this;
    }

    /**
     * Multipart form data will be sent and JSON received in this request
     * <p/>
     * RequestData must be a file or input stream
     *
     * @return RestRequestBuilder
     */
    public RestRequestBuilder forMultipart() {
        type = MimeType.MULTIPART_FORM_DATA;
        accept = MimeType.APPLICATION_JSON;

        return this;
    }

    public RestRequestBuilder forFormUrlEncoded() {
        type = MimeType.FORM_URL_ENCODED;
        accept = MimeType.APPLICATION_JSON;
        return this;
    }

    public RestRequestBuilder forPDFUrlEncoded() {
        type = MimeType.FORM_URL_ENCODED;
        accept = MimeType.APPLICATION_PDF;
        return this;
    }

    /**
     * Http method GET will be used in this request
     *
     * @return RestRequestBuilder
     */
    public RestRequestBuilder invokeGET() {
        httpMethod = HttpMethod.GET;

        return this;
    }

    /**
     * Http method POST will be used in this request
     *
     * @return RestRequestBuilder
     */
    public RestRequestBuilder invokePOST() {
        httpMethod = HttpMethod.POST;

        return this;
    }

    /**
     * Http method DELETE will be used in this request
     *
     * @return RestRequestBuilder
     */
    public RestRequestBuilder invokeDELETE() {
        httpMethod = HttpMethod.DELETE;

        return this;
    }

    /**
     * Http method PUT will be used in this request
     *
     * @return RestRequestBuilder
     */

    public RestRequestBuilder invokePUT() {
        httpMethod = HttpMethod.PUT;

        return this;
    }

    /**
     * Timeout milliseconds before throw a timeout exception
     *
     * @param timeoutMilliseconds
     */
    public RestRequestBuilder withTimeout(final Integer timeoutMilliseconds) {
        this.timeoutMilliseconds = timeoutMilliseconds;
        return this;
    }

    /**
     * Sets the path of the resource to be accessed
     *
     * @param path path of the resource
     */
    public RestRequestBuilder withPath(final String path) {
        this.path = path;
        return this;
    }

    /**
     * Sets the request data that will be sent in service invocation
     *
     * @param requestData data to be sent to service
     */
    public RestRequestBuilder withRequestData(final Object requestData) {
        this.requestData = requestData;

        return this;
    }

    /**
     * Sets the params data that will be sent in service invocation
     *
     * @param params data to be sent to service
     */
    public RestRequestBuilder withParams(final Map<String, String> params) {
        this.params = params;
        return this;
    }

    /**
     * Set the base url where services are located. If not provided default
     * configured one will be used
     *
     * @param baseUrl base url where services are located
     */
    public RestRequestBuilder useBaseUrl(final String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    /**
     * Sets request it for tracing purposes. If not provided a random generated
     * one is used
     *
     * @param requestId id of current request
     */
    public RestRequestBuilder withRequestId(final String requestId) {
        this.requestId = requestId;

        return this;
    }

    /**
     * Sets header attributes to be sent to service
     *
     * @param headerAttributes
     * @return
     */
    public RestRequestBuilder withHeaderAttributes(final Map<String, String> headerAttributes) {
        this.headerAttributes = headerAttributes;

        return this;
    }

    /**
     * Creates a RestRequest object accoding to data provided
     *
     * @return RestRequest rest request - @see RestRequest
     */
    public RestRequest create() {
        final RestRequest restRequest = new RestRequest();
        restRequest.setAccept(accept);
        restRequest.setType(type);
        restRequest.setPath(path);
        restRequest.setRequestData(requestData);
        restRequest.setHttpMethod(httpMethod);
        restRequest.setTimeoutMilliseconds(timeoutMilliseconds);
        restRequest.setBaseUrl(baseUrl);
        restRequest.setRequestId(requestId);
        restRequest.setHeaderAttributes(headerAttributes);
        restRequest.setData(params);
        restRequest.setParams(params);

        return restRequest;
    }

}
