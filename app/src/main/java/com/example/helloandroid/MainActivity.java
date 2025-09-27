package com.example.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), (ActivityResult result) -> {
            Intent res = result.getData();
            Log.i("Test", res.getStringExtra("return"));
        });

        Log.i("Main", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Main", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Main", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Main", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Main", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Main", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Main", "onDestroy");
    }

    public void gotoTest1(View view) {
        Intent messageIntent = new Intent(this, Test1Activity.class);
        messageIntent.putExtra("test1", "123");
        messageIntent.putExtra("test2", "456");
        startActivity(messageIntent);
    }

    public void gotoTest2(View view) {
        Intent messageIntent = new Intent(this, Test2Activity.class);
        messageIntent.putExtra("test1", "789");
        messageIntent.putExtra("test2", "012");

        launcher.launch(messageIntent);
    }
}