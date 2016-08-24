package com.escom.b074.amber.app.utils.http;

import com.google.gson.Gson;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AmberHttpClientImpl implements AmberHttpClient {

    private Gson gson;
    Request request;
    OkHttpClient client;

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    @Inject
    public AmberHttpClientImpl(Gson oGson) {
        gson = oGson;
        client = new OkHttpClient();
    }

    @Override
    public<T> T invoke(RestRequest restRequest, Class<T> typeClass) throws IOException {
        gson = new Gson();
        Response response;
        String resBody = "";
//        if (restRequest.getHttpMethod().equals(HttpMethod.GET)) {
//             request = HttpRequest.get(restRequest.getBaseUrl() + restRequest.getPath(), restRequest.getParams(), true)
//                     .header("Content-Type", MimeType.APPLICATION_JSON).body();
//
//        } else if (restRequest.getHttpMethod().equals(HttpMethod.POST)) {
        String json = gson.toJson(restRequest.getRequestData());
            RequestBody body = RequestBody.create(JSON, json);
            request = new Request.Builder()
                    .url(restRequest.getBaseUrl() + restRequest.getPath())
                    .post(body)
                    .build();
            response = client.newCall(request).execute();
//        }
        resBody = response.body().string();
        return gson.fromJson(resBody, typeClass);
    }

}
