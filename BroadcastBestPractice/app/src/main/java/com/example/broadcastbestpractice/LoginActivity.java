package com.example.broadcastbestpractice;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.prefs.PreferenceChangeEvent;

public class LoginActivity extends BaseActivity {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;

    private CheckBox rememberPsd;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        accountEdit = (EditText) findViewById(R.id.account);
        passwordEdit = (EditText) findViewById(R.id.password);
        rememberPsd = (CheckBox) findViewById(R.id.remember_psd);
        login = (Button)findViewById(R.id.login);
        boolean isRemember = pref.getBoolean("remember_psd", false);
        if (isRemember){
            String account = pref.getString("account", "");
            String psd = pref.getString("password", "");
            accountEdit.setText(account);
            passwordEdit.setText(psd);
            rememberPsd.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if(account.equals("admin") && password.equals("123456")){
                    editor = pref.edit();
                    if(rememberPsd.isChecked()){
                        editor.putBoolean("remember_psd", true);
                        editor.putString("account", account);
                        editor.putString("password", password);
                    } else {
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "account or password is invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
