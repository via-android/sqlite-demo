package com.morepranit.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.morepranit.sqlitedemo.adapters.UserAdapter;
import com.morepranit.sqlitedemo.database.entities.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lvUsers;
    private ArrayList<User> users;
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvUsers = findViewById(R.id.lv_users);
        users = new ArrayList<>();
        adapter = new UserAdapter(this, users);
        lvUsers.setAdapter(adapter);

        getUsers();
    }

    private void getUsers() {
        users.addAll(AppController.getInstance().getDbInstance().userDao().getAll());
        adapter.notifyDataSetChanged();
    }

    public void onAddUser(View view) {
        Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        users.clear();
        getUsers();
    }
}
