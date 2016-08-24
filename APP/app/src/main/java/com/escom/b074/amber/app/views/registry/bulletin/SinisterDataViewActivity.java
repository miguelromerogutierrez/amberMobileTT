package com.escom.b074.amber.app.views.registry.bulletin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.escom.b074.amber.app.R;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by miguelangelromerogutierrez on 16/08/16.
 */
public class SinisterDataViewActivity extends AppCompatActivity implements Validator.ValidationListener {

    @Bind(R.id.registry_bulletin_sinister_data_facts_date)
    EditText factsDateField;

    @Bind(R.id.registry_bulletin_sinister_data_facts_place)
    EditText factsPlaceField;

    Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registry_bulletin_sinister_data_view_layout);
        ButterKnife.bind(this);

        validator = new Validator(this);
        validator.setValidationListener(this);
    }

    @OnClick(R.id.registry_bulletin_sinister_data_continue_button)
    public void submit() {
        validator.validate();
    }

    @Override
    public void onValidationSucceeded() {

    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {

    }
}
