package com.escom.b074.amber.app.config;

import com.escom.b074.amber.app.views.registry.bulletin.BasicDataViewActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by miguelangelromerogutierrez on 22/08/16.
 */
@Singleton
@Component(modules = {AmberAppModule.class, AmberServicesModule.class})
public interface AmberAppComponent {
    void inject(BasicDataViewActivity activity);
}
