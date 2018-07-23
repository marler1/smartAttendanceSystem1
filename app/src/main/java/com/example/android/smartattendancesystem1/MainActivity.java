package com.example.android.smartattendancesystem1;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    Toolbar toolbar;
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    RelativeLayout mRelativeLayout;

    AppCompatEditText username, password;
    TextInputLayout userLayout, passwordLayout;

    //declaring a floating action button
    FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        //referencing to the floating button
        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.fab_id);
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Floating Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        mRelativeLayout = (RelativeLayout) findViewById(R.id.activity_main);
        mRelativeLayout.setOnClickListener(null);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        mDrawerLayout.setDrawerListener(toggle);

        toggle.syncState();

        username = (AppCompatEditText)  findViewById(R.id.username_TextField);
        password = (AppCompatEditText) findViewById(R.id.password_TextField);

        userLayout = (TextInputLayout) findViewById(R.id.username_TextInputLayout);
        passwordLayout = (TextInputLayout) findViewById(R.id.password_TextInputLayout);

        userLayout.setCounterEnabled(true);
        userLayout.setCounterMaxLength(12);

        passwordLayout.setCounterEnabled(true);
        passwordLayout.setCounterMaxLength(16);

        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(username.getText().toString().isEmpty()){
                    userLayout.setErrorEnabled(true);
                    userLayout.setError("Please enter your username!");
                } else{
                    userLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if(username.getText().toString().isEmpty()){
                    userLayout.setErrorEnabled(true);
                    userLayout.setError("Please enter your username!");
                } else{
                    userLayout.setErrorEnabled(false);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.settings_id:
                Toast.makeText(this, "Settings Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Users_id:
                Toast.makeText(this, "Users Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.aboutUs_id:
                Toast.makeText(this,"About Us Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.search_id:
                Toast.makeText(this, "Search Icon Clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.inbox_id:
                Toast.makeText(this, "Inbox", Toast.LENGTH_SHORT).show();
                break;
            case R.id.starred_id:
                Toast.makeText(this, "Starred", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sent_id:
                Toast.makeText(this, "Send Messages", Toast.LENGTH_SHORT).show();
                break;
            case R.id.all_id:
                Toast.makeText(this, "All messages", Toast.LENGTH_SHORT).show();
                break;
            case R.id.trash_id:
                Toast.makeText(this, "Trash", Toast.LENGTH_SHORT).show();
                break;
            case R.id.spam_id:
                Toast.makeText(this, "Spam", Toast.LENGTH_SHORT).show();
                break;
            case R.id.draft_id:
                Toast.makeText(this, "Draft", Toast.LENGTH_SHORT).show();
                break;
            case R.id.scan_id:
                Toast.makeText(this, "Scan fingerPrint", Toast.LENGTH_SHORT).show();
                break;
        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {

        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }
}