package com.escom.b074.amber.app.AsynTasks;

/**
 * Created by miguelangelromerogutierrez on 09/08/16.
 */
public interface ResponseHandler<T> {
    void onSuccess(T response);
    void onError(String errorMessage);
}
