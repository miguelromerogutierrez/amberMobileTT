package com.escom.b074.amber.app.components.handlers;

import android.view.View;

import java.util.List;

public abstract class SelectableHandler<T> {

    private final View view;
    protected final StringRenderable<T> stringRenderable;
    protected final List<T> items;
    protected T selectedItem;
    protected OnItemSelectedListener<T> onItemSelectedListener;

    protected SelectableHandler(final View view, final StringRenderable<T> stringRenderable, final List<T> items) {
        this.view = view;
        this.stringRenderable = stringRenderable;
        this.items = items;
    }

    protected abstract void initView();

    protected abstract void updateViewWithSelectedItem(T newSelectedItem);

    protected View getView() {
        return view;
    }

    protected void updateSelectedItem(T newSelectedItem) {
        this.selectedItem = newSelectedItem;

        if (onItemSelectedListener != null) {
            updateViewWithSelectedItem(newSelectedItem);
            onItemSelectedListener.onItemSelected(newSelectedItem);
        }
    }

    public T getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(T selectedItem) {
        updateViewWithSelectedItem(selectedItem);
        this.selectedItem = selectedItem;
    }

    public OnItemSelectedListener getOnItemSelectedListener() {
        return onItemSelectedListener;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener<T> onItemSelectedListener) {
        this.onItemSelectedListener = onItemSelectedListener;
    }

    public interface OnItemSelectedListener<T> {
        void onItemSelected(T item);
    }
}
