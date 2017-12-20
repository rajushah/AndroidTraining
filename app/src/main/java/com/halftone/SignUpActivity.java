package com.halftone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.halftone.movie.DashboardActivity;
import com.halftone.movie.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpActivity extends AppCompatActivity {

    TextInputLayout mTilUsername, mTilAddress, mTilPhone, mTilProfession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mTilUsername = findViewById(R.id.sign_up_til_username);
        mTilAddress = findViewById(R.id.sign_up_til_address);
        mTilPhone = findViewById(R.id.sign_up_til_phone);
        mTilProfession = findViewById(R.id.sign_up_til_profession);

        findViewById(R.id.sign_up_btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User user = new User();
                user.username = mTilUsername.getEditText().getText().toString();
                user.address = mTilAddress.getEditText().getText().toString();
                user.phone = mTilPhone.getEditText().getText().toString();
                user.profession = mTilProfession.getEditText().toString();

                signup(user);
            }
        });
    }

    private void signup(User user) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://demo4323830.mockable.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GithubService service = retrofit.create(GithubService.class);
        service.signup(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                DashboardActivity.start(SignUpActivity.this);
                Toast.makeText(SignUpActivity.this, "Signup success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

    }


    public static void start(Context context) {
        Intent starter = new Intent(context, SignUpActivity.class);
        context.startActivity(starter);
    }
}
