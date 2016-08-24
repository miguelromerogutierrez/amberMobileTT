package com.escom.b074.amber.app.presenters;

import android.content.Context;

import com.escom.b074.amber.app.AsynTasks.AsyncStrategy;
import com.escom.b074.amber.app.AsynTasks.HttpAsynTask;
import com.escom.b074.amber.app.AsynTasks.ResponseHandler;
import com.escom.b074.amber.app.model.form.ResponseMessageFormDto;
import com.escom.b074.amber.app.model.form.out.BulletinBasicDataFormDtoOut;
import com.escom.b074.amber.app.services.BulletinServices;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BulletinPresenterImpl implements BulletinPresenter {

    private BulletinServices mBulletinServices;

    @Inject
    public BulletinPresenterImpl ( BulletinServices bulletinServices) {
        this.mBulletinServices = bulletinServices;
    }

    @Override
    public void setBasicData(Context context, final ResponseHandler<String> responseHandler, final BulletinBasicDataFormDtoOut bulletinFormDto) {
        new HttpAsynTask<>(context, new AsyncStrategy<ResponseMessageFormDto>() {
            @Override
            public ResponseMessageFormDto execute() {
                return mBulletinServices.setBasicData(bulletinFormDto);
            }

            @Override
            public void handleResponse(ResponseMessageFormDto response) {
                responseHandler.onSuccess(response.getMessage());
            }

            @Override
            public void handleError(String errorMessage) {
                responseHandler.onError(errorMessage);
            }
        }).execute();
    }

}
