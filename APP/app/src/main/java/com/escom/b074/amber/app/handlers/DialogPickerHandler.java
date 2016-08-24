package com.escom.b074.amber.app.handlers;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class DialogPickerHandler {

//    TODO: refactor this method to return a DatePickerDialog builder
    public static DatePickerDialog createDatePicker (final Context context, final Calendar calendar, final EditText input) {

        input.setKeyListener(null);

        DatePickerDialog datePickerDialog = new DatePickerDialog(context, createOnDateSetListener(calendar, input), calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        DialogPickerHandler.setInputLauncherOnClickListener(context, input, datePickerDialog);
        DialogPickerHandler.setInputLauncherOnFocusChangeListener(context, input, datePickerDialog);

        return datePickerDialog;
    }

    private static void setInputLauncherOnClickListener (final Context context, final EditText inputLauncher, final AlertDialog alertLanched) {
        inputLauncher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KeyboardHandler.hideKeyboard(context, inputLauncher);

                if (!alertLanched.isShowing()) {
                    alertLanched.show();
                }
            }
        });
    }

    private static void setInputLauncherOnFocusChangeListener (final Context context, final EditText inputLauncher, final AlertDialog alertLanched) {
        inputLauncher.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                KeyboardHandler.hideKeyboard(context, inputLauncher);

                if (hasFocus && view.isEnabled() && !(alertLanched.isShowing())) {
                    alertLanched.show();
                }
            }
        });
    }

    private static DatePickerDialog.OnDateSetListener createOnDateSetListener (final Calendar calendar, final EditText input) {
        DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
            {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateDate(calendar, input);
            }
        };
        return onDateSetListener;
    }

    private static void updateDate(final Calendar calendar, final EditText input){
        input.setError(null);
        input.setText(DateHandler.getStringDateRepresentation(calendar.getTime()));
    }
}
