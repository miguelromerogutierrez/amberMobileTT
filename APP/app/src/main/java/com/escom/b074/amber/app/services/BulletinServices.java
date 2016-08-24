package com.escom.b074.amber.app.services;

import com.escom.b074.amber.app.model.form.ResponseMessageFormDto;
import com.escom.b074.amber.app.model.form.out.BulletinBasicDataFormDtoOut;


public interface BulletinServices {
    ResponseMessageFormDto setBasicData(BulletinBasicDataFormDtoOut bulletinFormDto);
}
