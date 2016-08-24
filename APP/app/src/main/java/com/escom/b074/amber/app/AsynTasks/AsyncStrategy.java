package com.escom.b074.amber.app.AsynTasks;

/**
 * Created by miguelangelromerogutierrez on 09/08/16.
 */
public interface AsyncStrategy<T> {
    T execute();
    void handleResponse(T response);
    void handleError(String errorMessage);
}
