package com.example.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Test1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_test1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        Log.i("Test", intent.getStringExtra("test1"));
        Log.i("Test", intent.getStringExtra("test2"));

        Log.i("Test1", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Test1", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Test1", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Test1", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Test1", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Test1", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Test1", "onDestroy");
    }
    
    public void gotoTest2(View view) {
        Intent messageIntent = new Intent(this, Test2Activity.class);
        messageIntent.putExtra("test1", "123");
        messageIntent.putExtra("test2", "456");
        startActivity(messageIntent);
    }

    public void returnMain(View view) {
        finish();
    }
}