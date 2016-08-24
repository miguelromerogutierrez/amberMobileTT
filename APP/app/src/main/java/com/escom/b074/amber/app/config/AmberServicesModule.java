package com.escom.b074.amber.app.config;

import com.escom.b074.amber.app.services.BulletinServices;
import com.escom.b074.amber.app.services.BulletinServicesImpl;
import com.escom.b074.amber.app.utils.http.AmberHttpClient;
import com.escom.b074.amber.app.utils.http.AmberHttpClientImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by miguelangelromerogutierrez on 22/08/16.
 */
@Module
public class AmberServicesModule {

    @Provides
    @Singleton
    public AmberHttpClient provideAmberHttpClient (Gson gson) {
        return new AmberHttpClientImpl(gson);
    }

    @Provides
    @Singleton
    public Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    public BulletinServices provideBulletinServices(AmberHttpClient amberHttpClient) {
        return new BulletinServicesImpl(amberHttpClient);
    }
}
