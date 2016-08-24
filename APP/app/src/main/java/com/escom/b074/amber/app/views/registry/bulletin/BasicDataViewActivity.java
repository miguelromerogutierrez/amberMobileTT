package com.escom.b074.amber.app.views.registry.bulletin;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.escom.b074.amber.app.R;
import com.escom.b074.amber.app.AmberApp;
import com.escom.b074.amber.app.AsynTasks.ResponseHandler;
import com.escom.b074.amber.app.components.handlers.SpinnerHandler;
import com.escom.b074.amber.app.components.handlers.StringRenderable;
import com.escom.b074.amber.app.handlers.DateHandler;
import com.escom.b074.amber.app.handlers.DialogPickerHandler;
import com.escom.b074.amber.app.model.enums.GenderEnum;
import com.escom.b074.amber.app.model.form.out.BulletinBasicDataFormDtoOut;
import com.escom.b074.amber.app.presenters.BulletinPresenter;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Select;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BasicDataViewActivity extends AppCompatActivity implements Validator.ValidationListener {

    @Inject
    protected BulletinPresenter presenter;

    // view elements
    @NotEmpty
    @Bind(R.id.registry_bulletin_basic_data_name_field)
    EditText nameField;

    @NotEmpty
    @Bind(R.id.registry_bulletin_basic_data_last_name_field)
    EditText lastNameField;

    @NotEmpty
    @Bind(R.id.registry_bulletin_basic_data_last_second_name_field)
    EditText lastSecondNameField;

    @NotEmpty
    @Bind(R.id.registry_bulletin_basic_data_birthday_field)
    EditText birthdayField;

    @NotEmpty
    @Bind(R.id.registry_bulletin_basic_data_age_field)
    EditText ageField;

    @Select
    @Bind(R.id.registry_bulletin_basic_data_gender_field)
    Spinner genderField;

    // validations variables
    Validator validator;

    // utils variables
    private Calendar birthdayCalendar = Calendar.getInstance();

    private SpinnerHandler<GenderEnum> genderSpinnerHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AmberApp.get(this).amberComponent().inject(this);
        setContentView(R.layout.registry_bulletin_basic_data_view_layout);
        ButterKnife.bind(this);
        validator = new Validator(this);
        validator.setValidationListener(this);

        List<GenderEnum> genders = new ArrayList<>();

        genders.add(GenderEnum.NONE);
        genders.add(GenderEnum.FEMALE);
        genders.add(GenderEnum.MALE);

        setBirthdayFieldDatePicker();
        genderSpinnerHandler = new SpinnerHandler<>(genderField, new StringRenderable<GenderEnum>() {
            @Override
            public String toStringItem(GenderEnum item) {
                return item.equals(GenderEnum.NONE)
                        ? "seleccionar"
                        : item.equals(GenderEnum.FEMALE)
                            ? "mujer"
                            : "hombre";
            }
        }, genders);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @OnClick(R.id.registry_bulletin_basic_data_continue_button)
    public void submit(View v) {
        validator.validate();
    }


    @Override
    public void onValidationSucceeded() {
        BulletinBasicDataFormDtoOut bulletinFormDto = new BulletinBasicDataFormDtoOut();

        bulletinFormDto.setName(nameField.getText().toString());
        bulletinFormDto.setLastName(lastNameField.getText().toString());
        bulletinFormDto.setSecondLastName(lastSecondNameField.getText().toString());
        bulletinFormDto.setBirthday(DateHandler.getDateFromString(birthdayField.getText().toString()).getTime());
        bulletinFormDto.setAge(ageField.getText().toString());
        bulletinFormDto.setGender(genderSpinnerHandler.getSelectedItem());

        presenter.setBasicData(this, new ResponseHandler<String>() {
            @Override
            public void onSuccess(String response) {
                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(BasicDataViewActivity.this, AdittionalDataViewActivity.class);
                startActivity(intent);
            }

            @Override
            public void onError(String errorMessage) {
                Toast.makeText(BasicDataViewActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        }, bulletinFormDto);
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
    }

    private void setBirthdayFieldDatePicker () {
        DatePickerDialog datePickerDialog = DialogPickerHandler.createDatePicker(this, birthdayCalendar, birthdayField);
        datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
    }

}
