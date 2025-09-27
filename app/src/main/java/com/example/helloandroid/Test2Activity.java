package com.example.helloandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Test2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_test2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        Log.i("Test", intent.getStringExtra("test1"));
        Log.i("Test", intent.getStringExtra("test2"));

        Log.i("Test2", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Test2", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Test2", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Test2", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Test2", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Test2", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Test2", "onDestroy");
    }

    public void returnMain(View view) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("return", "返回了");
        setResult(Activity.RESULT_OK, resultIntent);

        finish();
    }
}