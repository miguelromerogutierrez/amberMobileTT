package com.escom.b074.amber.app.AsynTasks;

/**
 * Created by miguelangelromerogutierrez on 09/08/16.
 */
public class ResponseHolder<T> {
    private T response;
    private String errorMessage;

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
