package com.morepranit.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.morepranit.sqlitedemo.database.entities.User;

public class AddUserActivity extends AppCompatActivity {
    private EditText edtFirstName;
    private EditText edtLastName;
    private EditText edtMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        edtFirstName = findViewById(R.id.edt_first_name);
        edtLastName = findViewById(R.id.edt_last_name);
        edtMobile = findViewById(R.id.edt_mobile);
    }

    public void onSave(View view) {
        String firstName = edtFirstName.getText().toString();
        String lastName = edtLastName.getText().toString();
        Long mobile = Long.valueOf(edtMobile.getText().toString());

        User user = new User();
        user.firstName = firstName;
        user.lastName = lastName;
        user.mobile = mobile;

        AppController.getInstance().getDbInstance().userDao().insertAll(user);

        finish();
    }
}
