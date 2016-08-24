package com.escom.b074.amber.app.presenters;

import android.content.Context;

import com.escom.b074.amber.app.AsynTasks.ResponseHandler;
import com.escom.b074.amber.app.model.form.out.BulletinBasicDataFormDtoOut;

public interface BulletinPresenter {

    void setBasicData(Context context, final ResponseHandler<String> responseHandler, BulletinBasicDataFormDtoOut bulletinFormDto);

}
