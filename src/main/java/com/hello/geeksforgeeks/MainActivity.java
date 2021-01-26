package com.hello.geeksforgeeks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //using try catch block to handle exceptions
        try {
            // object creation of JitsiMeetConferenceOptions class by the name of options

            JitsiMeetConferenceOptions options
                    = new JitsiMeetConferenceOptions.Builder()
                    .setServerURL(new URL(""))
                    .setWelcomePageEnabled(false)
                    .build();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    // we have declared the name of onButtonClick() method in our xml file  now we are going to define it.
    public void onButtonClick(View v)
    {
        // initialize editText with method findViewById()
        // here editText will hold the name of room which is given by user
        EditText editText = findViewById(R.id.conferenceName);
        // store the string input by user in editText in an local variable named text of string type
        String text = editText.getText().toString();
        //if user has typed some text in EditText then only room will create
        if (text.length() > 0) {
            //creating a room using  JitsiMeetConferenceOptions class
            //here .setRoom() method will set the text in room name
            //here launch method with launch a new room to user where they can invite others too.

            JitsiMeetConferenceOptions options
                    = new JitsiMeetConferenceOptions.Builder()
                    .setRoom(text)
                    .build();
            JitsiMeetActivity.launch(this, options);
        }
    }
}