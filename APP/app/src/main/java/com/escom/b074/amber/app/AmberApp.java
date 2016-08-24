package com.escom.b074.amber.app;

import android.app.Application;
import android.content.Context;

import com.escom.b074.amber.app.config.AmberAppComponent;
import com.escom.b074.amber.app.config.AmberAppModule;
import com.escom.b074.amber.app.config.AmberServicesModule;
import com.escom.b074.amber.app.config.DaggerAmberAppComponent;


/**
 * Created by miguelangelromerogutierrez on 22/08/16.
 */
public class AmberApp extends Application {

    private AmberAppComponent component;

    public static AmberApp get(Context context) {
        return (AmberApp) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAmberAppComponent.builder()
                .amberAppModule(new AmberAppModule()).amberServicesModule(new AmberServicesModule()).build();
    }

    public AmberAppComponent amberComponent() {
        if (component == null) {
            component = DaggerAmberAppComponent.builder()
                    .amberAppModule(new AmberAppModule()).amberServicesModule(new AmberServicesModule()).build();
        }

        return component;
    }
}
