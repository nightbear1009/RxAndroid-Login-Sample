package com.example.tedliang.rxjavasample.rxjava.login;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.tedliang.rxjavasample.R;
import com.example.tedliang.rxjavasample.TextViewObSer;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;

/**
 * Created by tedliang on 9/18/14.
 */
public class RxFragment extends Fragment {
    EditText userName;
    EditText password;
    Button btn;
    TextViewObSer userObservable;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my,container,false);

        userObservable = new TextViewObSer();
        userName = (EditText) view.findViewById(R.id.username);
        password = (EditText) view.findViewById(R.id.password);
        btn = (Button) view.findViewById(R.id.signin);
        btn.setVisibility(View.GONE);
        init();
        return view;
    }

    private void init() {
        final BehaviorSubject<String> u = userObservable.create(userName);
        Observable<Boolean> userNameValidSignal = u.map(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return s.length()>3;
            }
        });

        userNameValidSignal.subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                if(aBoolean) {
                    userName.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_action_accept, 0);
                }else{
                    userName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }
            }
        });

        final BehaviorSubject<String> p = userObservable.create(password);
        Observable<Boolean> passwordValidSignal = p.map(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return s.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");
            }
        });

        passwordValidSignal.subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                if(aBoolean) {
                    password.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_action_accept, 0);
                }else{
                    password.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }
            }
        });

        Observable.combineLatest(userNameValidSignal,passwordValidSignal,new Func2<Boolean, Boolean, Boolean>() {
            @Override
            public Boolean call(Boolean aBoolean, Boolean aBoolean2) {
                return aBoolean && aBoolean2;
            }
        }).subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean o) {
                if(o){
                    btn.setVisibility(View.VISIBLE);
                }else{
                    btn.setVisibility(View.GONE);
                }
            }
        });
    }
}
