package com.escom.b074.amber.app.views.registry.bulletin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.escom.b074.amber.app.R;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AdittionalDataViewActivity extends AppCompatActivity implements Validator.ValidationListener {

    @NotEmpty
    @Bind(R.id.registry_bulletin_additional_data_nationality)
    EditText nationalityField;

    @NotEmpty
    @Bind(R.id.registry_bulletin_additional_data_eyes_colour)
    EditText eyesColourField;

    @NotEmpty
    @Bind(R.id.registry_bulletin_additional_data_hair_colour)
    EditText hairColourField;

    @NotEmpty
    @Bind(R.id.registry_bulletin_additional_data_height)
    EditText heightField;

    @Bind(R.id.registry_bulletin_additional_data_signs)
    EditText signsField;

    @NotEmpty
    @Bind(R.id.registry_bulletin_additional_data_skin_colour)
    EditText skinColour;

    @NotEmpty
    @Bind(R.id.registry_bulletin_additional_data_weight)
    EditText weightField;

    Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registry_bulletin_additional_data_viewl_layout);
        ButterKnife.bind(this);

        validator = new Validator(this);
        validator.setValidationListener(this);
    }

    @OnClick(R.id.registry_bulletin_additional_data_continue_button)
    public void submit() {
        validator.validate();
    }

    @Override
    public void onValidationSucceeded() {
        Intent intent = new Intent(this, SinisterDataViewActivity.class);
        startActivity(intent);
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {

    }
}
