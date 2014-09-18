
package com.example.tedliang.rxjavasample;

import android.view.View;

public class ClickEvent {
    private View view;

    public ClickEvent(View v) {
        view = v;
    }

    public View getView() {
        return view;
    }
}