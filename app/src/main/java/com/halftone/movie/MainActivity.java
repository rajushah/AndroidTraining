package com.halftone.movie;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout mTilUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTilUsername = findViewById(R.id.main_til_username);


        mTilUsername.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("MainActivity before", charSequence.toString());
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("MainActivity onText", charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                validateUserName(editable.toString());
            }
        });
    }

    private void validateUserName(String username) {
        if (TextUtils.isEmpty(username)) {
            mTilUsername.setError("enter a valid name");
        }
    }
}
