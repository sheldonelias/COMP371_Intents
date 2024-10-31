package com.example.comp371_intents;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    // Declares a TextView object.
    private TextView txtIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Finds the XML object in res for the TextView to transfer values from
        txtIntent = findViewById(R.id.second_activity_text);

        // Since getIntent() is called with onCreate() it is invoked on the way of
        // opening or creating the Activity. The arg of the Intent object used at the
        // creation will transfer.
        Intent intent = getIntent();


        // If there is a value in the incoming Intent...
        if(intent != null)
        {
            // Looks for the key, "message"
            if(intent.hasExtra("message"))
            {
                // One must know the data type desired, along with the name of the key.
                // Data type determines needed getStringExtra()
                String msg = intent.getStringExtra("message");

                // Pass msg to txtIntent text box
                txtIntent.setText(msg);
            }

            // Looks for the key, "local variable"
            if(intent.hasExtra("local variable"))
            {
                // One must know the data type desired, along with the name of the key.
                // Data type determines needed getIntExtra()
                int localVar = intent.getIntExtra("local variable",0);

                // Pass localVar to catlog and to Toast
                System.out.println(localVar);
                Toast.makeText(this, "localVar: " + localVar, Toast.LENGTH_SHORT).show();

            }

        }


    }
}