package com.halftone.movie;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.halftone.FragmentActivity;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout mTilUsername;
    private TextInputLayout mTilPassword;
    private Button mSubmit;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Movie");

        //SignUpActivity.start(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.d("menu item", "click");
                Snackbar.make(findViewById(R.id.container), "toolbar back item pressed", Snackbar.LENGTH_SHORT).show();
                return true;
            }
        });


        mTilUsername = findViewById(R.id.main_til_username);
        mTilPassword = findViewById(R.id.main_til_password);


        mTilUsername.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                validate();
                validateUsername(editable.toString());
            }
        });


        mTilPassword.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                validate();
                validatePassword(editable.toString());
            }
        });


        mSubmit = findViewById(R.id.main_btn_login);

        FragmentActivity.start(this);
    }

    public boolean validateUsername(String name) {
        boolean valid = true;
        if (TextUtils.isEmpty(name)) {
            mTilUsername.getEditText().setError("enter valid username");
            valid = false;
        }
        return valid;
    }

    public boolean validatePassword(String password) {
        boolean valid = true;
        if (TextUtils.isEmpty(password)) {
            mTilPassword.getEditText().setError("enter valid password");
            valid = false;
        }
        return valid;
    }

    public static void main(String[] args) {
        System.out.print("hello world");
    }


    public void validate() {
        boolean validUser = validateUsername(mTilUsername.getEditText().toString().trim()) && validatePassword(mTilPassword.getEditText().toString().trim());
        mSubmit.setEnabled(validUser);
        mSubmit.setBackgroundColor(validUser ? getResources().getColor(R.color.accent) : getResources().getColor(R.color.primary_light));
    }

    private void controlButton(boolean valid) {
        mSubmit.setEnabled(valid);

    }

    private void validateUserName(String username) {
        if (TextUtils.isEmpty(username)) {
            mTilUsername.setError("enter a valid name");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
