package com.example.tedliang.rxjavasample.rxjava.login;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.tedliang.rxjavasample.R;
import com.example.tedliang.rxjavasample.TextViewObSer;

/**
 * Created by tedliang on 9/18/14.
 */
public class NormalLogin extends Fragment {
    EditText userName;
    EditText password;
    Button btn;
    TextViewObSer userObservable;

    Boolean isUserNameValid = false;
    Boolean isPasswordValid = false;
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

        userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.length()>3){
                    isUserNameValid = true;
                    userName.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_action_accept, 0);
                    check();
                }else{
                    isUserNameValid = false;
                    userName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    check();
                }
            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})")){
                    isPasswordValid = true;
                    password.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_action_accept, 0);
                    check();
                }else{
                    isPasswordValid = false;
                    password.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    check();
                }
            }
        });
    }

    private void check() {
        Log.d("Ted","check "+isUserNameValid +" "+isPasswordValid);
        if(isUserNameValid && isPasswordValid){
            btn.setVisibility(View.VISIBLE);
        }else{
            btn.setVisibility(View.GONE);
        }
    }
}
