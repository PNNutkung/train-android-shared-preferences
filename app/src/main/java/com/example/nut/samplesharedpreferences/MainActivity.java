package com.example.nut.samplesharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_username)
    EditText mainUsername;
    @BindView(R.id.main_password)
    EditText mainPassword;
    @BindView(R.id.main_save_btn)
    Button mainSaveBtn;
    @BindView(R.id.main_display_btn)
    Button mainDisplayBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.main_save_btn, R.id.main_display_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_save_btn:
                SharedPreferences sharedPref = getSharedPreferences("USER_INFO", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("USERNAME", mainUsername.getText().toString());
                editor.putString("PASSWORD", mainPassword.getText().toString());
                editor.apply();

                Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();
                break;
            case R.id.main_display_btn:
                
                break;
        }
    }
}
