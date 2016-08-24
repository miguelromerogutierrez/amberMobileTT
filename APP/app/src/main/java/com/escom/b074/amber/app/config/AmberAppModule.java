package com.escom.b074.amber.app.config;

import com.escom.b074.amber.app.presenters.BulletinPresenter;
import com.escom.b074.amber.app.presenters.BulletinPresenterImpl;
import com.escom.b074.amber.app.services.BulletinServicesImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by miguelangelromerogutierrez on 22/08/16.
 */
@Module
public class AmberAppModule {

    @Provides
    @Singleton
    public BulletinPresenter provideBulletinPresenter(BulletinServicesImpl bulletinServicesImpl) {
        return new BulletinPresenterImpl(bulletinServicesImpl);
    }

}
