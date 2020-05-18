package com.example.assignment5sender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String intentAction = "com.assignment.ACTION_SEND_MESS";
    public static final String messageKey = "com.assignment.ACTION_SEND_MESS.MESS";
    public static final String intentPermission = "com.assignment.PERMISSION_HARI";
    public static final String receiverPackageName = "com.example.assignment5receiver";
    public static final String receiverName = "com.example.assignment5receiver.CustomReceiver";
    EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendBroadcast(View v) {
        editTextMessage = findViewById(R.id.editTextMessage);
        if(editTextMessage.getText().toString().equals("")) {
            Toast.makeText(this, "Please Enter the Message!!!", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent();
        intent.setAction(intentAction);
        intent.putExtra(messageKey, editTextMessage.getText().toString());
        intent.setComponent(new ComponentName(receiverPackageName, receiverName));
        sendBroadcast(intent, intentPermission);
    }
}
