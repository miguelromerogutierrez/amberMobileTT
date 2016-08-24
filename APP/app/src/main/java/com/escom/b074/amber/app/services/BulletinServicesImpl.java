package com.escom.b074.amber.app.services;


import com.escom.b074.amber.app.model.form.ResponseMessageFormDto;
import com.escom.b074.amber.app.model.form.out.BulletinBasicDataFormDtoOut;
import com.escom.b074.amber.app.utils.http.AmberHttpClient;
import com.escom.b074.amber.app.utils.http.RestRequest;
import com.escom.b074.amber.app.utils.http.RestRequestBuilder;

import java.io.IOException;

import javax.inject.Inject;

public class BulletinServicesImpl implements BulletinServices {

    private final String URL_BASE = "/api/bulletins";
    private final String BASIC_DATA_PATH = URL_BASE + "/add/data/basic";
    private AmberHttpClient httpClient;

    @Inject
    public BulletinServicesImpl(AmberHttpClient amberHttpClient) {
        httpClient = amberHttpClient;
    }

    @Override
    public ResponseMessageFormDto setBasicData(BulletinBasicDataFormDtoOut bulletinFormDto) {
        RestRequest restRequest = new RestRequestBuilder().forJSON().invokePOST().withPath(BASIC_DATA_PATH).withRequestData(bulletinFormDto).create();
        try {
            ResponseMessageFormDto defaultFormDtoOut = httpClient.invoke(restRequest, ResponseMessageFormDto.class);
            return defaultFormDtoOut;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
