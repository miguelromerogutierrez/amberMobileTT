package com.escom.b074.amber.app.utils.http;

import java.io.IOException;

/**
 * Created by miguelangelromerogutierrez on 22/08/16.
 */
public interface AmberHttpClient {

    <T> T invoke(RestRequest restRequest, Class<T> typeClass) throws IOException;
}
