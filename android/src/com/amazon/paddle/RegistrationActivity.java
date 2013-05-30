package com.amazon.paddle;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class RegistrationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.registration, menu);
        return true;
    }


    /** On-Click method for login button, to switch to ProfileActivity. */
    public void goToProfileActivity() {
        //TODO: set up the intent, putExtras([user's name]), start ProfileActivity
    }
}