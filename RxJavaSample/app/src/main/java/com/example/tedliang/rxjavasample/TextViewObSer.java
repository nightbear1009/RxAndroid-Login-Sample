package com.example.tedliang.rxjavasample;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

/**
 * Created by tedliang on 9/17/14.
 */
public class TextViewObSer {

//    BehaviorSubject<String> subject;
    public BehaviorSubject<String> create(TextView view){
        String currentText = view.getText().toString();
        final BehaviorSubject<String>  subject = BehaviorSubject.create(currentText);
        view.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) { }

            @Override public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) { }

            @Override public void afterTextChanged(Editable editable) {
                subject.onNext(editable.toString());
            }
        });
        return subject;
    }

    public static Observable<Object> click(View view) {
        final PublishSubject<Object> subject = PublishSubject.create();
        view.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                subject.onNext(new Object());
            }
        });
        return subject;
    }

}
