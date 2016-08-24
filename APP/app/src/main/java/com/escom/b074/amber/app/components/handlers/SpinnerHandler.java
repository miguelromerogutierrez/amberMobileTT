package com.escom.b074.amber.app.components.handlers;

import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SpinnerHandler<T> extends SelectableHandler<T> {

    private static final String HINT_DEFAULT = "Seleccionar";

    private CharSequence mHint = HINT_DEFAULT;
    private List<String> mStringValues;
    private ArrayAdapter<String> mAdapter;

    public SpinnerHandler(Spinner view, StringRenderable<T> stringRenderable, List<T> items, CharSequence hint) {
        super(view, stringRenderable, items);
        initView();
        mHint = hint;
        addHint();
        setItemSelecterListener();
    }

    public SpinnerHandler(Spinner view, StringRenderable<T> stringRenderable, List<T> items) {
        super(view, stringRenderable, items);
        initView();
        addHint();
        setItemSelecterListener();
    }

    @Override
    protected Spinner getView() {
        return (Spinner) super.getView();
    }

    @Override
    protected void initView() {


        mStringValues = new ArrayList<>();

        for (T item : items) {
            mStringValues.add(stringRenderable.toStringItem(item));
        }

        if (items.isEmpty()) {
            getView().setEnabled(false);
            mStringValues.add(" ");
        } else {
            getView().setEnabled(true);
        }

        mAdapter = new ArrayAdapter<String>(getView().getContext(), android.R.layout.simple_spinner_dropdown_item, mStringValues) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);
                if (position == getCount()) {
                    TextView t1 = (TextView)v.findViewById(android.R.id.text1);
//                    t1.setTextColor(getContext().getResources().getColor(R.color.text_color_hint));
                    t1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                    t1.setText(mHint);
                }
                return v;
            }

            @Override
            public int getCount() {
                return super.getCount()-1;
            }
        };

        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

//        getView().setBackgroundResource(R.drawable.new_generic_spinner);
    }

    @Override
    protected void updateViewWithSelectedItem(T newSelectedItem) {
        if (newSelectedItem != null) {
            String strItem = stringRenderable.toStringItem(newSelectedItem);
            int index = mStringValues.indexOf(strItem);
            if (index >= 0) {
                getView().setSelection(index);
            } else {
                getView().setSelection(mAdapter.getCount());
            }
        } else {
            getView().setSelection(mAdapter.getCount());
        }
    }

    private void addHint() {
        mStringValues.add(mHint.toString());
        mAdapter.notifyDataSetChanged();
        getView().setAdapter(mAdapter);
        getView().setSelection(mAdapter.getCount());
    }

    private void setItemSelecterListener () {
        getView().setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position < mAdapter.getCount()) {
                    updateSelectedItem(items.get(position));
                }
                setError(null);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void setError(String errorMessage) {
        if (errorMessage == null) {
//            getView().setBackgroundResource(R.drawable.new_generic_spinner);
        } else {
//            getView().setBackgroundResource(R.drawable.spinner_error_background);
        }
    }
}
